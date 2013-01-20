package org.ufpr.dac.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the produto_nota_fiscal database table.
 * 
 */
@Embeddable
public class ProdutoNotaFiscalPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="nota_fiscal_id")
	private Long notaFiscalId;

	@Column(name="produto_id")
	private Long produtoId;

    public ProdutoNotaFiscalPK() {
    }
	public Long getNotaFiscalId() {
		return this.notaFiscalId;
	}
	public void setNotaFiscalId(Long notaFiscalId) {
		this.notaFiscalId = notaFiscalId;
	}
	public Long getProdutoId() {
		return this.produtoId;
	}
	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProdutoNotaFiscalPK)) {
			return false;
		}
		ProdutoNotaFiscalPK castOther = (ProdutoNotaFiscalPK)other;
		return 
			this.notaFiscalId.equals(castOther.notaFiscalId)
			&& this.produtoId.equals(castOther.produtoId);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.notaFiscalId.hashCode();
		hash = hash * prime + this.produtoId.hashCode();
		
		return hash;
    }
}