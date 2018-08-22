package com.glarimy.spring.directory.data;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.glarimy.spring.directory.EmployeeConfiguration;
import com.glarimy.spring.directory.api.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { EmployeeConfiguration.class })
public class GlarimyEmployeeRepositoryTest {
	@Autowired
	private EmployeeRepository repo;

	@Autowired
	private Employee employee;

	@Test
	public void testSave() {
		int id = repo.save(employee);
		assertTrue(id >= 2310);
		try {
			repo.save(null);
			fail();
		} catch (EmployeeRepositoryException ere) {

		}
	}

	@Test
	public void testFindOne() {
		int id = repo.save(employee);
		assertTrue(id >= 2310);
		Employee e = repo.findOne(id);
		assertTrue(e.getId() == id);
		assertTrue(e.getName().equals("Krishna"));
		assertTrue(e.getSalary() == 100);
		assertTrue(repo.findOne(id + 1) == null);
	}

	@Test
	public void testFindByName() {
		int id = repo.save(employee);
		assertTrue(id >= 2310);
		Set<Employee> employees = repo.findByName("Krishna");
		assertTrue(employees.size() >= 1);
		assertTrue(repo.findByName("Koyya").size() == 0);
	}

}
