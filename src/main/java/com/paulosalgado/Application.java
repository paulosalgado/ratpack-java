package com.paulosalgado;

import java.util.ArrayList;
import java.util.List;

import ratpack.jackson.Jackson;
import ratpack.server.RatpackServer;

public class Application {
	
	public static void main(String[] args) throws Exception {
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1L, "Mr", "John Doe"));
		employees.add(new Employee(2L, "Mr", "White Snow"));
		
		RatpackServer.start(
				server -> server.handlers(
				chain -> chain.all(new RequestValidatorFilter())
			.get("", ctx -> ctx.render("Welcome to Baeldung ratpack!!!"))
			.get(":name", ctx -> ctx.render("Hello " + ctx.getPathTokens().get("name") + "!!!"))
			.get("data/employees", ctx -> ctx.render(Jackson.json(employees)))));
    }
	
}
