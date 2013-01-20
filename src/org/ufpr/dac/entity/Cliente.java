package org.ufpr.dac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLIENTE_PESSOAID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLIENTE_PESSOAID_GENERATOR")
	@Column(name="pessoa_id")
	private Long pessoaId;

	private String cpf;

    @Temporal( TemporalType.DATE)
	@Column(name="data_nascimento")
	private Date dataNascimento;

	private String email;

	@Column(name="recebe_campanha")
	private Boolean recebeCampanha;

	//bi-directional many-to-one association to Chamado
	@OneToMany(mappedBy="cliente")
	private List<Chamado> chamados;

	//bi-directional one-to-one association to Cliente
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pessoa_id")
	private Cliente cliente1;

	//bi-directional one-to-one association to Cliente
	@OneToOne(mappedBy="cliente1", fetch=FetchType.LAZY)
	private Cliente cliente2;

	//bi-directional many-to-one association to Venda
	@OneToMany(mappedBy="cliente")
	private List<Venda> vendas;

    public Cliente() {
    }

	public Long getPessoaId() {
		return this.pessoaId;
	}

	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getRecebeCampanha() {
		return this.recebeCampanha;
	}

	public void setRecebeCampanha(Boolean recebeCampanha) {
		this.recebeCampanha = recebeCampanha;
	}

	public List<Chamado> getChamados() {
		return this.chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	
	public Cliente getCliente1() {
		return this.cliente1;
	}

	public void setCliente1(Cliente cliente1) {
		this.cliente1 = cliente1;
	}
	
	public Cliente getCliente2() {
		return this.cliente2;
	}

	public void setCliente2(Cliente cliente2) {
		this.cliente2 = cliente2;
	}
	
	public List<Venda> getVendas() {
		return this.vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	
}