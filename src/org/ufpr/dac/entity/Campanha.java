package org.ufpr.dac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the campanha database table.
 * 
 */
@Entity
public class Campanha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CAMPANHA_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAMPANHA_ID_GENERATOR")
	private Integer id;

    @Temporal( TemporalType.DATE)
	@Column(name="data_fim")
	private Date dataFim;

    @Temporal( TemporalType.DATE)
	@Column(name="data_inicio")
	private Date dataInicio;

	@Column(name="nome_campanha")
	private String nomeCampanha;

	@Column(name="valor_disponivel")
	private double valorDisponivel;

	//bi-directional many-to-one association to TipoChamado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_campanha_id")
	private TipoChamado tipoChamado;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;

    public Campanha() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getNomeCampanha() {
		return this.nomeCampanha;
	}

	public void setNomeCampanha(String nomeCampanha) {
		this.nomeCampanha = nomeCampanha;
	}

	public double getValorDisponivel() {
		return this.valorDisponivel;
	}

	public void setValorDisponivel(double valorDisponivel) {
		this.valorDisponivel = valorDisponivel;
	}

	public TipoChamado getTipoChamado() {
		return this.tipoChamado;
	}

	public void setTipoChamado(TipoChamado tipoChamado) {
		this.tipoChamado = tipoChamado;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}