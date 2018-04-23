package com.wdxxl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wdxxl.controller.ConsumerControllerClient;
import com.wdxxl.controller.ConsumerControllerRibbonClient;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class ConsumerApplication {

	@Autowired
	private ConsumerControllerClient client;

	@Autowired
	private ConsumerControllerRibbonClient ribbonClient;

	@RequestMapping("/employee")
	public String getEmployee(@RequestParam(value = "name", defaultValue = "wdxxl") String name) {
		String result = client.getEmployee();
		return String.format("%s, %s!", result, name);
	}

	@RequestMapping("/employee_ribbon")
	public String getEmployeeRibbon(@RequestParam(value = "name", defaultValue = "wdxxl") String name) {
		String result = ribbonClient.getEmployee();
		return String.format("%s, %s!", result, name);
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
