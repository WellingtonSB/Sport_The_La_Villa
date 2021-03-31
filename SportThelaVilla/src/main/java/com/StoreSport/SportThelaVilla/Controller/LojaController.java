package com.StoreSport.SportThelaVilla.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StoreSport.SportThelaVilla.Model.Loja;
import com.StoreSport.SportThelaVilla.Repository.LojaRepository;

@RestController
@RequestMapping("/loja")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LojaController {

	@Autowired
	private LojaRepository repository;

	@GetMapping("/{id}")
	public ResponseEntity<Loja> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping
	public ResponseEntity<List<Loja>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Loja>> GetByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}

	@GetMapping("/endereco/{endereco}")
	public ResponseEntity<List<Loja>> GetByDescricao(@PathVariable String endereco) {
		return ResponseEntity.ok(repository.findAllByEnderecoContainingIgnoreCase(endereco));
	}

	@PostMapping
	public ResponseEntity<Loja> post(@RequestBody Loja loja) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(loja));
	}

	@PutMapping
	public ResponseEntity<Loja> put(@RequestBody Loja loja) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(loja));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {

	}

}
