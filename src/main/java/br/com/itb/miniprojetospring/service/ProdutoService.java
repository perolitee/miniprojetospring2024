package br.com.itb.miniprojetospring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.itb.miniprojetospring.model.Produto;
import br.com.itb.miniprojetospring.model.ProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
	
	// Criar objeto repository
	final ProdutoRepository produtoRepository;
	
	// Injeção de Dependência
	public ProdutoService(ProdutoRepository _produtoRepository) {
		this.produtoRepository = _produtoRepository;
	}
	
	// Método INSERT INTO PRODUTO
	@Transactional
	public Produto save(Produto _produto) {
		return produtoRepository.save(_produto);
	}
	
	// Método SELECT * FROM PRODUTO
	public List<Produto> findAll(){
		List<Produto> lista = produtoRepository.findAll();
		return lista;
	}

	public Produto findAllById(long id){
		Produto produtoEncontrado = produtoRepository.findAllById(id);
		return produtoEncontrado;
	}

	@Transactional
	public Produto update(Produto _produto) {
		Produto produtoEncontrado = produtoRepository.findAllById(_produto.getId());
		if(produtoEncontrado.getId() > 0)
			return produtoRepository.save(produtoEncontrado);
		else
			return new Produto(0, "Produto não encontrado");
	}

	@Transactional
	public boolean delete(Produto _produto) {
		boolean sucesso = false;
		Produto produtoEncontrado = produtoRepository.findAllById(_produto.getId());
		if(produtoEncontrado.getId() > 0) {
			produtoRepository.deleteById(produtoEncontrado.getId());
			sucesso = true;
		}

		return sucesso;
	}

}
