package org.ufpr.dac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_chamado database table.
 * 
 */
@Entity
@Table(name="tipo_chamado")
public class TipoChamado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_CHAMADO_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_CHAMADO_ID_GENERATOR")
	private Integer id;

	private String descricao;

	//bi-directional many-to-one association to Campanha
	@OneToMany(mappedBy="tipoChamado")
	private List<Campanha> campanhas;

	//bi-directional many-to-one association to Chamado
	@OneToMany(mappedBy="tipoChamado")
	private List<Chamado> chamados;

    public TipoChamado() {
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

	public List<Campanha> getCampanhas() {
		return this.campanhas;
	}

	public void setCampanhas(List<Campanha> campanhas) {
		this.campanhas = campanhas;
	}
	
	public List<Chamado> getChamados() {
		return this.chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	
}