package com.glarimy.spring.directory;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.glarimy.spring.directory.api.model.Employee;

@Configuration
@ComponentScan(basePackages = { "com.glarimy.spring.directory" })
public class EmployeeConfiguration {
	@Bean
	public Employee employee() {
		Employee employee = new Employee("Krishna", 100, true);
		employee.setId(2310);
		return employee;
	}

	@Bean
	public Set<Employee> employees() {
		Set<Employee> employees = new HashSet<>();
		employees.add(employee());
		return employees;
	}
}
