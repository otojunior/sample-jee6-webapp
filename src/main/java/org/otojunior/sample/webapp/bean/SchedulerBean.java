/**
 * 
 */
package org.otojunior.sample.webapp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.otojunior.sample.webapp.dto.QuartzJobsDto;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.Trigger.TriggerState;
import org.quartz.TriggerKey;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

/**
 * Scheduler managed bean.
 * @author Oto Junior (otojunior@gmail.com)
 */
@Named("scheduler")
@SessionScoped
public class SchedulerBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Scheduler scheduler;
	private List<QuartzJobsDto> quartzJobList = new ArrayList<>();
	
	/**
	 * 
	 * @param quartzJobsDto
	 * @throws SchedulerException
	 */
	public void action(QuartzJobsDto quartzJobsDto) throws SchedulerException {
		TriggerState triggerState = scheduler.getTriggerState(quartzJobsDto.getTriggerKey());
		if (TriggerState.PAUSED.equals(triggerState)) {
			scheduler.resumeJob(quartzJobsDto.getJobKey());
		} else {
			scheduler.pauseJob(quartzJobsDto.getJobKey());
		}
	}
	
	/**
	 * 
	 * @param quartzJobsDto
	 * @return
	 * @throws SchedulerException
	 */
	public String actionLabel(QuartzJobsDto quartzJobsDto) throws SchedulerException {
		TriggerState triggerState = scheduler.getTriggerState(quartzJobsDto.getTriggerKey());
		return TriggerState.PAUSED.equals(triggerState) ? "Resume" : "Pause";
	}
		
	/**
	 * Gets the @uartz Job List.
	 * @return A list of Quartz's jobs.
	 */
	public List<QuartzJobsDto> getQuartzJobList() {
		return quartzJobList;
	}		
	
	
	/**
	 * Gte the trigger state.
	 * @param jobName
	 * @param jobGroup
	 * @return
	 * @throws SchedulerException
	 */
	public String getState(TriggerKey triggerKey) throws SchedulerException {
		TriggerState triggerState = scheduler.getTriggerState(triggerKey);
		return StringUtils.capitalize(triggerState.name().toLowerCase());
	}
	
	/**
	 * Initializes the been constructing the jobs list.
	 * @throws SchedulerException {@link SchedulerException}
	 */
	@PostConstruct
	public void postConstruct() throws SchedulerException {
		initScheduler();
		
		// loop jobs by group, then get jobkey
		for (String groupName : scheduler.getJobGroupNames()) {
			GroupMatcher<JobKey> groupMatcher = GroupMatcher.jobGroupEquals(groupName);
			for (JobKey jobKey : scheduler.getJobKeys(groupMatcher)) {
				quartzJobList.add(createQuartzJobsDto(jobKey));
			}
		}
	}
	
	/**
	 * Creates {@link QuartzJobsDto}
	 * @param jobKey Job Key.
	 * @return {@link QuartzJobsDto} element.
	 * @throws SchedulerException SchedulerException.
	 */
	private QuartzJobsDto createQuartzJobsDto(JobKey jobKey) throws SchedulerException {
		Trigger trigger = scheduler.getTriggersOfJob(jobKey).get(0);
		return new QuartzJobsDto(jobKey, trigger.getKey(), trigger.getNextFireTime());
	}
	
	/**
	 * Init Scheduler.
	 * @throws SchedulerException
	 */
	private void initScheduler() throws SchedulerException {
		ServletContext servletContext = (ServletContext) FacesContext.
				getCurrentInstance().
				getExternalContext().
				getContext();
			 
		//Get QuartzInitializerListener 
		StdSchedulerFactory stdSchedulerFactory = (StdSchedulerFactory) servletContext.
			getAttribute(QuartzInitializerListener.QUARTZ_FACTORY_KEY);
		
		scheduler = stdSchedulerFactory.getScheduler();
	}
}
