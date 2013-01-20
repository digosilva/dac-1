package org.ufpr.dac.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the atividade_chamado database table.
 * 
 */
@Embeddable
public class AtividadeChamadoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Integer sequencia;

	@Column(name="chamado_id")
	private Long chamadoId;

    public AtividadeChamadoPK() {
    }
	public Integer getSequencia() {
		return this.sequencia;
	}
	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}
	public Long getChamadoId() {
		return this.chamadoId;
	}
	public void setChamadoId(Long chamadoId) {
		this.chamadoId = chamadoId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AtividadeChamadoPK)) {
			return false;
		}
		AtividadeChamadoPK castOther = (AtividadeChamadoPK)other;
		return 
			this.sequencia.equals(castOther.sequencia)
			&& this.chamadoId.equals(castOther.chamadoId);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.sequencia.hashCode();
		hash = hash * prime + this.chamadoId.hashCode();
		
		return hash;
    }
}