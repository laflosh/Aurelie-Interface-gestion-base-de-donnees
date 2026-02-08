package com.bdd_manager.application_bdd_manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bdd_manager.application_bdd_manager.model.User;

/**
 * 
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	
	
}
