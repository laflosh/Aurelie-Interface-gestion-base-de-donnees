package com.bdd_manager.application_bdd_manager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "furniture")
public class Furniture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "issue_number")
	private String issueNumber;
	
	@Column(name = "furniture_number")
	private String furnitureNumber;
	
	@Column(name = "furniture_nature")
	private String furnitureNature;
	
	@Column(name = "feature")
	private String feature;
	
	@Column(name = "domain")
	private String domain;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "typology")
	private String typology;
	
	@Column(name = "material")
	private String material;
	
	@Column(name = "quality")
	private String quality;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "dimension")
	private String dimension;
	
	@Column(name = "origin")
	private String origin;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "conservation")
	private String conservation;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "tpq")
	private Integer tpq;
	
	@Column(name = "taq")
	private Integer taq;
	
	@Column(name = "reference")
	private String reference;
	
	@Column(name = "storage_location")
	private String storageLocation;
	
	@Column(name = "inventory_number")
	private String inventoryNumber;
	
	@Column(name = "picture")
	private String picture;
	
	@Column(name = "interpretation")
	private String interpratation;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mortuary_repository_id")
	@JsonBackReference
	//@JsonIgnore
	private MortuaryRepository mortuaryRepository;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(String issueNumber) {
		this.issueNumber = issueNumber;
	}

	public String getFurnitureNumber() {
		return furnitureNumber;
	}

	public void setFurnitureNumber(String furnitureNumber) {
		this.furnitureNumber = furnitureNumber;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getTypology() {
		return typology;
	}

	public void setTypology(String typology) {
		this.typology = typology;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getConservation() {
		return conservation;
	}

	public void setConservation(String conservation) {
		this.conservation = conservation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTpq() {
		return tpq;
	}

	public void setTpq(Integer tpq) {
		this.tpq = tpq;
	}

	public Integer getTaq() {
		return taq;
	}

	public void setTaq(Integer taq) {
		this.taq = taq;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getStorageLocation() {
		return storageLocation;
	}

	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getInterpratation() {
		return interpratation;
	}

	public void setInterpratation(String interpratation) {
		this.interpratation = interpratation;
	}

	public MortuaryRepository getMortuaryRepository() {
		return mortuaryRepository;
	}

	public void setMortuaryRepository(MortuaryRepository mortuaryRepository) {
		this.mortuaryRepository = mortuaryRepository;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

	public String getFurnitureNature() {
		return furnitureNature;
	}

	public void setFurnitureNature(String furnitureNature) {
		this.furnitureNature = furnitureNature;
	}
	
}
