package com.bdd_manager.application_bdd_manager.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	@Autowired
	PasswordEncoder encoder;

	/**
	 * @param user
	 * @return
	 */
	public User addUserInDatabase(User user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		log.info("Saving a new user in database");
		
		User savedUser = userRepository.save(user);
		
		return savedUser;
		
	}

	/**
	 * @return
	 */
	public Iterable<User> getAllUserInDatabase() {
		
		log.info("Fetch all users in the database");
		
		Iterable<User> users = userRepository.findAll();
		
		return users;
		
	}

	/**
	 * @param id
	 * @return
	 */
	public User getUserById(int id) {
		
		log.info("Fetch one existing user by his id");
		
		User user = userRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("User not found"));
		
		return user;
		
	}

	/**
	 * @param user
	 * @return
	 */
	public User updateExistingUser(User user) {

		User existingUser = getUserById(user.getId());
		
		if(user.getFirstname() != null && !user.getFirstname().equals(existingUser.getFirstname())) {
			existingUser.setFirstname(user.getFirstname());
		}
		
		if(user.getName() != null && !user.getName().equals(existingUser.getName())) {
			existingUser.setName(user.getName());
		}
		
		if(user.getMail() != null && !user.getMail().equals(existingUser.getMail())) {
			existingUser.setMail(user.getMail());
		}
		
		if(user.getPassword() != null && !encoder.encode(user.getPassword()).equals(existingUser.getPassword())) {
			existingUser.setPassword(encoder.encode(user.getPassword()));
		}
		
		if(user.getRole() != null && !user.getRole().equals(existingUser.getRole())) {
			existingUser.setRole(user.getRole());
		}
		
		if(user.getUsername() != null && !user.getUsername().equals(existingUser.getUsername())) {
			existingUser.setUsername(user.getUsername());
		}
		
		log.info("Updating existing user in database");
		
		User updatedUser = userRepository.save(existingUser);
		
		return updatedUser;
		
	}
	
}
