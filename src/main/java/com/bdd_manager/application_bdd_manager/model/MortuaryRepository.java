package com.bdd_manager.application_bdd_manager.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "mortuary_repository")
public class MortuaryRepository {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "code_site")
	private String codeSite;
	
	@Column(name = "site_number")
	private String siteNumber;
	
	@Column(name = "issue_number")
	private String issueNumber;
	
	@Column(name = "sepulture_type")
	private String sepultureType;
	
	@Column(name = "typology")
	private String typologie;
	
	@Column(name = "subtypes")
	private String subtype;
	
	@Column(name = "burial_type")
	private String burialType;
	
	@Column(name = "state_of_sepulture")
	private String stateOfSepulture;
	
	@Column(name = "tpq")
	private Integer tpq;
	
	@Column(name = "taq")
	private Integer taq;
	
	@Column(name = "timeline")
	private String timeline;
	
	@Column(name = "age")
	private String age;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "furniture")
	private String furniture;
	
	@Column(name = "origin_furniture")
	private String originFurniture;
	
	@Column(name = "publication")
	private String publication;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "picture")
	private String picture;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "site_id")
	//@JsonIgnore
	private Site site;
	
	@OneToMany(
		mappedBy = "mortuaryRepository",
		fetch = FetchType.LAZY
		)
	//@JsonIgnore
	private List<Furniture> furnitures;

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

	public String getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(String issueNumber) {
		this.issueNumber = issueNumber;
	}

	public String getSepultureType() {
		return sepultureType;
	}

	public void setSepultureType(String sepultureType) {
		this.sepultureType = sepultureType;
	}

	public String getBurialType() {
		return burialType;
	}

	public void setBurialType(String burialType) {
		this.burialType = burialType;
	}

	public String getStateOfSepulture() {
		return stateOfSepulture;
	}
	
	public void setStateOfSepulture(String stateOfSepulture) {
		this.stateOfSepulture = stateOfSepulture;
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

	public String getTimeline() {
		return timeline;
	}

	public void setTimeline(String timeline) {
		this.timeline = timeline;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFurniture() {
		return furniture;
	}

	public void setFurniture(String furniture) {
		this.furniture = furniture;
	}

	public String getOriginFurniture() {
		return originFurniture;
	}

	public void setOriginFurniture(String originFurniture) {
		this.originFurniture = originFurniture;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public List<Furniture> getFurnitures() {
		return furnitures;
	}

	public void setFurnitures(List<Furniture> furnitures) {
		this.furnitures = furnitures;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public String getCodeSite() {
		return codeSite;
	}

	public void setCodeSite(String codeSite) {
		this.codeSite = codeSite;
	}

	public String getTypologie() {
		return typologie;
	}

	public void setTypologie(String typologie) {
		this.typologie = typologie;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	
}
