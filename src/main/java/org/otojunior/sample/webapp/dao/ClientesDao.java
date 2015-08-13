/**
 * 
 */
package org.otojunior.sample.webapp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.otojunior.sample.webapp.entity.Cliente;
import org.otojunior.sample.webapp.interceptor.TimeInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 01456231650
 *
 */
@Stateless
public class ClientesDao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(ClientesDao.class);

	@PersistenceContext
	private EntityManager em;
	
	@TimeInterceptor
	public List<Cliente> findAll() {
		List<Cliente> resultList = new ArrayList<Cliente>();
		
		TypedQuery<Cliente> query = em.createNamedQuery(Cliente.QUERY_FIND_ALL, Cliente.class);
		resultList = query.getResultList();
		
		return resultList;
	}
}
