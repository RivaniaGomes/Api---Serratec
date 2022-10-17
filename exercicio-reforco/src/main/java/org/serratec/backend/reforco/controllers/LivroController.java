package org.serratec.backend.reforco.controllers;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.reforco.dto.LivroDto;
import org.serratec.backend.reforco.model.Livro;
import org.serratec.backend.reforco.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public Livro cadastrar(@RequestBody Livro livro) {
		return livroRepository.save(livro);
	}

//	@PostMapping("/lista")
//	@ResponseStatus(HttpStatus.CREATED)
//	@ApiOperation(value="Insere os dados de um Livro", notes="Inserir Livro")
//	@ApiResponses(value= {
//	@ApiResponse(code=201, message="Livro adcionado"),
//	@ApiResponse(code=401, message="Erro de autenticação"),
//	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
//	@ApiResponse(code=404, message="Recurso não encontrado"),
//	@ApiResponse(code=505, message="Exceção interna da aplicação"),
//	})
//	public List<Livro> inserirVarios(@RequestBody List<Livro> livros) {
//		return livroRepository.saveAll(livros);
//	}
//
//	@GetMapping
//	@ApiOperation(value="Lista todos os Livros", notes="Listagem de Livros")
//	@ApiResponses(value= {
//	@ApiResponse(code=200, message="Retorna todos os livros"),
//	@ApiResponse(code=401, message="Erro de autenticação"),
//	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
//	@ApiResponse(code=404, message="Recurso não encontrado"),
//	@ApiResponse(code=505, message="Exceção interna da aplicação"),
//	})
//
//	public ResponseEntity<List<Livro>> listar() {
//		List<Livro> livros = livroRepository.findAll();
//		return ResponseEntity.ok(livros);
//	}
}
