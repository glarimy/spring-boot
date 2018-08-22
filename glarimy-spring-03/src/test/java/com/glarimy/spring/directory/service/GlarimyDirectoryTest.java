package com.glarimy.spring.directory.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.glarimy.spring.directory.DirectoryConfiguration;
import com.glarimy.spring.directory.api.Directory;
import com.glarimy.spring.directory.api.exceptions.DirectoryException;
import com.glarimy.spring.directory.api.exceptions.EmployeeNotFoundException;
import com.glarimy.spring.directory.api.exceptions.InvalidEmployeeException;
import com.glarimy.spring.directory.api.model.Employee;

public class GlarimyDirectoryTest {
	private Directory directory;
	private Employee employee;

	@Before
	public void setup() {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
			context.register(DirectoryConfiguration.class);
			context.refresh();
			directory = context.getBean(Directory.class);
			employee = context.getBean(Employee.class);
		}
	}

	@Test
	public void testAdd() {
		try {
			directory.add(null);
			fail();
		} catch (InvalidEmployeeException iee) {

		}

		try {
			directory.add(new Employee(null, 100, true));
			fail();
		} catch (InvalidEmployeeException iee) {

		}

		try {
			directory.add(new Employee("", 100, true));
			fail();
		} catch (InvalidEmployeeException iee) {

		}

		try {
			directory.add(new Employee("Krishna", -100, true));
			fail();
		} catch (InvalidEmployeeException iee) {
		}

		try {
			assertTrue(directory.add(employee) >= 2310);
		} catch (InvalidEmployeeException iee) {
			fail();
		}
	}

	@Test
	public void testFind() {
		int id = 0;
		try {
			id = directory.add(employee);
			assertTrue(id >= 2310);
			Employee e = directory.find(id);
			assertTrue(e.getId() == 2310);
			assertTrue(e.getName().equals("Krishna"));
			assertTrue(e.isRegular() == true);
		} catch (DirectoryException de) {
			fail();
		}

		try {
			directory.find(id + 1);
			fail();
		} catch (EmployeeNotFoundException enfe) {

		}
	}

	@Test
	public void search() {
		try {
			assertTrue(directory.search("Krishna").size() == 0);
			directory.add(new Employee("Krishna", 100, true));
			assertTrue(directory.search("Krishna").size() > 0);
			assertTrue(directory.search("Mohan").size() == 0);
		} catch (Exception e) {
			fail();
		}
	}
}
