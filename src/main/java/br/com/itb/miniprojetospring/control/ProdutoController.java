package br.com.itb.miniprojetospring.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.itb.miniprojetospring.model.Produto;
import br.com.itb.miniprojetospring.service.ProdutoService;

@RestController
@CrossOrigin(origins="*", maxAge = 3600, allowCredentials = "false")
@RequestMapping("/produto")
public class ProdutoController {
	
	// criação do objeto de serviço
	final ProdutoService produtoService;
	
	// Injeção de Dependência
	public ProdutoController(ProdutoService _produtoService) {
		this.produtoService = _produtoService;
	}
	
	// ROTA POST
	@PostMapping
	public ResponseEntity<Object> saveProduto(@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(produtoService.save(produto));
	}
	
	// ROTA GET
	@GetMapping
	public ResponseEntity<List<Produto>> getAllProdutos(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(produtoService.findAll());
	}

	@PutMapping
	public ResponseEntity<Object> updateProduto(@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(produtoService.update(produto));
	}

	@DeleteMapping
	public ResponseEntity<Object> deleteProduto(@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(produtoService.delete(produto));
	}
	
}
