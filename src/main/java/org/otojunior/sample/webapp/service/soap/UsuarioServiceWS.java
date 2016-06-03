/**
 * 
 */
package org.otojunior.sample.webapp.service.soap;

import javax.jws.WebService;

/**
 * @author 01456231650
 *
 */
@WebService
public class UsuarioServiceWS implements IUsuarioServiceWS {
	public String olaSr(String nome) {
		return "Olá Sr. " + nome;
	}
}
