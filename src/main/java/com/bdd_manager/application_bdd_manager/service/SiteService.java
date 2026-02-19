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
	
	public Site getSiteByCodeSIte(String codeSite) {
		
		log.info("Get one site by code site in the database");
		
		Site site = siteRepository.findByCodeSite(codeSite);
		
		return site;
		
	}

	/**
	 * @param site
	 * @return
	 */
	public Site updateExistingSiteInDatabase(Site site) {

		Site existingSite = getSiteById(site.getId());
		
		if(site.getCodeSite() != null && !site.getCodeSite().equals(existingSite.getCodeSite())) {
			existingSite.setCodeSite(site.getCodeSite());
		}
		
		if(site.getRegion() != null && !site.getRegion().equals(existingSite.getRegion())) {
			existingSite.setRegion(site.getRegion());
		}
		
		if(site.getDepartment() != null && !site.getDepartment().equals(existingSite.getDepartment())) {
			existingSite.setDepartment(site.getDepartment());
		}
		
		if(site.getMicroRegion() != null && !site.getMicroRegion().equals(existingSite.getMicroRegion())) {
			existingSite.setMicroRegion(site.getMicroRegion());
		}
		
		if(site.getAncientName() != null && !site.getAncientName().equals(existingSite.getAncientName())) {
			existingSite.setAncientName(site.getAncientName());
		}
		
		if(site.getModernName() != null && !site.getModernName().equals(existingSite.getModernName())) {
			existingSite.setModernName(site.getModernName());
		}
		
		if(site.getSite() != null && !site.getSite().equals(existingSite.getSite())) {
			existingSite.setSite(site.getSite());
		}
		
		if(site.getLocality() != null && !site.getLocality().equals(existingSite.getLocality())) {
			existingSite.setLocality(site.getLocality());
		}
		
		if(site.getLatitude() != null && site.getLatitude() != existingSite.getLatitude()) {
			existingSite.setLatitude(site.getLatitude());
		}
		
		if(site.getLongitude() != null && site.getLongitude() != existingSite.getLongitude()) {
			existingSite.setLongitude(site.getLongitude());
		}
		
		if(site.getTpq() != null && site.getTpq() != existingSite.getTpq()) {
			existingSite.setTpq(site.getTpq());
		}
		
		if(site.getTaq() != null && site.getTaq() != existingSite.getTaq()) {
			existingSite.setTaq(site.getTaq());
		}
		
		if(site.getOccupation() != null && !site.getOccupation().equals(existingSite.getOccupation())) {
			existingSite.setOccupation(site.getOccupation());
		}
		
		if(site.getNatureOfExcavation() != null && !site.getNatureOfExcavation().equals(existingSite.getNatureOfExcavation())) {
			existingSite.setNatureOfExcavation(site.getNatureOfExcavation());
		}
		
		if(site.getTotalNumberSepultures() != null && site.getTotalNumberSepultures() != existingSite.getTotalNumberSepultures()) {
			existingSite.setTotalNumberSepultures(site.getTotalNumberSepultures());
		}
		
		if(site.getImmatureSepultureNumber() != null && site.getImmatureSepultureNumber() != existingSite.getImmatureSepultureNumber()) {
			existingSite.setImmatureSepultureNumber(site.getImmatureSepultureNumber());
		}
		
		if(site.getSepultureNumberVab() != null && site.getSepultureNumberVab() != existingSite.getSepultureNumberVab()) {
			existingSite.setSepultureNumberVab(site.getSepultureNumberVab());
		}
		
		if(site.getNumberSepultureStudied() != null && site.getNumberSepultureStudied() != existingSite.getNumberSepultureStudied()) {
			existingSite.setNumberSepultureStudied(site.getNumberSepultureStudied());
		}
		
		if(site.getDateExcavation() != null && !site.getDateExcavation().equals(existingSite.getDateExcavation())) {
			existingSite.setDateExcavation(site.getDateExcavation());
		}
		
		if(site.getObservation() != null && !site.getObservation().equals(existingSite.getObservation())) {
			existingSite.setObservation(site.getObservation());
		}
		
		if(site.getReference() != null && !site.getReference().equals(existingSite.getReference())) {
			existingSite.setReference(site.getReference());
		}
		
		if(site.getPicture() != null && !site.getPicture().equals(existingSite.getPicture())) {
			existingSite.setPicture(site.getPicture());
		}
		
		log.info("Update existing site in database");
		
		Site updatedSite = siteRepository.save(existingSite);
		
		return updatedSite;
		
	}

	/**
	 * @param id
	 */
	public void deleteExistingSiteInDatabse(int id) {

		log.info("Delete an existing site in database");
		
		siteRepository.deleteById(id);
		
	}
	
}
