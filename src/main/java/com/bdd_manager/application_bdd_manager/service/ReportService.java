package com.bdd_manager.application_bdd_manager.service;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdd_manager.application_bdd_manager.model.Report;
import com.bdd_manager.application_bdd_manager.model.dto.ReportDto;
import com.bdd_manager.application_bdd_manager.repository.ReportRepository;

/**
 * 
 */
@Service
public class ReportService {

	private final Logger log = LogManager.getLogger(ReportService.class);
	
	@Autowired
	ReportRepository reportRepository;

	/**
	 * @param report
	 * @return
	 */
	public Report addReportInDatabase(ReportDto dto) {
		
		Date date = new Date();
		dto.setDate(date);
		
		Report report = dtoToObjectReport(dto);
		
		log.info("Add new report in database");
		
		Report addReport = reportRepository.save(report);
		
		return addReport;
		
	}
	
	/**
	 * @return
	 */
	public Iterable<Report> getAllReportInDatabase() {

		log.info("Fetch all report in databse");
		
		Iterable<Report> reports = reportRepository.findAll();
		
		return reports;
		
	}
	
	/**
	 * @param dto
	 * @return
	 */
	private Report dtoToObjectReport(ReportDto dto) {
		
		Report report = new Report();
		
		if(dto.getId() != null) {
			report.setId(dto.getId());
		}
		report.setSubject(dto.getSubject());
		report.setMessage(dto.getMessage());
		report.setDate(dto.getDate());
		report.setEmergency(dto.getEmergency());
		report.setPicture(dto.getPicture());
		
		return report;
		
	}
	
}
