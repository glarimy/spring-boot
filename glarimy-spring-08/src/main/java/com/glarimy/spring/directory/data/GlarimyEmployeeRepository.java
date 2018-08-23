package com.glarimy.spring.directory.data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.glarimy.spring.directory.api.model.Employee;

@Repository
public class GlarimyEmployeeRepository implements EmployeeRepository {
	Logger logger = LoggerFactory.getLogger(GlarimyEmployeeRepository.class);

	private Map<Integer, Employee> rolls;
	private int EMP_ID = 2310;

	public GlarimyEmployeeRepository() {
		rolls = new HashMap<>();
	}

	@Override
	public int save(Employee employee) {
		logger.debug("saving employee: " + employee);
		if (employee == null)
			throw new EmployeeRepositoryException();
		employee.setId(EMP_ID++);
		rolls.put(employee.getId(), employee);
		return employee.getId();
	}

	@Override
	public Employee findOne(int id) {
		logger.debug("finding employee with id: " + id);
		return rolls.get(id);
	}

	@Override
	public Set<Employee> findByName(String name) {
		logger.debug("finding employee by name " + name);
		Set<Employee> employees = new HashSet<>();
		for (Employee employee : rolls.values())
			if (employee.getName().toLowerCase().contains(name.toLowerCase()))
				employees.add(employee);
		return employees;
	}

}
