package com.StoreSport.SportThelaVilla.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StoreSport.SportThelaVilla.Model.Marca;

public interface MarcaRepository  extends JpaRepository<Marca, Long>{
	public List<Marca> findAllByNomeContainingIgnoreCase (String nome);
	public List<Marca> findAllByDescricaoContainingIgnoreCase (String descricao);
}
