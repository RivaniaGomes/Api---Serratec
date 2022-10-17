package org.serratec.backend.reforco.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "livro")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "li_cd_id")
	@ApiModelProperty(value = "Identificador unico do Livro")
	private Long idLivro;

	@NotNull(message = "Preencha o titulo")
	@Column(name = "li_tx_titulo", length = 40)
	@ApiModelProperty(value = "Titulo do livro", required = true)
	private String titulo;

	@NotNull
	@Column(name = "li_tx_isbn", unique = true, length = 20)
	@ApiModelProperty(value = "Isbn do livro", required = true)
	private String isbn;

	@Column(name = "li_dt_data_publicacao")
	@ApiModelProperty(value = "Data de Publicacao do livro", required = true)
	private Date dataPublicacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cat_cd_id", referencedColumnName = "cat_cd_id")
	private Categoria categoria;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "au_cd_id", referencedColumnName = "au_cd_id")
	private Autor autor;

	public Livro() {
		super();
	}

	public Livro(Long idLivro, @NotNull(message = "Preencha o titulo") String titulo, @NotNull String isbn,
			Date dataPublicacao, Categoria categoria, Autor autor) {
		super();
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

	public Long getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
