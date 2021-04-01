package com.StoreSport.SportThelaVilla.Controller;

import java.util.*;

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

import com.StoreSport.SportThelaVilla.Model.Carrinho;
import com.StoreSport.SportThelaVilla.Repository.CarrinhoRepository;

@RestController
@RequestMapping("/carrinho")
@CrossOrigin(origins = "*")
public class CarrinhoController {

	@Autowired
	private CarrinhoRepository repository;

	@GetMapping
	public ResponseEntity<List<Carrinho>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Carrinho> findByIdCarrinho(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Carrinho> post(@RequestBody Carrinho carrinho) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(carrinho));
	}

	@PutMapping
	public ResponseEntity<Carrinho> put(@RequestBody Carrinho carrinho) {
		return ResponseEntity.ok(repository.save(carrinho));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}