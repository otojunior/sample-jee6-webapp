/**
 * 
 */
package org.otojunior.sample.webapp.ejb;

import java.io.Serializable;

import javax.ejb.Stateless;

import org.otojunior.sample.webapp.interceptor.TimeInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 01456231650
 *
 */
@Stateless
public class TesteInterceptorEjb implements Serializable {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = LoggerFactory.getLogger(TesteInterceptorEjb.class);

	@TimeInterceptor
	public void aplicar() {
		LOG.info("TesteInterceptorEjb.aplicar");
	}

}
