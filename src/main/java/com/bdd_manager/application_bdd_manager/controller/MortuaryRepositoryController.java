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
	
}
