/**
 * 
 */
package org.otojunior.sample.webapp.mbeans;

import javax.enterprise.inject.Model;
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
	
	public DateUtils getUtilitario() {
		return dateutils;
	}
	
	
}
