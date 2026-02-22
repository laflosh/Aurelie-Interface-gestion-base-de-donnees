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

import com.bdd_manager.application_bdd_manager.model.MortuaryRepository;
import com.bdd_manager.application_bdd_manager.model.dto.MortuaryCreateDto;
import com.bdd_manager.application_bdd_manager.service.MortuaryRepositoryService;

/**
 * 
 */
@RestController
@RequestMapping("/api")
public class MortuaryRepositoryController {

	private final Logger log = LogManager.getLogger(MortuaryRepositoryController.class);
	
	@Autowired
	MortuaryRepositoryService mortuaryRepositoryService;
	
	/**
	 * @param dto
	 * @return
	 */
	@PostMapping("/mortuary-repo")
	public ResponseEntity<MortuaryRepository> addMortuaryRepositoryInDatabase(@RequestBody MortuaryCreateDto dto){
		
		try {
			
			log.info("Trying to add a new mortuary repository to the database");
			
			MortuaryRepository mortuaryRepo = mortuaryRepositoryService.addMortuaryRepositoryInDatabase(dto);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(mortuaryRepo);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			
		}
		
	}
	
	/**
	 * @return
	 */
	@GetMapping("/mortuary-repo")
	public ResponseEntity<Iterable<MortuaryRepository>> getAllMortuaryRepositoryInDatabase(){
		
		try {
			
			log.info("Trying to get all mortuary repo in database");
			
			Iterable<MortuaryRepository> mortuaryRepos = mortuaryRepositoryService.getAllMortuaryRepositoryInDatabase();
			
			return ResponseEntity.status(HttpStatus.OK).body(mortuaryRepos);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
		}
		
	}
	
	/**
	 * @param id
	 * @return
	 */
	@GetMapping("/mortuary-repo/{id}")
	public ResponseEntity<MortuaryRepository> getOneMortuaryRepositoryById(@PathVariable int id){
		
		try {
			
			log.info("Trying to fetch one mortuary repo by id");
			
			MortuaryRepository mortuaryRepo = mortuaryRepositoryService.getOneMortuaryRepositoryById(id);
			
			return ResponseEntity.status(HttpStatus.OK).body(mortuaryRepo);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
		}
		
	}
	
	/**
	 * @param mortuaryRepo
	 * @return
	 */
	@PutMapping("/mortuary-repo")
	public ResponseEntity<MortuaryRepository> updateExistingMortuaryRepositoryInDatabase(@RequestBody MortuaryCreateDto dto){
		
		try {
			
			log.info("Trying to update an existing mortuary repository in database");
			
			MortuaryRepository updateMortuaryRepo = mortuaryRepositoryService.updateExistingMortuaryRepositoryInDatabase(dto);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(updateMortuaryRepo);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			
		}
		
	}
	
	/**
	 * @param id
	 * @return
	 */
	@DeleteMapping("/mortuary-repo/{id}")
	public ResponseEntity<String> deleteExistingMortuaryRepositoryInDatabase(@PathVariable int id){
		
		try {
			
			log.info("Trying to delete an existing mortuary repo in database");
			
			mortuaryRepositoryService.deleteExistingMortuaryRepositoryInDatabase(id);
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Mortuary repo deleted");
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
		}
		
	}
	
}
