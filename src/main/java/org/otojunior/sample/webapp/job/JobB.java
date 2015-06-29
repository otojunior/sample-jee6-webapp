/**
 * 
 */
package org.otojunior.sample.webapp.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Job B implementation.
 * @author Oto Junior (otojunior@gmail.com)
 */
public class JobB implements Job {
	private final static Logger LOG = LoggerFactory.getLogger(JobB.class); 

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		LOG.info("Job B executando: fire-id:" + context.getFireInstanceId());
	}
}
