/**
 * 
 */
package org.otojunior.sample.webapp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
	private List<QuartzJob> quartzJobList = new ArrayList<>();
	
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
		
		// loop jobs by group
		for (String groupName : scheduler.getJobGroupNames()) {
			
			// get jobkey
			GroupMatcher<JobKey> groupMatcher = GroupMatcher.jobGroupEquals(groupName);
			for (JobKey jobKey : scheduler.getJobKeys(groupMatcher)) {
				String jobName = jobKey.getName();
				String jobGroup = jobKey.getGroup();

				// get job's trigger
				Trigger trigger = scheduler.getTriggersOfJob(jobKey).get(0);
				Date nextFireTime = trigger.getNextFireTime();
				
				quartzJobList.add(new QuartzJob(jobName, jobGroup, nextFireTime));
			}
		}
	}
	
	/**
	 * Trigger a job.
	 * @param jobName Job name.
	 * @param jobGroup Job group.
	 * @throws SchedulerException {@ink SchedulerException}
	 */
	public void resumeNow(String jobName, String jobGroup) throws SchedulerException {
		JobKey jobKey = new JobKey(jobName, jobGroup);
		scheduler.resumeJob(jobKey);
	}
	
	/**
	 * Trigger a job.
	 * @param jobName Job name.
	 * @param jobGroup Job group.
	 * @throws SchedulerException {@ink SchedulerException}
	 */
	public void pauseNow(String jobName, String jobGroup) throws SchedulerException {
		JobKey jobKey = new JobKey(jobName, jobGroup);
		scheduler.pauseJob(jobKey);
	}
	
	/**
	 * Gets the @uartz Job List.
	 * @return A list of Quartz's jobs.
	 */
	public List<QuartzJob> getQuartzJobList() {
		return quartzJobList;
	}
}
