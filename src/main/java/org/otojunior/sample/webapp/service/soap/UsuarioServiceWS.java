/**
 * 
 */
package org.otojunior.sample.webapp.service.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author 01456231650
 *
 */
@WebService
public class UsuarioServiceWS {
	@WebMethod
	public String olaSr(String nome) {
		return "Olá Sr. " + nome;
	}
}
