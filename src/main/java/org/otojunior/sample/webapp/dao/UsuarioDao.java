/**
 * 
 */
package org.otojunior.sample.webapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.otojunior.sample.webapp.entity.Usuario;

/**
 * @author 01456231650
 *
 */
@Stateless
public class UsuarioDao {
	public List<Usuario> getUsuarios() {
		List<Usuario> lst = new ArrayList<Usuario>();
		for (int i = 0; i < 8; i++) {
			int length = RandomUtils.nextInt(10, 25);
			String nome = RandomStringUtils.random(length, true, false);
			nome = nome.toLowerCase();
			nome = StringUtils.capitalize(nome);

			Usuario u = new Usuario();
			u.setNome(nome);
			u.setIdade(RandomUtils.nextInt(1,100));
			u.setPeso(RandomUtils.nextDouble(10, 120));
			
			lst.add(u);
		}
		return lst;
	}
}
