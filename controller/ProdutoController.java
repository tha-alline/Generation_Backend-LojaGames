package org.generation.lojadegames.controller;

import java.util.List;

import org.generation.lojadegames.model.ProdutoModel;
import org.generation.lojadegames.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> getAllProduto(){
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> getByIdProduto(@PathVariable Long id){
		return produtoRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<ProdutoModel>> getByNomeProd(@PathVariable String nomeProd){
		return ResponseEntity.ok(produtoRepository.findAllByNomeProdContainingIgnoreCase(nomeProd));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoModel> postProduto(@RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<ProdutoModel> putProduto(@RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable Long id) {
		produtoRepository.deleteById(id);
	}
}