package org.serratec.backend.reforco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "autor")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "au_cd_id")
	private Long idAutor;

	@NotNull
	@Column(name = "au_tx_autor", length = 40)
	private String nomeAutor;

	public Autor() {
		super();
	}

	public Autor(Long idAutor, @NotNull String nomeAutor) {
		super();
		this.idAutor = idAutor;
		this.nomeAutor = nomeAutor;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

}
