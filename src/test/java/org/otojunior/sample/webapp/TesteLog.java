/**
 * 
 */
package org.otojunior.sample.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 01456231650
 *
 */
public class TesteLog {
	private static final Logger LOG = LoggerFactory.getLogger(TesteLog.class);
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 1; i <= 10; i++) {
			LOG.info("xxxxx " + i);
		}
		Thread.sleep(5000);
	}
}
