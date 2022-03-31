package org.generation.lojadegames.repository;

import java.util.List;

import org.generation.lojadegames.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{
	
	public List<ProdutoModel> findAllByNomeProdContainingIgnoreCase(String nomeProd);
}