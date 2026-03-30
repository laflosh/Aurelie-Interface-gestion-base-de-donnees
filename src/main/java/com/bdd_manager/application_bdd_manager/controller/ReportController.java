package com.bdd_manager.application_bdd_manager.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdd_manager.application_bdd_manager.model.Report;
import com.bdd_manager.application_bdd_manager.model.dto.ReportDto;
import com.bdd_manager.application_bdd_manager.service.ReportService;

/**
 * 
 */
@RestController
@RequestMapping("/api")
public class ReportController {

	private final Logger log = LogManager.getLogger(ReportController.class);
	
	@Autowired
	ReportService reportService;
	
	/**
	 * @param report
	 * @return
	 */
	@PostMapping("/report")
	public ResponseEntity<Report> addReportInDatabase(@RequestBody ReportDto report){
		
		try {
			
			log.info("Trying to add a new report in database");
			
			Report addReport = reportService.addReportInDatabase(report);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(addReport);
			
		} catch(Exception e){
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			
		}
		
	}
	
	/**
	 * @return
	 */
	@GetMapping("/report")
	public ResponseEntity<Iterable<Report>> getAllReportInDatabase(){
		
		try {
			
			log.info("Trying to get all report in database");
			
			Iterable<Report> reports = reportService.getAllReportInDatabase();
			
			return ResponseEntity.status(HttpStatus.OK).body(reports);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
		}
		
	}
	
	/**
	 * @return
	 */
	@GetMapping("/report/soft-delete")
	public ResponseEntity<Iterable<Report>> getAllSoftDeleteReport(){
		
		try {
			
			log.info("Trying to get all soft delete report in database");
			
			Iterable<Report> softDeleteReports = reportService.getAllSoftDeleteReport();
			
			return ResponseEntity.status(HttpStatus.OK).body(softDeleteReports);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
		}
		
	}
	
	/**
	 * @param id
	 * @return
	 */
	@GetMapping("/report/{id}")
	public ResponseEntity<Report> getOneReportByIdInDatabase(@PathVariable int id){
		
		try {
			
			log.info("Trying to fetch one report by id in database");
			
			Report report = reportService.getOneReportByInDatabase(id);
			
			return ResponseEntity.status(HttpStatus.OK).body(report);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
		}
		
	}
	
	/**
	 * @param report
	 * @return
	 */
	@PutMapping("/report")
	public ResponseEntity<Report> updateExistingReportInDatabase(@RequestBody ReportDto report){
		
		try {
			
			log.info("Trying top update an existing report in database");
			
			Report updateReport = reportService.updateExistingReportInDatabase(report);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(updateReport);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			
		}
		
	}
	
	/**
	 * @param id
	 * @return
	 */
	@PutMapping("/report/{id}/soft-delete")
	public ResponseEntity<Report> setSoftDeleteForReportObject(@PathVariable int id){
		
		try {
			
			log.info("Trying to set soft delete for a report");
			
			Report updateReport = reportService.setSoftDeleteForReportObject(id);
			
			return ResponseEntity.status(HttpStatus.OK).body(updateReport);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			
		}
		
	}
	
	/**
	 * @param id
	 * @return
	 */
	@PutMapping("/report/{id}/unset-soft-delete")
	public ResponseEntity<Report> unSetSoftDeleteForReportObject(@PathVariable int id){
		
		try {
			
			log.info("Trying to unset soft delete for a report");
			
			Report updateReport = reportService.unSetSoftDeleteForReportObject(id);
			
			return ResponseEntity.status(HttpStatus.OK).body(updateReport);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			
		}
		
	}
	
	/**
	 * @param id
	 * @return
	 */
	@DeleteMapping("/report/{id}")
	public ResponseEntity<String> deleteExistingReportInDatabase(@PathVariable int id){
		
		try {
			
			log.info("Trying to delete an existing report in database");
			
			reportService.deleteExistingReportInDatabase(id);
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Report delete");
			
		} catch(Exception e){
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
		}
		
	}
	
}
