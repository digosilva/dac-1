package org.ufpr.dac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the compra database table.
 * 
 */
@Entity
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMPRA_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMPRA_ID_GENERATOR")
	private Integer id;

	@Column(name="valor_total")
	private double valorTotal;

	//bi-directional many-to-one association to Fornecedor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fornecedor_id")
	private Fornecedor fornecedor;

	//bi-directional many-to-one association to NotaFiscal
	@OneToMany(mappedBy="compra")
	private List<NotaFiscal> notaFiscals;

    public Compra() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public List<NotaFiscal> getNotaFiscals() {
		return this.notaFiscals;
	}

	public void setNotaFiscals(List<NotaFiscal> notaFiscals) {
		this.notaFiscals = notaFiscals;
	}
	
}