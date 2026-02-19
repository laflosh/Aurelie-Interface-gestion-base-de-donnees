package com.bdd_manager.application_bdd_manager.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdd_manager.application_bdd_manager.model.MortuaryRepository;
import com.bdd_manager.application_bdd_manager.model.Site;
import com.bdd_manager.application_bdd_manager.model.dto.MortuaryCreateDto;
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

	public MortuaryRepository addMortuaryRepositoryInDatabase(MortuaryCreateDto dto) throws Exception {

		MortuaryRepository mortuaryRepo = mortuaryRepoDtoToObject(dto);
		
		log.info("Add new mortuary repository to database");
		
		MortuaryRepository mortuaryRepoAdd = mortuaryRepositoryRepository.save(mortuaryRepo);
		
		return mortuaryRepoAdd;
		
	}

	private MortuaryRepository mortuaryRepoDtoToObject(MortuaryCreateDto dto) throws Exception {
		
		Site site = new Site();
		
		if(dto.getSiteId() != null && dto.getSiteId() > 0) {
			
			site = siteService.getSiteById(dto.getSiteId());
			
		} else if(dto.getCodeSite() != null) {
			
			site = siteService.getSiteByCodeSIte(dto.getCodeSite());
			
		} else {
			
			throw new EntityNotFoundException("Site doen't exist");
			
		}
		
		MortuaryRepository mortuaryRepo = new MortuaryRepository();
		
		if(dto.getId() != null) {
			mortuaryRepo.setId(dto.getId());
		}
		mortuaryRepo.setSite(site);
		mortuaryRepo.setCodeSite(dto.getCodeSite());
		mortuaryRepo.setSiteNumber(dto.getSiteNumber());
		mortuaryRepo.setIssueNumber(dto.getIssueNumber());
		mortuaryRepo.setSepultureType(dto.getSepultureType());
		mortuaryRepo.setTypologie(dto.getTypologie());
		mortuaryRepo.setSubtype(dto.getSubtype());
		mortuaryRepo.setBurialType(dto.getBurialType());
		mortuaryRepo.setStateOfSepulture(dto.getStateOfSepulture());
		mortuaryRepo.setTpq(dto.getTpq());
		mortuaryRepo.setTaq(dto.getTaq());
		mortuaryRepo.setTimeline(dto.getTimeline());
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
