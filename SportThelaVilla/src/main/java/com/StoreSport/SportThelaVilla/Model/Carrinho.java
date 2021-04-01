package com.StoreSport.SportThelaVilla.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carrinho")
public class Carrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private double carrinho;
	// List<Usuario> usuario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(double carrinho) {
		this.carrinho = carrinho;
	}

}
