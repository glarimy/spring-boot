package com.glarimy.spring.directory.api;

import java.util.Set;

import com.glarimy.spring.directory.api.exceptions.DirectoryException;
import com.glarimy.spring.directory.api.exceptions.EmployeeNotFoundException;
import com.glarimy.spring.directory.api.exceptions.InvalidEmployeeException;
import com.glarimy.spring.directory.api.model.Employee;

public interface Directory {
	public int add(Employee employee) throws InvalidEmployeeException, DirectoryException;

	public Employee find(int id) throws EmployeeNotFoundException, DirectoryException;

	public Set<Employee> search(String key) throws DirectoryException;
}
