/**
 * 
 */
package org.otojunior.sample.webapp.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author 01456231650
 *
 */
@XmlRootElement(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 7686135950453373822L;
	
	private String nome;
	private Integer idade;
	
	public String getNome() {
		return nome;
	}

	@XmlElement
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	@XmlElement
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}