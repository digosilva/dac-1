package org.ufpr.dac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the chamado database table.
 * 
 */
@Entity
public class Chamado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CHAMADO_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CHAMADO_ID_GENERATOR")
	private Integer id;

    @Temporal( TemporalType.DATE)
	@Column(name="data_abertura")
	private Date dataAbertura;

    @Temporal( TemporalType.DATE)
	@Column(name="data_fechamento")
	private Date dataFechamento;

	private String descricao;

	//bi-directional many-to-one association to AtividadeChamado
	@OneToMany(mappedBy="chamado")
	private List<AtividadeChamado> atividadeChamados;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	//bi-directional many-to-one association to TipoChamado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_chamado_id")
	private TipoChamado tipoChamado;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;

    public Chamado() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataAbertura() {
		return this.dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataFechamento() {
		return this.dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<AtividadeChamado> getAtividadeChamados() {
		return this.atividadeChamados;
	}

	public void setAtividadeChamados(List<AtividadeChamado> atividadeChamados) {
		this.atividadeChamados = atividadeChamados;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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