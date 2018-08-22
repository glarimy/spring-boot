package com.glarimy.spring.directory.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.glarimy.spring.directory.EmployeeConfiguration;
import com.glarimy.spring.directory.api.Directory;
import com.glarimy.spring.directory.api.exceptions.DirectoryException;
import com.glarimy.spring.directory.api.exceptions.EmployeeNotFoundException;
import com.glarimy.spring.directory.api.exceptions.InvalidEmployeeException;
import com.glarimy.spring.directory.api.model.Employee;
import com.glarimy.spring.directory.data.EmployeeRepository;
import com.glarimy.spring.directory.data.EmployeeRepositoryException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { EmployeeConfiguration.class })
public class GlarimyDirectoryTest {

	@Autowired
	@InjectMocks
	private Directory directory;

	@Mock
	private EmployeeRepository repository;

	@Autowired
	private Employee employee;

	@Autowired
	private Set<Employee> employees;

	@SuppressWarnings("unchecked")
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		when(repository.save(null)).thenThrow(EmployeeRepositoryException.class);
		when(repository.save(employee)).thenReturn(2310);
		when(repository.findOne(2310)).thenReturn(employee);
		when(repository.findOne(2311)).thenReturn(null);
		when(repository.findByName("Krishna")).thenReturn(new HashSet<Employee>(), employees);
		when(repository.findByName("Mohan")).thenReturn(new HashSet<>());
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
			assertTrue(e.getId() == id);
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
			directory.add(employee);
			assertTrue(directory.search("Krishna").size() > 0);
			assertTrue(directory.search("Mohan").size() == 0);
		} catch (Exception e) {
			fail();
		}
	}
}
