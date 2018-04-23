package com.wdxxl.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ProducerController {

	@Value("${server.port}")
	String serverPort;

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public String firstPage() {
		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);
		if (emp.getName().equalsIgnoreCase("emp1")) {
			throw new RuntimeException();
		}
		return getGreetings() + emp.toString();
	}

	public String getDataFallBack() {
		Employee emp = new Employee();
		emp.setName("fallback-emp1");
		emp.setDesignation("fallback-manager");
		emp.setEmpId("fallback-1");
		emp.setSalary(3000);
		return getGreetings() + emp.toString();
	}

	public String getGreetings() {
		List<String> greetings = Arrays.asList("Employee1", "Employee2", "Employee3");
		Random rand = new Random();
		int randomNum = rand.nextInt(greetings.size());
		return serverPort + " : " + greetings.get(randomNum);
	}
}
