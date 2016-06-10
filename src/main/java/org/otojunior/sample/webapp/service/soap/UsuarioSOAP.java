/**
 * 
 */
package org.otojunior.sample.webapp.service.soap;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebService;

import org.otojunior.sample.webapp.dao.UsuarioDao;
import org.otojunior.sample.webapp.entity.Usuario;

/**
 * @author 01456231650
 *
 */

@WebService
public class UsuarioSOAP implements IUsuarioSOAP {
	@EJB
	private UsuarioDao dao;
	
	/**
	 * 
	 */
	public List<Usuario> getUsuarios() {
		return dao.findAll();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Usuario getUsuario(Long id) {
		return dao.findById(id);
	}
}
