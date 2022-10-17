package org.serratec.backend.reforco.repository;

import java.util.List;

import org.serratec.backend.reforco.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	List<Livro> findByIsbn(String isbn);

}
