package com.wdxxl;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootHelloWorldApplication {

	@Value("${server.port}")
	String serverPort;

	@RequestMapping(value = "/employee")
	public String getEmployee() {
		List<String> greetings = Arrays.asList("Employee1", "Employee2", "Employee3");
		Random rand = new Random();
		int randomNum = rand.nextInt(greetings.size());
		return serverPort + " : " + greetings.get(randomNum);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
	}

}
