package com.glarimy.spring.directory.service;

import java.util.Set;

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
	public int add(Employee employee) throws InvalidEmployeeException, DirectoryException {
		logger.debug("adding employee " + employee);
		if (employee == null)
			throw new InvalidEmployeeException("employee is null");
		if (employee.getName() == null)
			throw new InvalidEmployeeException("employee name is null");
		if (employee.getName().trim().length() == 0)
			throw new InvalidEmployeeException("employee name is empty");
		if (employee.getSalary() < 0)
			throw new InvalidEmployeeException("employee salary is negative");
		return repo.save(employee);
	}

	@Override
	public Employee find(int id) throws EmployeeNotFoundException, DirectoryException {
		logger.debug("finding employe with id: " + id);
		if (id < 2310)
			throw new EmployeeNotFoundException("id is inavalid");
		Employee employee = repo.findOne(id);
		if (employee == null)
			throw new EmployeeNotFoundException();
		return employee;
	}

	@Override
	public Set<Employee> search(String key) throws DirectoryException {
		logger.debug("finding employee with name: " + key);
		return repo.findByName(key);
	}

}
