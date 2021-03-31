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

import com.StoreSport.SportThelaVilla.Model.Promocao;
import com.StoreSport.SportThelaVilla.Repository.PromocaoRepository;

@RestController
@RequestMapping("/promocao")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PromocaoController {

	@Autowired
	private PromocaoRepository repository;

	@GetMapping
	public ResponseEntity<List<Promocao>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Promocao> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Promocao>> GetByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}

	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Promocao>> GetByDescricao(@PathVariable String descricao) {
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}

	@PostMapping
	public ResponseEntity<Promocao> post(@RequestBody Promocao promocao) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(promocao));
	}

	@PutMapping
	public ResponseEntity<Promocao> put(@RequestBody Promocao promocao) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(promocao));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
