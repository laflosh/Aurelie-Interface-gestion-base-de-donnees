package com.bdd_manager.application_bdd_manager.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bdd_manager.application_bdd_manager.model.User;

/**
 * 
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("select u from User u where u.isDeleted = false")
	Iterable<User> getAllUserNotSoftDelete();
	
	@Query("select u from User u where u.isDeleted = true")
	Iterable<User> getAllUserSoftDelete();
	
}
