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
		dto.setIsDeleted(false);
		
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
		
		Iterable<Report> reports = reportRepository.getAllReportNotSoftDelete();
		
		return reports;
		
	}
	
	/**
	 * @return
	 */
	public Iterable<Report> getAllSoftDeleteReport() {

		log.info("Get all soft delete reports in database");
		
		Iterable<Report> softDeleteReports = reportRepository.getAllReportSoftDelete();
		
		return softDeleteReports;
		
	}
	
	/**
	 * @param id
	 * @return
	 */
	public Report getOneReportByInDatabase(int id) {

		log.info("Fetch one report by id in database");
		
		Report report = reportRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Report not found"));
		
		return report;
		
	}
	
	/**
	 * @param report
	 * @return
	 */
	public Report updateExistingReportInDatabase(ReportDto dto) {

		Report report = dtoToObjectReport(dto);
		Report existingReport = getOneReportByInDatabase(dto.getId());
		
		if(report.getSubject() != null && !report.getSubject().equals(existingReport.getSubject())) {
			existingReport.setSubject(report.getSubject());
		}
		
		if(report.getMessage() != null && !report.getMessage().equals(existingReport.getMessage())) {
			existingReport.setMessage(report.getMessage());
		}
		
		if(report.getEmergency() != null && !report.getEmergency().equals(existingReport.getEmergency())) {
			existingReport.setEmergency(report.getEmergency());
		}
		
		if(report.getPicture() != null && !report.getPicture().equals(existingReport.getPicture())) {
			existingReport.setPicture(report.getPicture());
		}
		
		log.info("Update an existing report in database");
		
		Report updateReport = reportRepository.save(existingReport);
		
		return updateReport;
		
	}
	
	/**
	 * @param id
	 * @return
	 */
	public Report setSoftDeleteForReportObject(int id) {

		log.info("Set soft delete for a report object");
		
		Report report = getOneReportByInDatabase(id);
		
		report.setIsDeleted(true);
		
		return reportRepository.save(report);
		
	}
	
	/**
	 * @param id
	 * @return
	 */
	public Report unSetSoftDeleteForReportObject(int id) {
		
		log.info("Unset soft delete for a report object");
		
		Report report = getOneReportByInDatabase(id);
		
		report.setIsDeleted(false);
		
		return reportRepository.save(report);
		
	}
	
	/**
	 * @param id
	 */
	public void deleteExistingReportInDatabase(int id) {
		
		log.info("Delete existing report in database by id");
		
		reportRepository.deleteById(id);
		
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
		report.setIsDeleted(dto.getIsDeleted());
		
		return report;
		
	}
	
}
