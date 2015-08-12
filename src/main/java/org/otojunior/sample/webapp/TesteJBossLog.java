/**
 * 
 */
package org.otojunior.sample.webapp;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 01456231650
 *
 */
@Startup
@Singleton
public class TesteJBossLog {
	private static final Logger LOG = LoggerFactory.getLogger(TesteJBossLog.class);
	
	@PostConstruct
	public void init() {
		for (int i = 1; i <= 20; i++) {
			LOG.info("TesteJBossLog_init " + i);
		}
	}
}
