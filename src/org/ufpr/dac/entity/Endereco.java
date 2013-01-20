package org.ufpr.dac.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the endereco database table.
 * 
 */
@Entity
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENDERECO_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENDERECO_ID_GENERATOR")
	private Integer id;

	private String bairro;

	private String cep;

	private String cidade;

	private String complemento;

	private String estado;

	private String logradouro;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch=FetchType.LAZY)
	private Pessoa pessoa;

    public Endereco() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}