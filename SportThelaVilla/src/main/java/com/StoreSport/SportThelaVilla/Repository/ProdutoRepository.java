package com.StoreSport.SportThelaVilla.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StoreSport.SportThelaVilla.Model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
	public List<Produto> findAllByDescricaoContainingIgnoreCase(String descricao);
	public List<Produto> findAllByPrecoLessThanEqual(double preco);
	public List<Produto> findAllByPrecoGreaterThanEqual(double preco);
	
}
