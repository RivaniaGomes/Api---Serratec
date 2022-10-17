package org.serratec.backend.reforco.repository;

import org.serratec.backend.reforco.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
