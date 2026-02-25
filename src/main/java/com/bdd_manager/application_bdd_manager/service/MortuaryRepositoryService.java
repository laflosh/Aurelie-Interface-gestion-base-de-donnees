package com.bdd_manager.application_bdd_manager.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdd_manager.application_bdd_manager.model.MortuaryRepository;
import com.bdd_manager.application_bdd_manager.model.Site;
import com.bdd_manager.application_bdd_manager.model.dto.MortuaryRepoDto;
import com.bdd_manager.application_bdd_manager.repository.MortuaryRepositoryRepository;

import jakarta.persistence.EntityNotFoundException;

/**
 * 
 */
@Service
public class MortuaryRepositoryService {

	private final Logger log = LogManager.getLogger(MortuaryRepositoryService.class);
	
	@Autowired
	MortuaryRepositoryRepository mortuaryRepositoryRepository;
	
	@Autowired
	SiteService siteService;

	/**
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public MortuaryRepository addMortuaryRepositoryInDatabase(MortuaryRepoDto dto) throws Exception {

		MortuaryRepository mortuaryRepo = mortuaryRepoDtoToObject(dto);
		
		log.info("Add new mortuary repository to database");
		
		MortuaryRepository mortuaryRepoAdd = mortuaryRepositoryRepository.save(mortuaryRepo);
		
		return mortuaryRepoAdd;
		
	}
	
	/**
	 * @return
	 */
	public Iterable<MortuaryRepository> getAllMortuaryRepositoryInDatabase() {
		
		log.info("Fetch all mortuary repo in database");
		
		Iterable<MortuaryRepository> mortuaryRepos = mortuaryRepositoryRepository.findAll();
		
		return mortuaryRepos;
		
	}

	/**
	 * @param id
	 * @return
	 */
	public MortuaryRepository getOneMortuaryRepositoryById(int id) {

		log.info("Fetch one mortuary repo by id");
		
		MortuaryRepository mortuaryRepo = mortuaryRepositoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Mortuary repo don't exist"));
		
		return mortuaryRepo;
		
	}
	
	/**
	 * @param mortuaryRepo
	 * @return
	 * @throws Exception 
	 */
	public MortuaryRepository updateExistingMortuaryRepositoryInDatabase(MortuaryRepoDto dto) throws Exception {
		
		MortuaryRepository existingMortuaryRepo = getOneMortuaryRepositoryById(dto.getId());
		MortuaryRepository mortuaryRepo = mortuaryRepoDtoToObject(dto);
		
		if(mortuaryRepo.getCodeSite() != null && !mortuaryRepo.getCodeSite().equals(existingMortuaryRepo.getCodeSite())) {
			existingMortuaryRepo.setCodeSite(mortuaryRepo.getCodeSite());
		}
		
		if(mortuaryRepo.getIssueNumber() != null && !mortuaryRepo.getIssueNumber().equals(existingMortuaryRepo.getIssueNumber())) {
			existingMortuaryRepo.setIssueNumber(mortuaryRepo.getIssueNumber());
		}
		
		if(mortuaryRepo.getSepultureType() != null && !mortuaryRepo.getSepultureType().equals(existingMortuaryRepo.getSepultureType())) {
			existingMortuaryRepo.setSepultureType(mortuaryRepo.getSepultureType());
		}
		
		if(mortuaryRepo.getTypologie() != null && !mortuaryRepo.getTypologie().equals(existingMortuaryRepo.getTypologie())){
			existingMortuaryRepo.setTypologie(mortuaryRepo.getTypologie());
		}
		
		if(mortuaryRepo.getSubtype() != null && !mortuaryRepo.getSubtype().equals(existingMortuaryRepo.getSubtype())) {
			existingMortuaryRepo.setSubtype(mortuaryRepo.getSubtype());
		}
		
		if(mortuaryRepo.getBurialType() != null && !mortuaryRepo.getBurialType().equals(existingMortuaryRepo.getBurialType())) {
			existingMortuaryRepo.setBurialType(mortuaryRepo.getBurialType());
		}
		
		if(mortuaryRepo.getStateOfSepulture() != null && !mortuaryRepo.getStateOfSepulture().equals(existingMortuaryRepo.getStateOfSepulture())) {
			existingMortuaryRepo.setStateOfSepulture(mortuaryRepo.getStateOfSepulture());
		}
		
		if(mortuaryRepo.getOrientation() != null && !mortuaryRepo.getOrientation().equals(existingMortuaryRepo.getOrientation())) {
			existingMortuaryRepo.setOrientation(mortuaryRepo.getOrientation());
		}
		
		if(mortuaryRepo.getTpq() != null && mortuaryRepo.getTpq() != existingMortuaryRepo.getTpq()) {
			existingMortuaryRepo.setTpq(mortuaryRepo.getTpq());
		}
		
		if(mortuaryRepo.getTaq() != null && mortuaryRepo.getTaq() != existingMortuaryRepo.getTaq()) {
			existingMortuaryRepo.setTaq(mortuaryRepo.getTaq());
		}
		
		if(mortuaryRepo.getAge() != null && !mortuaryRepo.getAge().equals(existingMortuaryRepo.getAge())) {
			existingMortuaryRepo.setAge(mortuaryRepo.getAge());
		}
		
		if(mortuaryRepo.getGender() != null && !mortuaryRepo.getGender().equals(existingMortuaryRepo.getGender())) {
			existingMortuaryRepo.setGender(mortuaryRepo.getGender());
		}
		
		if(mortuaryRepo.getFurniture() != null && !mortuaryRepo.getFurniture().equals(existingMortuaryRepo.getFurniture())) {
			existingMortuaryRepo.setFurniture(mortuaryRepo.getFurniture());
		}
		
		if(mortuaryRepo.getOriginFurniture() != null && !mortuaryRepo.getOriginFurniture().equals(existingMortuaryRepo.getOriginFurniture())) {
			existingMortuaryRepo.setOriginFurniture(mortuaryRepo.getOriginFurniture());
		}
		
		if(mortuaryRepo.getPublication() != null && !mortuaryRepo.getPublication().equals(existingMortuaryRepo.getPublication())) {
			existingMortuaryRepo.setPublication(mortuaryRepo.getPublication());
		}
		
		if(mortuaryRepo.getComment() != null && !mortuaryRepo.getComment().equals(existingMortuaryRepo.getComment())) {
			existingMortuaryRepo.setComment(mortuaryRepo.getComment());
		}
		
		if(mortuaryRepo.getPicture() != null && !mortuaryRepo.getPicture().equals(existingMortuaryRepo.getPicture())) {
			existingMortuaryRepo.setPicture(mortuaryRepo.getPicture());
		}
		
		log.info("Update an existing mortuary repo in database");
		
		MortuaryRepository updateRepo = mortuaryRepositoryRepository.save(existingMortuaryRepo);
			
		return updateRepo;
		
	}
	
	/**
	 * @param id
	 */
	public void deleteExistingMortuaryRepositoryInDatabase(int id) {

		log.info("Delete an existing mortuary repo in database");
		
		mortuaryRepositoryRepository.deleteById(id);
		
	}

	/**
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	private MortuaryRepository mortuaryRepoDtoToObject(MortuaryRepoDto dto) throws Exception {
		
		MortuaryRepository mortuaryRepo = new MortuaryRepository();
		
		if(dto.getSiteId() == null) {
			
			Site site = new Site();
			
			if(dto.getSiteId() != null && dto.getSiteId() > 0) {
				
				site = siteService.getSiteById(dto.getSiteId());
				mortuaryRepo.setSite(site);
				
			} else if(dto.getCodeSite() != null) {
				
				site = siteService.getSiteByCodeSIte(dto.getCodeSite());
				mortuaryRepo.setSite(site);
				
			} else {
				
				throw new EntityNotFoundException("Site doen't exist");
				
			}
			
		}
		
		if(dto.getId() != null) {
			mortuaryRepo.setId(dto.getId());
		}
		if(dto.getCodeSite() != null) {
			mortuaryRepo.setCodeSite(dto.getCodeSite());
		}
		mortuaryRepo.setCodeSite(dto.getCodeSite());
		mortuaryRepo.setSiteNumber(dto.getSiteNumber());
		mortuaryRepo.setIssueNumber(dto.getIssueNumber());
		mortuaryRepo.setSepultureType(dto.getSepultureType());
		mortuaryRepo.setTypologie(dto.getTypologie());
		mortuaryRepo.setSubtype(dto.getSubtype());
		mortuaryRepo.setBurialType(dto.getBurialType());
		mortuaryRepo.setStateOfSepulture(dto.getStateOfSepulture());
		mortuaryRepo.setOrientation(dto.getOrientation());
		mortuaryRepo.setTpq(dto.getTpq());
		mortuaryRepo.setTaq(dto.getTaq());
		mortuaryRepo.setAge(dto.getAge());
		mortuaryRepo.setGender(dto.getGender());
		mortuaryRepo.setFurniture(dto.getFurniture());
		mortuaryRepo.setOriginFurniture(dto.getOriginFurniture());
		mortuaryRepo.setPublication(dto.getPublication());
		mortuaryRepo.setComment(dto.getComment());
		mortuaryRepo.setPicture(dto.getPicture());
		
		return mortuaryRepo;
		
	}
	
}
