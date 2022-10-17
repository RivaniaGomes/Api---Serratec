package org.serratec.backend.reforco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "livro_autor")
public class LivroAutor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "la_cd_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "li_cd_id", referencedColumnName = "li_cd_id")
	private Livro livros;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "au_cd_id", referencedColumnName = "au_cd_id")
	private Autor autores;

	public LivroAutor() {
		super();
	}

	public LivroAutor(Long id, Livro livros, Autor autores) {
		super();
		this.id = id;
		this.livros = livros;
		this.autores = autores;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Livro getLivros() {
		return livros;
	}

	public void setLivros(Livro livros) {
		this.livros = livros;
	}

	public Autor getAutores() {
		return autores;
	}

	public void setAutores(Autor autores) {
		this.autores = autores;
	}

}
