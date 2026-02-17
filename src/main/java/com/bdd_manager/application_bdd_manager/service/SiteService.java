package com.bdd_manager.application_bdd_manager.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdd_manager.application_bdd_manager.model.Site;
import com.bdd_manager.application_bdd_manager.repository.SiteRepository;

/**
 * 
 */
@Service
public class SiteService {

	private final Logger log = LogManager.getLogger(SiteService.class);
	
	@Autowired
	SiteRepository siteRepository;

	/**
	 * @param site
	 * @return
	 */
	public Site addNewSiteInDatabase(Site site) {

		log.info("Add new site in database");
		
		Site newSite = siteRepository.save(site);
		
		return newSite;
		

	}

	/**
	 * @return
	 */
	public Iterable<Site> getAllSiteInDatbase() {

		log.info("Fetch all sites in database");
		
		Iterable<Site> sites = siteRepository.findAll();
		
		return sites;
		
	}

	/**
	 * @param id
	 * @return
	 */
	public Site getSiteById(int id) {
		
		log.info("Get one site by id in the database");
		
		Site site = siteRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Site not found in db"));
		
		return site;
		
	}
	
}
