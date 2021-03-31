package com.StoreSport.SportThelaVilla.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StoreSport.SportThelaVilla.Model.Loja;

public interface LojaRepository extends JpaRepository< Loja, Long>{
	public List<Loja> findAllByNomeContainingIgnoreCase (String nome);
	public List<Loja> findAllByEnderecoContainingIgnoreCase (String endereco);	
}
