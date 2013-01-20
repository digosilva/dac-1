package org.ufpr.dac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the atividade_chamado database table.
 * 
 */
@Entity
@Table(name="atividade_chamado")
public class AtividadeChamado implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AtividadeChamadoPK id;

    @Temporal( TemporalType.DATE)
	@Column(name="data_atividade")
	private Date dataAtividade;

	private String observacao;

	//bi-directional many-to-one association to Chamado
	@ManyToOne(fetch=FetchType.LAZY)
	private Chamado chamado;

    public AtividadeChamado() {
    }

	public AtividadeChamadoPK getId() {
		return this.id;
	}

	public void setId(AtividadeChamadoPK id) {
		this.id = id;
	}
	
	public Date getDataAtividade() {
		return this.dataAtividade;
	}

	public void setDataAtividade(Date dataAtividade) {
		this.dataAtividade = dataAtividade;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Chamado getChamado() {
		return this.chamado;
	}

	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}
	
}