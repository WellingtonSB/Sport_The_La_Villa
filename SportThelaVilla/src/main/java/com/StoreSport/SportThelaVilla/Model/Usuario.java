package com.StoreSport.SportThelaVilla.Model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(min = 2, max = 100)
	private String nome;

	@NotNull
	@Size(max = 20)
	private String email;

	@NotNull
	@Size(min = 5, max = 15)
	private String usuario;

	@NotNull
	@Size(min = 6, max = 8)
	private String senha;

	private double carrinho;

	@ManyToMany(mappedBy = "usuarios", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnoreProperties({ "nome", "tamanho", "preco", "genero", "cor", "imagem", "descricao", "codigoBarra", "marca",
			"categoria", "qtdProduto" })
	private List<Produto> produtos = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public double getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(double carrinho) {
		this.carrinho = carrinho;
	}

}
