package com.stock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class StockManagementSystemApplication {
	
	 private static final Logger LOGGER=LoggerFactory.getLogger(StockManagementSystemApplication.class);
	 
	public static void main(String[] args) {
		SpringApplication.run(StockManagementSystemApplication.class, args);
		LOGGER.info("Testing");
	}

}
