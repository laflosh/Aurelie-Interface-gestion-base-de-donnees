package com.bdd_manager.application_bdd_manager.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "site")
public class Site {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "code_site")
	private String codeSite;
	
	@Column(name = "site_number")
	private String siteNumber;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "micro_region")
	private String microRegion;
	
	@Column(name = "ancient_name")
	private String ancientName;
	
	@Column(name = "modern_name")
	private String modernName;
	
	@Column(name = "site")
	private String site;
	
	@Column(name = "locality")
	private String locality;
	
	@Column(name = "latitude")
	private float latitude;
	
	@Column(name = "longitude")
	private float longitude;
	
	@Column(name = "tpq")
	private int tpq;
	
	@Column(name = "taq")
	private int taq;
	
	@Column(name = "occupation")
	private String occupation;
	
	@Column(name = "nature_of_the_excavation")
	private String natureOfExcavation;
	
	@Column(name = "total_number_sepultures")
	private int totalNumberSepultures;
	
	@Column(name = "immature_sepulture_number")
	private int immatureSepultureNumber;
	
	@Column(name = "sepulture_number_vab")
	private int sepultureNumberVab;
	
	@Column(name = "number_sepulture_studied")
	private int numberSepultureStudied;
	
	@Column(name = "date_excavation")
	private String dateExcavation;
	
	@Column(name = "observation")
	private String observation;
	
	@Column(name = "reference")
	private String reference;
	
	@Column(name = "picture")
	private String picture;
	
	@OneToMany(
		mappedBy = "site",
		fetch = FetchType.LAZY
		)
	//@JsonIgnore
	private List<MortuaryRepository> mortuaryRepositories;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSiteNumber() {
		return siteNumber;
	}

	public void setSiteNumber(String siteNumber) {
		this.siteNumber = siteNumber;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAncientName() {
		return ancientName;
	}

	public void setAncientName(String ancientName) {
		this.ancientName = ancientName;
	}

	public String getModernName() {
		return modernName;
	}

	public void setModernName(String modernName) {
		this.modernName = modernName;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public int getTpq() {
		return tpq;
	}

	public void setTpq(int tpq) {
		this.tpq = tpq;
	}

	public int getTaq() {
		return taq;
	}

	public void setTaq(int taq) {
		this.taq = taq;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getNatureOfExcavation() {
		return natureOfExcavation;
	}

	public void setNatureOfExcavation(String natureOfExcavation) {
		this.natureOfExcavation = natureOfExcavation;
	}

	public int getTotalNumberSepultures() {
		return totalNumberSepultures;
	}

	public void setTotalNumberSepultures(int totalNumberSepultures) {
		this.totalNumberSepultures = totalNumberSepultures;
	}

	public int getImmatureSepultureNumber() {
		return immatureSepultureNumber;
	}

	public void setImmatureSepultureNumber(int immatureSepultureNumber) {
		this.immatureSepultureNumber = immatureSepultureNumber;
	}

	public int getSepultureNumberVab() {
		return sepultureNumberVab;
	}

	public void setSepultureNumberVab(int sepultureNumberVab) {
		this.sepultureNumberVab = sepultureNumberVab;
	}

	public int getNumberSepultureStudied() {
		return numberSepultureStudied;
	}

	public void setNumberSepultureStudied(int numberSepultureStudied) {
		this.numberSepultureStudied = numberSepultureStudied;
	}

	public String getDateExcavation() {
		return dateExcavation;
	}

	public void setDateExcavation(String dateExcavation) {
		this.dateExcavation = dateExcavation;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getCodeSite() {
		return codeSite;
	}

	public void setCodeSite(String codeSite) {
		this.codeSite = codeSite;
	}

	public String getMicroRegion() {
		return microRegion;
	}

	public void setMicroRegion(String microRegion) {
		this.microRegion = microRegion;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public List<MortuaryRepository> getMortuaryRepositories() {
		return mortuaryRepositories;
	}

	public void setMortuaryRepositories(List<MortuaryRepository> mortuaryRepositories) {
		this.mortuaryRepositories = mortuaryRepositories;
	}
	
}
