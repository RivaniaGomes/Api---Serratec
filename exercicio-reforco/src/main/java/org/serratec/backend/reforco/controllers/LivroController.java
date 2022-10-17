package org.serratec.backend.reforco.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.reforco.dto.LivroDto;
import org.serratec.backend.reforco.model.Livro;
import org.serratec.backend.reforco.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	LivroRepository livroRepository;

	@GetMapping
	public List<Livro> listaLivros() {
		return livroRepository.findAll();
	}
	
	@RequestMapping("/isbn")
    public List<LivroDto> lista(String isbn) {
        if (isbn == null) {
            List<Livro> livros = livroRepository.findAll();
            return LivroDto.converter(livros);
        } else {
            List<Livro> livros = livroRepository.findByIsbn(isbn);
            return LivroDto.converter(livros);
        }
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<LivroDto> detalhar(@PathVariable Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		if (livro.isPresent()) {
			return ResponseEntity.ok(new LivroDto(livro.get()));
		}

		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Livro cadastrar(@Valid @RequestBody Livro livro) {
		return livroRepository.save(livro);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody Livro livro) {
		if (!livroRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		livro.setIdLivro(id);
		livro = livroRepository.save(livro);
		return ResponseEntity.ok(livro);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!livroRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		livroRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
