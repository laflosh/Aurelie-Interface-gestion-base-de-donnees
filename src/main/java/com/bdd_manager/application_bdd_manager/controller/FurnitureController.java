package com.bdd_manager.application_bdd_manager.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdd_manager.application_bdd_manager.model.Furniture;
import com.bdd_manager.application_bdd_manager.model.dto.FurnitureDto;
import com.bdd_manager.application_bdd_manager.service.FurnitureService;

/**
 * 
 */
@Controller
@RequestMapping("/api")
public class FurnitureController {

	private final Logger log = LogManager.getLogger(FurnitureController.class);
	
	@Autowired
	FurnitureService furnitureService;
	
	/**
	 * @param dto
	 * @return
	 */
	@PostMapping("/furniture")
	public ResponseEntity<Furniture> addNewFurnitureInDatabase(@RequestBody FurnitureDto dto){
		
		try {
			
			log.info("Trying to add a new furniture in database");
			
			Furniture furniture = furnitureService.addNewFurnitureInDatabase(dto);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(furniture);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			
		}
		
	}
	
}
