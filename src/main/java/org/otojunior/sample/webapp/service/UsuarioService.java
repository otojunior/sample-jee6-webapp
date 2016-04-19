/**
 * 
 */
package org.otojunior.sample.webapp.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	
	/**
	 * Obtém usuários, gerando um XML como resposta.
	 * @return
	 */
	@GET
	@Path("/usuariosxml")
	@Produces(MediaType.APPLICATION_XML)
	public List<Usuario> getUsuariosXml() {
		return dao.findAll();
	}
	
	/**
	 * Obtém usuários, gerando um JSON como resposta.
	 * @return
	 */
	@GET
	@Path("/usuariosjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getUsuariosJson() {
		return dao.findAll();
	}
	
	/**
	 * Obtém usuários, gerando um texto plano 
	 * (resultado do toString()) como resposta.
	 * @return
	 */
	@GET
	@Path("/usuariosplain")
	@Produces(MediaType.TEXT_PLAIN)
	public List<Usuario> getUsuariosPlain() {
		return dao.findAll();
	}
	
	/**
	 * Obtém usuário a partir do Id.
	 * OBS: Se não especificado, o RestEasy produziu XML
	 * @param id
	 * @return
	 */
	@GET
	@Path("/usuario/{id}")
	public Usuario getUsuario(@PathParam("id") Long id) {
		return dao.findById(id);
	}
}
