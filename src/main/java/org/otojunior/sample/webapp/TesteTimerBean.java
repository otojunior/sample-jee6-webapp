/**
 * 
 */
package org.otojunior.sample.webapp;

import java.util.Date;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 01456231650
 *
 */
@Singleton
public class TesteTimerBean {
	private static Logger LOG = LoggerFactory.getLogger(TesteTimerBean.class);
	
	@Schedule(dayOfMonth="Fri", month="6", hour="10", minute="*", second="20/10")
	public void job(Timer timer) {
		LOG.info("Job executado a: " + timer.getInfo() + " " + timer.getTimeRemaining());
		
		
	}
}
