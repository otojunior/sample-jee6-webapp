/**
 * 
 */
package org.otojunior.sample.webapp.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
	
	private String nome;
	private Integer idade;
	private Double peso;
	
	/**
	 * 
	 * @return
	 */
	public Integer getIdade() {
		return idade;
	}

	/**
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the peso
	 */
	public Double getPeso() {
		return peso;
	}

	/**
	 * 
	 * @param idade
	 */
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(Double peso) {
		this.peso = peso;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}