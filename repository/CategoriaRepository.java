package org.generation.lojadegames.repository;

import java.util.List;
import org.generation.lojadegames.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{
	
	public List<CategoriaModel> findAllByNomeCategContainingIgnoreCase(String nomeCateg);
}