/**
 * 
 */
package org.otojunior.sample.webapp.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author 01456231650
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 7686135950453373822L;
	
	@XmlElement
	private String nome;

	@XmlElement
	private Integer idade;
	
	/**
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getIdade() {
		return idade;
	}

	/**
	 * 
	 * @param idade
	 */
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}