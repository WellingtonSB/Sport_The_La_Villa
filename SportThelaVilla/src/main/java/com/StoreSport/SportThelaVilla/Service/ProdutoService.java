package com.StoreSport.SportThelaVilla.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreSport.SportThelaVilla.Model.Produto;
import com.StoreSport.SportThelaVilla.Repository.ProdutoRepository;

@Service
public class ProdutoService {
	Random aleatorio = new Random(9000);
	
	@Autowired
	private ProdutoRepository repository;

	public Produto cadastrarProduto(Produto produto) {

		List<Produto> produtos = repository.findAll();

		int last = produtos.size()- 1;

		if (produtos.size() != 0) {

			produto.setCodigoBarra(produtos.get(last).getCodigoBarra() + aleatorio.nextInt(999));
			repository.save(produto);

		} else {
			produto.setCodigoBarra(199999);
			repository.save(produto);
		}

		return produto;
	}
}
