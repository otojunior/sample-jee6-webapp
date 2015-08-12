/**
 * 
 */
package org.otojunior.sample.webapp;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.apache.log4j.Logger;

/**
 * @author 01456231650
 *
 */
@Named
@SessionScoped
public class TesteLogBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(TesteLogBean.class);
	
	public String aplicar() {
		LOG.info("TesteLogBean::aplicar Teste da aplicação para o Log4J em JBoss");
		return null;
	}
}
