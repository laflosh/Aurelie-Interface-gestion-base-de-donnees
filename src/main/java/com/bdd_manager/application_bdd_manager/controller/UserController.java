package com.bdd_manager.application_bdd_manager.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdd_manager.application_bdd_manager.model.User;
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
	public ResponseEntity<User> addUserInDatabase(@RequestBody User user){
		
		try {
			
			log.info("Trying to save a new user in database");
			
			User savedUser = userService.addUserInDatabase(user);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			
		}

	}
	
}
