package com.bdd_manager.application_bdd_manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationBddManagerApplication {

	private static final Logger log = LogManager.getLogger("ApplicationBddManagerApplication");
	
	public static void main(String[] args) {
		
		log.info("--- Initialize BDD Manager Application ---");
		
		SpringApplication.run(ApplicationBddManagerApplication.class, args);
		
	}

}
