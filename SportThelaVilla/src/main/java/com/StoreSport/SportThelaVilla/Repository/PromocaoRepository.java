package com.StoreSport.SportThelaVilla.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StoreSport.SportThelaVilla.Model.Promocao;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocao, Long> {
	public List<Promocao> findAllByNomeContainingIgnoreCase(String nome);
	public List<Promocao> findAllByDescricaoContainingIgnoreCase(String descricao);
}
