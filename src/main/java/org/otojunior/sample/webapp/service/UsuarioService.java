/**
 * 
 */
package org.otojunior.sample.webapp.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.otojunior.sample.webapp.dao.UsuarioDao;
import org.otojunior.sample.webapp.entity.Usuario;

/**
 * @author 01456231650
 *
 */
@Stateless
@Path("/UsuarioService")
public class UsuarioService {
	@EJB
	private UsuarioDao dao;
	
	@GET
	@Path("/usuarios")
	@Produces(MediaType.APPLICATION_XML)
	public List<Usuario> getUsuarios() {
		return dao.getUsuarios();
	}
	
	@GET
	@Path("/usuariosxml")
	@Produces(MediaType.APPLICATION_XML)
	public List<Usuario> getUsuariosXml() {
		return dao.getUsuarios();
	}
	
	@GET
	@Path("/usuariosjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getUsuariosJson() {
		return dao.getUsuarios();
	}
	
	@GET
	@Path("/usuariosplain")
	@Produces(MediaType.TEXT_PLAIN)
	public List<Usuario> getUsuariosPlain() {
		return dao.getUsuarios();
	}
}
