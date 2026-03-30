package com.bdd_manager.application_bdd_manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bdd_manager.application_bdd_manager.model.Furniture;

/**
 * 
 */
@Repository
public interface FurnitureRepository extends CrudRepository<Furniture, Integer>{

	@Query("select u from Furniture u where u.isDeleted = false")
	Iterable<Furniture> getAllFurnitureNotSoftDelete();
	
	@Query("select u from Furniture u where u.isDeleted = true")
	Iterable<Furniture> getAllFurnitureSoftDelete();
	
	List<Furniture> findByMortuaryRepositoryId(int id);
	
}
