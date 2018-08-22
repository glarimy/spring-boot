package com.glarimy.spring.directory.data;

import java.util.Set;

import com.glarimy.spring.directory.api.model.Employee;

public interface EmployeeRepository {
	public int save(Employee employee);

	public Employee findOne(int id);

	public Set<Employee> findByName(String name);
}
