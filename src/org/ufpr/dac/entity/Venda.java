package org.ufpr.dac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the venda database table.
 * 
 */
@Entity
public class Venda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VENDA_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VENDA_ID_GENERATOR")
	private Integer id;

	@Column(name="valor_total")
	private double valorTotal;

	//bi-directional many-to-one association to NotaFiscal
	@OneToMany(mappedBy="venda")
	private List<NotaFiscal> notaFiscals;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

    public Venda() {
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

	public List<NotaFiscal> getNotaFiscals() {
		return this.notaFiscals;
	}

	public void setNotaFiscals(List<NotaFiscal> notaFiscals) {
		this.notaFiscals = notaFiscals;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}