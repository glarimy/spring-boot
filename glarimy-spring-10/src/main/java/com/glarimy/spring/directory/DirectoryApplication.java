package com.glarimy.spring.directory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DirectoryApplication {
	Logger logger = LoggerFactory.getLogger(DirectoryApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DirectoryApplication.class, args);
	}
}
