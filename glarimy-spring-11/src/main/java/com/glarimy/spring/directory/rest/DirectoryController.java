package com.glarimy.spring.directory.rest;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.glarimy.spring.directory.api.Directory;
import com.glarimy.spring.directory.api.exceptions.DirectoryException;
import com.glarimy.spring.directory.api.exceptions.EmployeeNotFoundException;
import com.glarimy.spring.directory.api.exceptions.InvalidEmployeeException;
import com.glarimy.spring.directory.api.model.Employee;

@RestController
@RequestMapping("/directory")
public class DirectoryController {
	Logger logger = LoggerFactory.getLogger(DirectoryController.class);

	@Autowired
	private Directory directory;

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public ResponseEntity<Employee> add(@RequestBody Employee employee, UriComponentsBuilder builder) {
		logger.debug("posting employee: " + employee);
		try {
			directory.add(employee);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/directory/employee/{id}").buildAndExpand(employee.getId()).toUri());
			return new ResponseEntity<>(employee, headers, HttpStatus.CREATED);
		} catch (InvalidEmployeeException iee) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (DirectoryException de) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> get(@PathVariable("id") int id) {
		logger.debug("Finding employee with id: " + id);
		try {
			Employee employee = directory.find(id);
			return new ResponseEntity<>(employee, HttpStatus.OK);
		} catch (EmployeeNotFoundException enfe) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (DirectoryException de) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ResponseEntity<Set<Employee>> get(@RequestParam("key") String key) {
		logger.debug("Searching employees with name: " + key);
		try {
			Set<Employee> employees = directory.search(key);
			return new ResponseEntity<>(employees, HttpStatus.OK);
		} catch (DirectoryException de) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
