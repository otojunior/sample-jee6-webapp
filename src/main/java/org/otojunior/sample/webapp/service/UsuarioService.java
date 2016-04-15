/**
 * 
 */
package org.otojunior.sample.webapp.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.otojunior.sample.webapp.entity.Usuario;

/**
 * @author 01456231650
 *
 */

@Path("/UsuarioService")
public class UsuarioService {
	@GET
	@Path("/usuarios")
	@Produces(MediaType.APPLICATION_XML)
	public List<Usuario> getUsuarios() {
		return lstUsuarios();
	}
	
	@GET
	@Path("/usuariosxml")
	@Produces(MediaType.APPLICATION_XML)
	public List<Usuario> getUsuariosXml() {
		return lstUsuarios();
	}
	
	@GET
	@Path("/usuariosjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getUsuariosJson() {
		return lstUsuarios();
	}
	
	@GET
	@Path("/usuariosplain")
	@Produces(MediaType.TEXT_PLAIN)
	public List<Usuario> getUsuariosPlain() {
		return lstUsuarios();
	}
	

	/**
	 * 
	 * @return
	 */
	private List<Usuario> lstUsuarios() {
		List<Usuario> lst = new ArrayList<Usuario>();
		for (int i = 0; i < 8; i++) {
			Usuario u = new Usuario();
			u.setNome("Nome Teste " + (i+1));
			u.setIdade((i+1)*10);
			lst.add(u);
		}
		return lst;
	}
}
