/**
 * 
 */
package org.otojunior.sample.webapp.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;

import org.otojunior.sample.webapp.dao.UserDao;
import org.otojunior.sample.webapp.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 01456231650
 *
 */
@Model
public class UserBean {
	private static final Logger LOG = LoggerFactory.getLogger(UserBean.class);
	
	@EJB
	private UserDao dao;
	
	/**
	 * Persistence test.
	 * @return Forward action.
	 */
	public String persistenceTest() {
		LOG.info("persistenceTest() called");
		List<User> all = dao.findAll();
		LOG.info("Size: " + all.size());
		LOG.info("Content: " + all.toString());
		return null;
	}
}
