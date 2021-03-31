package com.StoreSport.SportThelaVilla.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(min = 3, max = 100)
	@Column(unique = true)
	private String nome;

	@NotNull
	@Size(max = 30)
	private String tamanho;

	@NotNull
	@Digits(integer = 5, fraction = 2)
	private double preco;

	@NotNull
	@Size(max = 9)
	private String genero;

	@NotNull
	@Size(max = 30)
	private String cor;

	@NotNull
	@URL
	private String imagem;

	@NotNull
	@Size(max = 240)
	private String descricao;

	@NotNull
	@Digits(integer = 5, fraction = 2)
	private int estoque;

	private long codigoBarra;

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Marca marca;

	@ManyToOne
	@JsonIgnoreProperties("cateogria")
	private Categoria categoria;

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

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public long getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(long codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
