package com.glarimy.spring.directory.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.glarimy.spring.directory.api.exceptions.DirectoryException;
import com.glarimy.spring.directory.api.exceptions.EmployeeNotFoundException;
import com.glarimy.spring.directory.api.exceptions.InvalidEmployeeException;
import com.glarimy.spring.directory.api.model.Employee;

public class GlarimyDirectoryTest {
	@Test
	public void testAdd() {
		GlarimyDirectory directory = new GlarimyDirectory();
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
			assertTrue(directory.add(new Employee("Krishna", 100, true)) >= 2310);
		} catch (InvalidEmployeeException iee) {
			fail();
		}
	}

	@Test
	public void testFind() {
		GlarimyDirectory directory = new GlarimyDirectory();
		int id = 0;
		try {
			id = directory.add(new Employee("Krishna", 100, true));
			assertTrue(id >= 2310);
			Employee e = directory.find(id);
			assertTrue(e.getId() == 2310);
			assertTrue(e.getName().equals("Krishna"));
			assertTrue(e.isRegular() == true);
		}catch(DirectoryException de){
			fail();
		}
		
		try {
			directory.find(id+1);
			fail();
		}catch(EmployeeNotFoundException enfe){
			
		}		
	}

	@Test
	public void search() {
		GlarimyDirectory directory = new GlarimyDirectory();
		try {
			assertTrue(directory.search("Krishna").size() == 0);
			directory.add(new Employee("Krishna", 100, true));
			assertTrue(directory.search("Krishna").size() > 0);
			assertTrue(directory.search("Mohan").size() == 0);
		}catch(Exception e){
			fail();
		}
	}
}
