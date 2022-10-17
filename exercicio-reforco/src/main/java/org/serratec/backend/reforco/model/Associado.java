package org.serratec.backend.reforco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Associado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "as_cd_id")
	private Long idAssociado;
	
	@NotNull
	@Column(name = "as_tx_nome_associado", length = 50)
	private String nomeAssociado;
	
	@NotNull
	@Column(name = "as_tx_telefone", length = 15)
	private String telefone;
	
	@NotNull
	@Column(name = "as_tx_cpf", length = 11)
	private String cpf;
	
	@NotNull
	@Column(name = "as_tx_logradouro", length = 80)
	private String logradouro;
	
	@NotNull
	@Column(name = "as_tx_nr", length = 10)
	private String numero;

	@NotNull
	@Column(name = "as_tx_complemento", length = 30)
	private String complemento;
	
	@NotNull
	@Column(name = "as_tx_bairro", length = 50)
	private String bairro;
	
	@NotNull
	@Column(name = "as_tx_cidade", length = 50)
	private String cidade;
	
	@NotNull
	@Column(name = "as_tx_uf", length = 2)
	private String estado;

	public Associado() {
		super();
	}

	public Associado(Long idAssociado, @NotNull String nomeAssociado, @NotNull String telefone, @NotNull String cpf,
			@NotNull String logradouro, @NotNull String numero, @NotNull String complemento, @NotNull String bairro,
			@NotNull String cidade, @NotNull String estado) {
		super();
		this.idAssociado = idAssociado;
		this.nomeAssociado = nomeAssociado;
		this.telefone = telefone;
		this.cpf = cpf;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Long getIdAssociado() {
		return idAssociado;
	}

	public void setIdAssociado(Long idAssociado) {
		this.idAssociado = idAssociado;
	}

	public String getNomeAssociado() {
		return nomeAssociado;
	}

	public void setNomeAssociado(String nomeAssociado) {
		this.nomeAssociado = nomeAssociado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
