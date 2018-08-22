package com.glarimy.spring.directory.data;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.glarimy.spring.directory.DirectoryConfiguration;
import com.glarimy.spring.directory.api.model.Employee;

public class GlarimyEmployeeRepositoryTest {
	private EmployeeRepository repo;

	@Before
	public void setup() {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
			context.register(DirectoryConfiguration.class);
			context.refresh();
			repo = context.getBean(EmployeeRepository.class);
		}
	}

	@Test
	public void testSave() {
		int id = repo.save(new Employee("Krishna", 100, true));
		assertTrue(id >= 2310);
		try {
			repo.save(null);
			fail();
		} catch (EmployeeRepositoryException ere) {

		}
	}

	@Test
	public void testFindOne() {
		int id = repo.save(new Employee("Krishna", 100, true));
		assertTrue(id >= 2310);
		Employee e = repo.findOne(id);
		assertTrue(e.getId() == id);
		assertTrue(e.getName().equals("Krishna"));
		assertTrue(e.getSalary() == 100);
		assertTrue(repo.findOne(id + 1) == null);
	}

	@Test
	public void testFindByName() {
		int id = repo.save(new Employee("Krishna", 100, true));
		assertTrue(id >= 2310);
		Set<Employee> employees = repo.findByName("Krishna");
		assertTrue(employees.size() >= 1);
		assertTrue(repo.findByName("Koyya").size() == 0);
	}

}
