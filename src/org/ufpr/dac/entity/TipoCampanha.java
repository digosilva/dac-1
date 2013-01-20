package org.ufpr.dac.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_campanha database table.
 * 
 */
@Entity
@Table(name="tipo_campanha")
public class TipoCampanha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_CAMPANHA_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_CAMPANHA_ID_GENERATOR")
	private Integer id;

	private String descricao;

    public TipoCampanha() {
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

}