/**
 * 
 */
package org.otojunior.sample.webapp;

import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.apache.commons.lang3.time.DateUtils;

/**
 * @author 01456231650
 *
 */
@Model
public class TesteBean {
	@Inject
	private DateUtils dateutils;
	
	public String getTexto() {
		return "texto de teste de injeção";
	}

	public DateUtils getUtilitario() {
		return dateutils;
	}
	
	@Produces
	public DateUtils produzir() {
		return new DateUtils();
	}
}
