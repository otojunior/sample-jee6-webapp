/**
 * 
 */
package org.otojunior.sample.webapp.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents a Job Quartz object.
 * @author Oto Junior (otojunior@gmail.com)
 */
public class QuartzJob implements Serializable {
	private static final long serialVersionUID = 1L;

	private String jobName;
	private String jobGroup;
	private Date nextFireTime;
	
	/**
	 * @param jobName
	 * @param jobGroup
	 * @param nextFireTime
	 */
	public QuartzJob(String jobName, String jobGroup, Date nextFireTime) {
		this.jobName = jobName;
		this.jobGroup = jobGroup;
		this.nextFireTime = nextFireTime;
	}
	
	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}
	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	/**
	 * @return the jobGroup
	 */
	public String getJobGroup() {
		return jobGroup;
	}
	/**
	 * @param jobGroup the jobGroup to set
	 */
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
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
