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
 * @author 01456231650
 *
 */
@Stateless
public class UsuarioDao {
	@PersistenceContext
	private EntityManager e;

	/**
	 * 
	 * @return
	 */
	public List<Usuario> getUsuarios() {
		TypedQuery<Usuario> q = e.createNamedQuery(Usuario.QUERY_FIND_ALL, Usuario.class);
		return q.getResultList();
	}
}
