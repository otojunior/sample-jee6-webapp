/**
 * 
 */
package org.otojunior.sample.webapp.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.otojunior.sample.webapp.ejb.TesteInterceptorEjb;

/**
 * @author 01456231650
 *
 */
@Named
@SessionScoped
public class TesteLogBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(TesteLogBean.class);
	
	@EJB
	private TesteInterceptorEjb testeInterceptorEjb;
	
	public String aplicar() {
		LOG.info("TesteLogBean.aplicar");
		testeInterceptorEjb.aplicar();
		return null;
	}
}
