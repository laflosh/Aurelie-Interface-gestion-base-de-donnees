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
	 * @return
	 */
	public Iterable<Furniture> getAllFurnitureInDatabase() {

		log.info("Fetch all furnitures in database");
		
		Iterable<Furniture> furnitures = furnitureRepository.findAll();
		
		return furnitures;
		
	}
	
	/**
	 * @param id
	 * @return
	 */
	public Furniture getOneFurnitureByIdInDatabse(int id) {

		log.info("Fetch one furniture by id in database");
		
		Furniture furniture = furnitureRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Furniture doesn't exist"));
		
		return furniture;
		
	}
	
	public Furniture updateExistingFurnitureInDatabase(FurnitureDto dto) {

		Furniture furniture = furnitureDtoToObject(dto);
		
		Furniture existingFurniture = getOneFurnitureByIdInDatabse(dto.getId());
		
		if(furniture.getIssueNumber() != null && !furniture.getIssueNumber().equals(existingFurniture.getIssueNumber())) {
			existingFurniture.setIssueNumber(furniture.getIssueNumber());
		}
		
		if(furniture.getFurnitureNumber() != null && !furniture.getFurnitureNumber().equals(existingFurniture.getFurnitureNumber())) {
			existingFurniture.setFurnitureNumber(furniture.getFurnitureNumber());
		}
		
		if(furniture.getFurnitureNature() != null && !furniture.getFurnitureNature().equals(existingFurniture.getFurnitureNature())) {
			existingFurniture.setFurnitureNature(furniture.getFurnitureNature());
		}
		
		if(furniture.getFeature() != null && !furniture.getFeature().equals(existingFurniture.getFeature())) {
			existingFurniture.setFeature(furniture.getFeature());
		}
		
		if(furniture.getDomain() != null && !furniture.getDomain().equals(existingFurniture.getDomain())) {
			existingFurniture.setDomain(furniture.getDomain());
		}
		
		if(furniture.getDesignation() != null && !furniture.getDesignation().equals(existingFurniture.getDesignation())) {
			existingFurniture.setDesignation(furniture.getDesignation());
		}
		
		if(furniture.getTypology() != null && !furniture.getTypology().equals(existingFurniture.getTypology())) {
			existingFurniture.setTypology(furniture.getTypology());
		}
		
		if(furniture.getMaterial() != null && !furniture.getMaterial().equals(existingFurniture.getMaterial())) {
			existingFurniture.setMaterial(furniture.getMaterial());
		}
		
		if(furniture.getQuality() != null && !furniture.getQuality().equals(existingFurniture.getQuality())) {
			existingFurniture.setQuality(furniture.getQuality());
		}
		
		if(furniture.getColor() != null && !furniture.getColor().equals(existingFurniture.getColor())) {
			existingFurniture.setColor(furniture.getColor());
		}
		
		if(furniture.getDimension() != null && !furniture.getDimension().equals(existingFurniture.getDimension())) {
			existingFurniture.setDimension(furniture.getDimension());
		}
		
		if(furniture.getOrigin() != null && !furniture.getOrigin().equals(existingFurniture.getOrigin())) {
			existingFurniture.setOrigin(furniture.getOrigin());
		}
		
		if(furniture.getDescription() != null && !furniture.getDescription().equals(existingFurniture.getDescription())) {
			existingFurniture.setDescription(furniture.getDescription());
		}
		
		if(furniture.getConservation() != null && !furniture.getConservation().equals(existingFurniture.getConservation())) {
			existingFurniture.setConservation(furniture.getConservation());
		}
		
		if(furniture.getStatus() != null && !furniture.getStatus().equals(existingFurniture.getStatus())) {
			existingFurniture.setStatus(furniture.getStatus());
		}
		
		if(furniture.getTpq() != null && furniture.getTpq() != existingFurniture.getTpq()) {
			existingFurniture.setTpq(furniture.getTpq());
		}
		
		if(furniture.getTaq() != null && furniture.getTaq() != existingFurniture.getTaq()) {
			existingFurniture.setTaq(furniture.getTaq());
		}
		
		if(furniture.getReference() != null && !furniture.getReference().equals(existingFurniture.getReference())) {
			existingFurniture.setReference(furniture.getReference());
		}
		
		if(furniture.getStorageLocation() != null && !furniture.getStorageLocation().equals(existingFurniture.getStorageLocation())) {
			existingFurniture.setStorageLocation(furniture.getStorageLocation());
		}
		
		if(furniture.getInventoryNumber() != null && !furniture.getInventoryNumber().equals(existingFurniture.getInventoryNumber())) {
			existingFurniture.setInventoryNumber(furniture.getInventoryNumber());
		}
		
		if(furniture.getPicture() != null && !furniture.getPicture().equals(existingFurniture.getPicture())) {
			existingFurniture.setPicture(furniture.getPicture());
		}
		
		if(furniture.getInterpratation() != null && !furniture.getInterpratation().equals(existingFurniture.getInterpratation())) {
			existingFurniture.setInterpratation(furniture.getInterpratation());
		}
		
		log.info("Updating an exiting furniture in database");
		Furniture updateFurniture = furnitureRepository.save(existingFurniture);
		
		return updateFurniture;
		
	}

	/**
	 * @param dto
	 * @return
	 */
	private Furniture furnitureDtoToObject(FurnitureDto dto) {

		Furniture furniture = new Furniture();
		
		if(dto.getId() == null) {
			
			MortuaryRepository mortuaryRepo = new MortuaryRepository();
			
			if(dto.getMortuaryRepositoryId() != null && dto.getMortuaryRepositoryId() > 0) {
				
				mortuaryRepo = mortuaryRepositoryService.getOneMortuaryRepositoryById(dto.getMortuaryRepositoryId());
				furniture.setMortuaryRepository(mortuaryRepo);
				
			} else if(dto.getIssueNumber() != null) {
				
				mortuaryRepo = mortuaryRepositoryService.getOneMortuaryRepositoryByIssueNumber(dto.getIssueNumber());
				furniture.setMortuaryRepository(mortuaryRepo);
				
			} else {

				throw new EntityNotFoundException("Mortuary Repository doen't exist");
				
			}
			
		}
		
		if(dto.getId() != null) {
			furniture.setId(dto.getId());
		}
		furniture.setIssueNumber(dto.getIssueNumber());
		furniture.setFurnitureNumber(dto.getFurnitureNumber());
		furniture.setFurnitureNature(dto.getFurnitureNature());
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
