package com.glarimy.spring.directory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.glarimy.spring.directory.api.Directory;
import com.glarimy.spring.directory.api.model.Employee;

@SpringBootApplication
public class DirectoryApplication implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(DirectoryApplication.class);

	@Autowired
	Directory directory;

	@Override
	public void run(String... args) throws Exception {
		int id = directory.add(new Employee("Krishna Mohan", 100000, true));
		logger.debug("Employee is regsitered with ID: " + id);
		logger.debug("Employee with ID-" + id + " : " + directory.find(id));
		logger.debug("Employees with name Krishna: " + directory.search("Krishna"));
	}

	public static void main(String[] args) {
		SpringApplication.run(DirectoryApplication.class, args);
	}

}
