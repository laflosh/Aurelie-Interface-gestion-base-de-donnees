package com.bdd_manager.application_bdd_manager.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<Report> addReportInDatabase(ReportDto report){
		
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
	
}
