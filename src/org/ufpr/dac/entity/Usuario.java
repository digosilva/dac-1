package org.ufpr.dac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_ID_GENERATOR")
	private Integer id;

	private String matricula;

	private String senha;

	//bi-directional many-to-one association to Campanha
	@OneToMany(mappedBy="usuario")
	private List<Campanha> campanhas;

	//bi-directional many-to-one association to Chamado
	@OneToMany(mappedBy="usuario")
	private List<Chamado> chamados;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch=FetchType.LAZY)
	private Pessoa pessoa;

    public Usuario() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Campanha> getCampanhas() {
		return this.campanhas;
	}

	public void setCampanhas(List<Campanha> campanhas) {
		this.campanhas = campanhas;
	}
	
	public List<Chamado> getChamados() {
		return this.chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	
	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}