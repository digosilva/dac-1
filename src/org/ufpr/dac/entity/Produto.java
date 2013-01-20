package org.ufpr.dac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the produto database table.
 * 
 */
@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRODUTO_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUTO_ID_GENERATOR")
	private Integer id;

	private String descricao;

	@Column(name="valor_compra")
	private double valorCompra;

	@Column(name="valor_venda")
	private double valorVenda;

	//bi-directional many-to-one association to Fornecedor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fornecedor_id")
	private Fornecedor fornecedor;

	//bi-directional many-to-one association to ProdutoNotaFiscal
	@OneToMany(mappedBy="produto")
	private List<ProdutoNotaFiscal> produtoNotaFiscals;

    public Produto() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorCompra() {
		return this.valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public double getValorVenda() {
		return this.valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public List<ProdutoNotaFiscal> getProdutoNotaFiscals() {
		return this.produtoNotaFiscals;
	}

	public void setProdutoNotaFiscals(List<ProdutoNotaFiscal> produtoNotaFiscals) {
		this.produtoNotaFiscals = produtoNotaFiscals;
	}
	
}