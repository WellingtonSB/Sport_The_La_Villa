package com.StoreSport.SportThelaVilla.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StoreSport.SportThelaVilla.Model.Categoria;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {
	public List<Categoria> findAllByNomeContainingIgnoreCase (String nome);
}