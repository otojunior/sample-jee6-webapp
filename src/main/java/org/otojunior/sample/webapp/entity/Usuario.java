/**
 * 
 */
package org.otojunior.sample.webapp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Version;
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
@Entity
@NamedQueries({ 
	@NamedQuery(name = Usuario.QUERY_FIND_ALL, query = "select u from Usuario u")
})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 7686135950453373822L;
	
	public static final String QUERY_FIND_ALL = "query.usuario.findAll";
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Version
	private Long version;
	
	private String nome;
	private Integer idade;
	private Double peso;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
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
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @param version the version to set
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}