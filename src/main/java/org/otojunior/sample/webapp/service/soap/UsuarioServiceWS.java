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
@WebService(endpointInterface="org.otojunior.sample.webapp.service.soap.IUsuarioServiceWS")
public class UsuarioServiceWS implements IUsuarioServiceWS {
	@WebMethod
	public String olaSr(String nome) {
		return "Olá Sr. " + nome;
	}
}
