/**
 * 
 */
package org.otojunior.sample.webapp.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.RandomUtils;
import org.otojunior.sample.webapp.entity.Usuario;

/**
 * Inicializa o banco de usuario (banco para testes da aplicação).
 * @author Oto Junior
 *
 */
@Singleton
@Startup
public class UsuarioInitService {
	@PersistenceContext
	private EntityManager e;
	
	/**
	 * 
	 */
	@PostConstruct
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void init() {
		for (int i = 1; i <= 5; i++) {
			Usuario u = new Usuario();
			u.setNome("Nome do Usuario " + i);
			u.setIdade(RandomUtils.nextInt(1,100));
			u.setPeso(RandomUtils.nextDouble(10, 120));
			e.persist(u);
		}
	}
}
