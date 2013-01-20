package org.ufpr.dac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pessoa database table.
 * 
 */
@Entity
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PESSOA_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PESSOA_ID_GENERATOR")
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to Endereco
	@OneToMany(mappedBy="pessoa")
	private List<Endereco> enderecos;

	//bi-directional one-to-one association to Fornecedor
	@OneToOne(mappedBy="pessoa", fetch=FetchType.LAZY)
	private Fornecedor fornecedor;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="pessoa")
	private List<Usuario> usuarios;

    public Pessoa() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}