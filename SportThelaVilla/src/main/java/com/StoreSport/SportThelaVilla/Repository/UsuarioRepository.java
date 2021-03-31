package com.StoreSport.SportThelaVilla.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StoreSport.SportThelaVilla.Model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	public Optional<Usuario>  findByUsuario(String usuario);
}
