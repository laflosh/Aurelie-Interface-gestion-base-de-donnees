package com.bdd_manager.application_bdd_manager.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdd_manager.application_bdd_manager.model.User;
import com.bdd_manager.application_bdd_manager.model.dto.UserDto;
import com.bdd_manager.application_bdd_manager.service.UserService;

/**
 * 
 */
@RestController
@RequestMapping("/api")
public class UserController {

	private final Logger log = LogManager.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	/**
	 * @param user
	 * @return
	 */
	@PostMapping("/user")
	public ResponseEntity<User> addUserInDatabase(@RequestBody UserDto user){
		
		try {
			
			log.info("Trying to save a new user in database");
			
			User savedUser = userService.addUserInDatabase(user);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			
		}

	}
	
	/**
	 * @return
	 */
	@GetMapping("/user")
	public ResponseEntity<Iterable<User>> getAllUserInDatabase(){
		
		try {
			
			log.info("Trying to fetch all users in the database");
			
			Iterable<User> users = userService.getAllUserInDatabase();
			
			return ResponseEntity.status(HttpStatus.OK).body(users);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
		}
		
	}
	
	/**
	 * @return
	 */
	@GetMapping("/user/soft-delete")
	public ResponseEntity<Iterable<User>> getAllSoftDeleteUserInDatabase(){
		
		try {
			
			log.info("Trying to fetch all soft delete user in database");
			
			Iterable<User> users = userService.getAllSoftDeleteUserInDatabase();
			
			return ResponseEntity.status(HttpStatus.OK).body(users);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
		}
		
	}
	
	/**
	 * @param id
	 * @return
	 */
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		
		try {
			
			log.info("Trying to get user by his id");
			
			User user = userService.getUserById(id);
			
			return ResponseEntity.status(HttpStatus.OK).body(user);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
		}
		
	}
	
	/**
	 * @param user
	 * @return
	 */
	@PutMapping("/user")
	public ResponseEntity<User> updateExistingUser(@RequestBody UserDto user){
		
		try {
			
			log.info("Trying to update an existing user in database");
			
			User updatedUser = userService.updateExistingUser(user);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(updatedUser);
			
		} catch(Exception e) {
			
			e.printStackTrace();
		
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		
		}
		
	}
	
	/**
	 * @param id
	 * @return
	 */
	@PutMapping("/user/{id}/soft-delete")
	public ResponseEntity<User> setSoftDeleteForUser(@PathVariable int id){
		
		try {
			
			log.info("Trying to soft delete an user");
			
			User updateUser = userService.setSoftDeleteForUser(id);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(updateUser);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			
		}
		
	}
	
	/**
	 * @param id
	 * @return
	 */
	@PutMapping("/user/{id}/unset-soft-delete")
	public ResponseEntity<User> unSetSoftDeleteForUser(@PathVariable int id){
		
		try {
			
			log.info("Trying to unset soft delete for an user");
			
			User updateUser = userService.unSetSoftDeleteForUser(id);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(updateUser);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			
		}
		
	}
	
	/**
	 * @param id
	 * @return
	 */
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteExistingUser(@PathVariable int id){
		
		try {
			
			log.info("Trying to delete an existing user in database");
			
			userService.deleteExistingUser(id);
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User delete in database");
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
		}
		
	}
	
}
