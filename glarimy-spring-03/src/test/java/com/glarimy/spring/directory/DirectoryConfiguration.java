package com.glarimy.spring.directory;

import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.glarimy.spring.directory.api.Directory;
import com.glarimy.spring.directory.api.model.Employee;
import com.glarimy.spring.directory.data.EmployeeRepository;
import com.glarimy.spring.directory.data.EmployeeRepositoryException;
import com.glarimy.spring.directory.data.GlarimyEmployeeRepository;
import com.glarimy.spring.directory.service.GlarimyDirectory;

@Configuration
public class DirectoryConfiguration {
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

	@Bean
	public EmployeeRepository repository() {
		return new GlarimyEmployeeRepository();
	}

	@SuppressWarnings("unchecked")
	@Bean
	public Directory directory() {
		EmployeeRepository repository = Mockito.mock(EmployeeRepository.class);
		when(repository.save(null)).thenThrow(EmployeeRepositoryException.class);
		when(repository.save(employee())).thenReturn(2310);
		when(repository.findOne(2310)).thenReturn(employee());
		when(repository.findOne(2311)).thenReturn(null);
		when(repository.findByName("Krishna")).thenReturn(new HashSet<Employee>(), employees());
		when(repository.findByName("Mohan")).thenReturn(new HashSet<>());

		GlarimyDirectory directory = new GlarimyDirectory();
		directory.setRepo(repository());
		return directory;
	}

}
