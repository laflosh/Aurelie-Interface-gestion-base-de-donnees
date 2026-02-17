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

import com.bdd_manager.application_bdd_manager.model.Site;
import com.bdd_manager.application_bdd_manager.service.SiteService;

@RestController
@RequestMapping("/api")
public class SiteController {

	private final Logger log = LogManager.getLogger(SiteController.class);
	
	@Autowired
	SiteService siteService;
	
	/**
	 * @param site
	 * @return
	 */
	@PostMapping("/site")
	public ResponseEntity<Site> addSiteInDatabase(@RequestBody Site site){
		
		try {
			
			log.info("Trying to add new site in the database");
			
			Site newSite = siteService.addNewSiteInDatabase(site);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(newSite);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			
		}
		
	}
	
}
