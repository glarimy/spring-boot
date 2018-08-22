package com.glarimy.spring.directory.data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.glarimy.spring.directory.api.model.Employee;

public class GlarimyEmployeeRepository implements EmployeeRepository {
	private Map<Integer, Employee> rolls;
	private int EMP_ID = 2310;

	public GlarimyEmployeeRepository() {
		rolls = new HashMap<>();
	}

	@Override
	public int save(Employee employee) {
		if (employee == null)
			throw new EmployeeRepositoryException();
		employee.setId(EMP_ID++);
		rolls.put(employee.getId(), employee);
		return employee.getId();
	}

	@Override
	public Employee findOne(int id) {
		return rolls.get(id);
	}

	@Override
	public Set<Employee> findByName(String name) {
		Set<Employee> employees = new HashSet<>();
		for (Employee employee : rolls.values())
			if (employee.getName().toLowerCase().contains(name.toLowerCase()))
				employees.add(employee);
		return employees;
	}

}
