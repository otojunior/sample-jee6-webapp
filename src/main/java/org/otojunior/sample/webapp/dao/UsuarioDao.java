/**
 * 
 */
package org.otojunior.sample.webapp.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.otojunior.sample.webapp.entity.Usuario;

/**
 * DAO de Usuario.
 * @author Oto Junior
 */
@Stateless
public class UsuarioDao {
	@PersistenceContext
	private EntityManager e;

	/**
	 * Busca por todos
	 * @return
	 */
	public List<Usuario> findAll() {
		TypedQuery<Usuario> q = e.createNamedQuery(Usuario.QUERY_FIND_ALL, Usuario.class);
		return q.getResultList();
	}
	
	/**
	 * Busca por id
	 * @return
	 */
	public Usuario findById(Long id) {
		return e.find(Usuario.class, id);
	}
}
