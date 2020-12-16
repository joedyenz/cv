package com.cv;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CVApplication {

	public static final Logger logger = LogManager.getLogger(CVApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CVApplication.class, args);
	}

}
