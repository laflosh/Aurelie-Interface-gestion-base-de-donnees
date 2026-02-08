package com.bdd_manager.application_bdd_manager.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bdd_manager.application_bdd_manager.model.User;
import com.bdd_manager.application_bdd_manager.repository.UserRepository;

/**
 * 
 */
@Service
public class UserService {

	private final Logger log = LogManager.getLogger(UserService.class);
	
	@Autowired
	UserRepository userRepository;

	/**
	 * @param user
	 * @return
	 */
	public User addUserInDatabase(User user) {

		log.info("Saving a new user in database");
		
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		
		User savedUser = userRepository.save(user);
		
		return savedUser;
		
	}
	
}
