package com.glarimy.spring.directory.rest;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.glarimy.spring.directory.api.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
public class DirectoryControllerIntegrationTests {
	@Test
	public void addEmployee() {
		Employee employee = new Employee("Krishna Mohan", 100000, true);
		RestTemplate restTemplate = new RestTemplate();
		URI uri = restTemplate.postForLocation("http://localhost:2310/glarimy/directory/employee", employee,
				Employee.class);
		String path = uri.getPath();
		try {
			assertTrue(Integer.parseInt(path.substring(path.lastIndexOf("/") + 1)) > 0);
		} catch (NumberFormatException nfe) {
			fail("id is invalid");
		}
	}

}
