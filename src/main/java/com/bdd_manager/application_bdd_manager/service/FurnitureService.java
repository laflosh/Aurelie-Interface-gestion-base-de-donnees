package com.bdd_manager.application_bdd_manager.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdd_manager.application_bdd_manager.model.Furniture;
import com.bdd_manager.application_bdd_manager.model.MortuaryRepository;
import com.bdd_manager.application_bdd_manager.model.dto.FurnitureDto;
import com.bdd_manager.application_bdd_manager.repository.FurnitureRepository;

import jakarta.persistence.EntityNotFoundException;

/**
 * 
 */
@Service
public class FurnitureService {

	private final Logger log = LogManager.getLogger(FurnitureService.class);
	
	@Autowired
	FurnitureRepository furnitureRepository;
	
	@Autowired
	MortuaryRepositoryService mortuaryRepositoryService;

	/**
	 * @param dto
	 * @return
	 */
	public Furniture addNewFurnitureInDatabase(FurnitureDto dto) {
		
		Furniture furniture = furnitureDtoToObject(dto);
		
		log.info("Saving new furniture in database");
		
		Furniture newFurniture = furnitureRepository.save(furniture);
		
		return newFurniture;
		
	}

	/**
	 * @param dto
	 * @return
	 */
	private Furniture furnitureDtoToObject(FurnitureDto dto) {

		Furniture furniture = new Furniture();
		
		if(dto.getMortuaryRepositoryId() != null && dto.getMortuaryRepositoryId() > 0) {
			
			MortuaryRepository mortuaryRepo = mortuaryRepositoryService.getOneMortuaryRepositoryById(dto.getMortuaryRepositoryId());
			furniture.setMortuaryRepository(mortuaryRepo);
			
		} else if(dto.getIssueNumber() != null) {
			
			MortuaryRepository mortuaryRepo = mortuaryRepositoryService.getOneMortuaryRepositoryByIssueNumber(dto.getIssueNumber());
			furniture.setMortuaryRepository(mortuaryRepo);
			
		} else {

			throw new EntityNotFoundException("Mortuary Repository doen't exist");
			
		}
		
		if(dto.getId() != null) {
			furniture.setId(dto.getId());
		}
		furniture.setIssueNumber(dto.getIssueNumber());
		furniture.setFurnitureNumber(dto.getFurnitureNumber());
		furniture.setFeature(dto.getFeature());
		furniture.setDomain(dto.getDomain());
		furniture.setDesignation(dto.getDesignation());
		furniture.setTypology(dto.getTypology());
		furniture.setMaterial(dto.getMaterial());
		furniture.setQuality(dto.getQuality());
		furniture.setColor(dto.getColor());
		furniture.setDimension(dto.getDimension());
		furniture.setOrigin(dto.getOrigin());
		furniture.setDescription(dto.getDescription());
		furniture.setStatus(dto.getStatus());
		furniture.setInterpratation(dto.getInterpratation());
		furniture.setTpq(dto.getTpq());
		furniture.setTaq(dto.getTaq());
		furniture.setReference(dto.getReference());
		furniture.setStorageLocation(dto.getStorageLocation());
		furniture.setInventoryNumber(dto.getInventoryNumber());
		furniture.setPicture(dto.getPicture());
		
		return furniture;
		
	}
	
}
