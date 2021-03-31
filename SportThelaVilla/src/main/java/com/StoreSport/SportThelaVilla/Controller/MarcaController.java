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
import com.StoreSport.SportThelaVilla.Model.Marca;
import com.StoreSport.SportThelaVilla.Repository.MarcaRepository;

@RestController
@RequestMapping("/marca")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MarcaController {

	@Autowired
	private MarcaRepository repository;

	@GetMapping("/{id}")
	public ResponseEntity<Marca> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping
	public ResponseEntity<List<Marca>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Marca>> GetByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}

	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Marca>> GetByDescricao(@PathVariable String descricao) {
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}

	@PostMapping
	public ResponseEntity<Marca> post(@RequestBody Marca marca) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(marca));
	}

	@PutMapping
	public ResponseEntity<Marca> put(@RequestBody Marca marca) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(marca));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {

	}

}
