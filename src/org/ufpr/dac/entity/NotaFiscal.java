package org.ufpr.dac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nota_fiscal database table.
 * 
 */
@Entity
@Table(name="nota_fiscal")
public class NotaFiscal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NOTA_FISCAL_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOTA_FISCAL_ID_GENERATOR")
	private Integer id;

	private String observacao;

	//bi-directional many-to-one association to Compra
	@ManyToOne(fetch=FetchType.LAZY)
	private Compra compra;

	//bi-directional many-to-one association to Venda
	@ManyToOne(fetch=FetchType.LAZY)
	private Venda venda;

	//bi-directional many-to-one association to ProdutoNotaFiscal
	@OneToMany(mappedBy="notaFiscal")
	private List<ProdutoNotaFiscal> produtoNotaFiscals;

    public NotaFiscal() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Compra getCompra() {
		return this.compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	public Venda getVenda() {
		return this.venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public List<ProdutoNotaFiscal> getProdutoNotaFiscals() {
		return this.produtoNotaFiscals;
	}

	public void setProdutoNotaFiscals(List<ProdutoNotaFiscal> produtoNotaFiscals) {
		this.produtoNotaFiscals = produtoNotaFiscals;
	}
	
}