/**
 * 
 */
package org.otojunior.sample.webapp.bean;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.otojunior.sample.webapp.dao.ClientesDao;
import org.otojunior.sample.webapp.entity.Cliente;

/**
 * @author 01456231650
 *
 */
@Named
@RequestScoped
public class ClienteBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(ClienteBean.class);
	
	@EJB
	private ClientesDao dao;
	
	private List<Cliente> clientes = Collections.emptyList();
	
	public String pesquisar() {
		LOG.info("ClienteBean.pesquisar chamado");
		clientes = dao.findAll();
		return null;
	}

	/**
	 * @return the clientes
	 */
	public List<Cliente> getClientes() {
		return clientes;
	}

	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
