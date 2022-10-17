package org.serratec.backend.reforco.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.backend.reforco.model.Livro;

public class LivroDto {
	private String id;
	private String titulo;
	private String categoria;
	private String autor;

	public LivroDto(Livro livro) {
		this.id = livro.getIsbn();
		this.titulo = livro.getTitulo();
		this.categoria = livro.getCategoria().getNomeCategoria();
		this.autor = livro.getAutor().getNomeAutor();
	}

	public LivroDto() {
		super();
	}

	public String getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getAutor() {
		return autor;
	}

	public static List<LivroDto> converter(List<Livro> livros) {
		return livros.stream().map(LivroDto::new).collect(Collectors.toList());
	}

}
