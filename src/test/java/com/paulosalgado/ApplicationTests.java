package com.paulosalgado;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ratpack.test.MainClassApplicationUnderTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	
	MainClassApplicationUnderTest appUnderTest = new MainClassApplicationUnderTest(Application.class);
	
	@Test
	public void givenDefaultUrl_getStaticText() {
		assertEquals("Welcome to Baeldung ratpack!!!", appUnderTest.getHttpClient().getText("/"));
	}
	
	@Test
	public void givenDynamicUrl_getDynamicText() {
		assertEquals("Hello dummybot!!!", appUnderTest.getHttpClient().getText("/dummybot"));
	}
	
	@Test
	public void givenUrl_getListOfEmployee() throws JsonProcessingException {
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1L, "Mr", "John Doe"));
		employees.add(new Employee(2L, "Mr", "White Snow"));
		
		ObjectMapper mapper = new ObjectMapper();
		
		assertEquals(mapper.writeValueAsString(employees), appUnderTest.getHttpClient().getText("/data/employees"));
	}
	
	@After
	public void shutdown() {
		appUnderTest.close();
	}
	
}
