/**
 * 
 */
package org.otojunior.sample.webapp.fabricas;

import javax.enterprise.inject.Produces;

import org.apache.commons.lang3.time.DateUtils;

/**
 * @author Oto
 *
 */
public class FabricaCDIs {
	/*
	 * Este DateUtils é uma classe que está dentro de um JAR
	 */
	@Produces
	public DateUtils produzir() {
		return new DateUtils();
	}
}
