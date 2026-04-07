package com.bdd_manager.application_bdd_manager.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bdd_manager.application_bdd_manager.model.Site;

/**
 * 
 */
@Repository
public interface SiteRepository extends CrudRepository<Site, Integer> {

	public Site findByCodeSite(String codeSite);
	
	@Query("select u from Site u where u.isDeleted = false")
	Iterable<Site> getAllSiteNotSoftDelete();
	
	@Query("select u from Site u where u.isDeleted = true")
	Iterable<Site> getAllSiteSoftDelete();
	
}
