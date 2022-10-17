package org.serratec.backend.reforco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emprestimo_livro")
public class EmprestimoLivro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "el_cd_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "em_cd_id", referencedColumnName = "em_cd_id")
	private Emprestimo emprestimos;
	
	@ManyToOne
	@JoinColumn(name = "li_cd_id", referencedColumnName = "li_cd_id")
	private Livro livros;
	
	@Column(name = "el_tx_obs_emprestimo", length = 200)
	private String observacoesAtoEmprestimo;

	public EmprestimoLivro() {
		super();
	}

	public EmprestimoLivro(Long id, Emprestimo emprestimos, Livro livros, String observacoesAtoEmprestimo) {
		super();
		this.id = id;
		this.emprestimos = emprestimos;
		this.livros = livros;
		this.observacoesAtoEmprestimo = observacoesAtoEmprestimo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Emprestimo getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(Emprestimo emprestimos) {
		this.emprestimos = emprestimos;
	}

	public Livro getLivros() {
		return livros;
	}

	public void setLivros(Livro livros) {
		this.livros = livros;
	}

	public String getObservacoesAtoEmprestimo() {
		return observacoesAtoEmprestimo;
	}

	public void setObservacoesAtoEmprestimo(String observacoesAtoEmprestimo) {
		this.observacoesAtoEmprestimo = observacoesAtoEmprestimo;
	}
	
	
}
