/**
 * 
 */
package org.otojunior.sample.webapp.dto;

import java.io.Serializable;
import java.util.Date;

import org.quartz.JobKey;
import org.quartz.TriggerKey;

/**
 * Represents a Job Quartz object.
 * @author Oto Junior (otojunior@gmail.com)
 */
public class QuartzJobsDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private JobKey jobKey;
	private TriggerKey triggerKey;
	private Date nextFireTime;
	
	/**
	 * @param nextFireTime 
	 * @param jobName
	 * @param jobGroup
	 * @param nextFireTime
	 */
	public QuartzJobsDto(JobKey jobKey, TriggerKey triggerKey, Date nextFireTime) {
		this.jobKey = jobKey;
		this.triggerKey = triggerKey;
		this.nextFireTime = nextFireTime;
	}

	/**
	 * @return the jobKey
	 */
	public JobKey getJobKey() {
		return jobKey;
	}

	/**
	 * @param jobKey the jobKey to set
	 */
	public void setJobKey(JobKey jobKey) {
		this.jobKey = jobKey;
	}

	/**
	 * @return the triggerKey
	 */
	public TriggerKey getTriggerKey() {
		return triggerKey;
	}

	/**
	 * @param triggerKey the triggerKey to set
	 */
	public void setTriggerKey(TriggerKey triggerKey) {
		this.triggerKey = triggerKey;
	}

	/**
	 * @return the nextFireTime
	 */
	public Date getNextFireTime() {
		return nextFireTime;
	}

	/**
	 * @param nextFireTime the nextFireTime to set
	 */
	public void setNextFireTime(Date nextFireTime) {
		this.nextFireTime = nextFireTime;
	}
}
