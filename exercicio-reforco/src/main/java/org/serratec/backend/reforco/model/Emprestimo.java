package org.serratec.backend.reforco.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "em_cd_id")
	private Long idEmprestimo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "as_cd_id", referencedColumnName = "as_cd_id")
	private Associado associado;
	
	@NotNull
	@Column(name = "em_dt_data_emprestimo")
	private Date dataEmprestimo;

	public Emprestimo() {
		super();
	}

	public Emprestimo(Long idEmprestimo, @NotNull Associado associado, @NotNull Date dataEmprestimo) {
		super();
		this.idEmprestimo = idEmprestimo;
		this.associado = associado;
		this.dataEmprestimo = dataEmprestimo;
	}

	public Long getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(Long idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	
}
