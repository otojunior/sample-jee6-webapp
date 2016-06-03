/**
 * 
 */
package org.otojunior.sample.webapp.service.soap;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.otojunior.sample.webapp.entity.Usuario;

/**
 * @author 01456231650
 *
 */
@Local
@Stateless
@WebService
public interface IUsuarioServiceWS {
	
	@WebMethod
	public List<Usuario> getUsuarios();
	
	@WebMethod
	public Usuario getUsuario(Long id);
}
