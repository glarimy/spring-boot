package com.glarimy.spring.directory.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glarimy.spring.directory.api.Directory;
import com.glarimy.spring.directory.api.exceptions.DirectoryException;
import com.glarimy.spring.directory.api.exceptions.EmployeeNotFoundException;
import com.glarimy.spring.directory.api.exceptions.InvalidEmployeeException;
import com.glarimy.spring.directory.api.model.Employee;
import com.glarimy.spring.directory.data.EmployeeRepository;

@Service
public class GlarimyDirectory implements Directory {
	Logger logger = LoggerFactory.getLogger(GlarimyDirectory.class);

	@Autowired
	private EmployeeRepository repo;

	@Override
	@Transactional
	public int add(Employee employee) throws InvalidEmployeeException, DirectoryException {
		logger.debug("adding employee " + employee);
		repo.save(employee);
		return employee.getId();
	}

	@Override
	@Transactional
	public Employee find(int id) throws EmployeeNotFoundException, DirectoryException {
		logger.debug("finding employe with id: " + id);
		Employee employee = repo.findById(id).orElse(null);
		if (employee == null)
			throw new EmployeeNotFoundException();
		return employee;
	}

	@Override
	public Set<Employee> search(String key) throws DirectoryException {
		logger.debug("finding employee with name: " + key);
		return repo.findByNameContaining(key);
	}

}
