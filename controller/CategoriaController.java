package org.generation.lojadegames.controller;

import java.util.List;
import org.generation.lojadegames.model.CategoriaModel;
import org.generation.lojadegames.repository.CategoriaRepository;
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
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> getAllCategoria(){
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> getByIdCategoria(@PathVariable Long id){
		return categoriaRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<CategoriaModel>> getByNomeCategoria(@PathVariable String nomeCateg){
		return ResponseEntity.ok(categoriaRepository.findAllByNomeCategContainingIgnoreCase(nomeCateg));
	}
	
	@PostMapping
	public ResponseEntity<CategoriaModel> postCategoria(@RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<CategoriaModel> putCategoria(@RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable Long id) {
		categoriaRepository.deleteById(id);
	}
}