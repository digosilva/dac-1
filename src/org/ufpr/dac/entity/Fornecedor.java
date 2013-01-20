package org.ufpr.dac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fornecedor database table.
 * 
 */
@Entity
public class Fornecedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FORNECEDOR_PESSOAID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FORNECEDOR_PESSOAID_GENERATOR")
	@Column(name="pessoa_id")
	private Long pessoaId;

	private Boolean ativo;

	private String cnpj;

	//bi-directional many-to-one association to Compra
	@OneToMany(mappedBy="fornecedor")
	private List<Compra> compras;

	//bi-directional one-to-one association to Pessoa
	@OneToOne(fetch=FetchType.LAZY)
	private Pessoa pessoa;

	//bi-directional many-to-one association to Produto
	@OneToMany(mappedBy="fornecedor")
	private List<Produto> produtos;

    public Fornecedor() {
    }

	public Long getPessoaId() {
		return this.pessoaId;
	}

	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}

	public Boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	
	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}