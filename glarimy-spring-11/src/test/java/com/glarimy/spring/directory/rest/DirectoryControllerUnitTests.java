package com.glarimy.spring.directory.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.glarimy.spring.directory.api.Directory;
import com.glarimy.spring.directory.api.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = DirectoryController.class, secure = false)
public class DirectoryControllerUnitTests {
	@Autowired
	private MockMvc web;

	@MockBean
	private Directory directory;

	@Test
	public void addEmployee() throws Exception {
		Mockito.when(directory.add(Mockito.any(Employee.class))).thenReturn(1);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/directory/employee")
				.accept(MediaType.APPLICATION_JSON).content("{\"name\":\"Krishna Mohan\"}")
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = web.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		String path = response.getHeader(HttpHeaders.LOCATION);
		try {
			assertTrue(Integer.parseInt(path.substring(path.lastIndexOf("/") + 1)) == 0);
		} catch (NumberFormatException nfe) {
			fail("id is invalid");
		}
	}
}
