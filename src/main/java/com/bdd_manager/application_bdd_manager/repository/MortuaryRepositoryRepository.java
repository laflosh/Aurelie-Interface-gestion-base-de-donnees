package com.bdd_manager.application_bdd_manager.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bdd_manager.application_bdd_manager.model.MortuaryRepository;

/**
 * 
 */
@Repository
public interface MortuaryRepositoryRepository extends CrudRepository<MortuaryRepository, Integer>{

	public MortuaryRepository findByIssueNumber(String issue);
	
	@Query("select u from MortuaryRepository u where u.isDeleted = false")
	Iterable<MortuaryRepository> getAllMortuaryRepositoryNotSoftDelete();
	
	@Query("select u from MortuaryRepository u where u.isDeleted = true")
	Iterable<MortuaryRepository> getAllMortuaryRepositorySoftDelete();
	
}
