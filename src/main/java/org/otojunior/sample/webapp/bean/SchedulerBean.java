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
	 * Initializes the been constructing the jobs list.
	 * @throws SchedulerException {@link SchedulerException}
	 */
	@PostConstruct
	public void postConstruct() throws SchedulerException {
		ServletContext servletContext = (ServletContext) FacesContext.
			getCurrentInstance().
			getExternalContext().
			getContext();
		 
		//Get QuartzInitializerListener 
		StdSchedulerFactory stdSchedulerFactory = (StdSchedulerFactory) servletContext.
			getAttribute(QuartzInitializerListener.QUARTZ_FACTORY_KEY);
		
		scheduler = stdSchedulerFactory.getScheduler();
		
		// loop jobs by group, then get jobkey
		for (String groupName : scheduler.getJobGroupNames()) {
			GroupMatcher<JobKey> groupMatcher = GroupMatcher.jobGroupEquals(groupName);
			for (JobKey jobKey : scheduler.getJobKeys(groupMatcher)) {
				Trigger trigger = scheduler.getTriggersOfJob(jobKey).get(0);
				QuartzJobsDto quartzJobDto = new QuartzJobsDto(jobKey, trigger.getKey(), trigger.getNextFireTime());
				quartzJobList.add(quartzJobDto);
			}
		}
	}
	
	/**
	 * Trigger a job.
	 * @param jobName Job name.
	 * @param jobGroup Job group.
	 * @throws SchedulerException {@ink SchedulerException}
	 */
	public void resumeNow(JobKey jobKey) throws SchedulerException {
		scheduler.resumeJob(jobKey);
	}
	
	/**
	 * Trigger a job.
	 * @param jobName Job name.
	 * @param jobGroup Job group.
	 * @throws SchedulerException {@ink SchedulerException}
	 */
	public void pauseNow(JobKey jobKey) throws SchedulerException {
		scheduler.pauseJob(jobKey);
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
		return triggerState.name();
	}
	
	/**
	 * Gets the @uartz Job List.
	 * @return A list of Quartz's jobs.
	 */
	public List<QuartzJobsDto> getQuartzJobList() {
		return quartzJobList;
	}
}
