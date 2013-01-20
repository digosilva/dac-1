package org.ufpr.dac.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the produto_nota_fiscal database table.
 * 
 */
@Entity
@Table(name="produto_nota_fiscal")
public class ProdutoNotaFiscal implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProdutoNotaFiscalPK id;

	private double quantidade;

	@Column(name="valor_acrescimo")
	private double valorAcrescimo;

	@Column(name="valor_desconto")
	private double valorDesconto;

	//bi-directional many-to-one association to NotaFiscal
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="nota_fiscal_id")
	private NotaFiscal notaFiscal;

	//bi-directional many-to-one association to Produto
	@ManyToOne(fetch=FetchType.LAZY)
	private Produto produto;

    public ProdutoNotaFiscal() {
    }

	public ProdutoNotaFiscalPK getId() {
		return this.id;
	}

	public void setId(ProdutoNotaFiscalPK id) {
		this.id = id;
	}
	
	public double getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorAcrescimo() {
		return this.valorAcrescimo;
	}

	public void setValorAcrescimo(double valorAcrescimo) {
		this.valorAcrescimo = valorAcrescimo;
	}

	public double getValorDesconto() {
		return this.valorDesconto;
	}

	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public NotaFiscal getNotaFiscal() {
		return this.notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	
	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}