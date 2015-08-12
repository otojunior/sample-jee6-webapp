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
	
	public static void main(String[] args) {
		LOG.info("TesteLog::main:: Mensagem de teste do Log4J 1.2");
	}
}
