package com.bdd_manager.application_bdd_manager.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bdd_manager.application_bdd_manager.model.Report;

/**
 * 
 */
@Repository
public interface ReportRepository extends CrudRepository<Report, Integer>{

	@Query("select u from Report u where u.isDeleted = false")
	Iterable<Report> getAllReportNotSoftDelete();
	
	@Query("select u from Report u where u.isDeleted = true")
	Iterable<Report> getAllReportSoftDelete();
	
}
