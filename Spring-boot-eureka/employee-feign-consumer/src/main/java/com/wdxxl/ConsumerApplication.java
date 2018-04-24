package com.wdxxl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wdxxl.controller.ConsumerControllerFeignClient;
import com.wdxxl.domain.Employee;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerApplication {

	@Autowired
	private ConsumerControllerFeignClient feignClient;

	@RequestMapping("/employee_feign")
	public String getEmployee(@RequestParam(value = "name", defaultValue = "wdxxl") String name) {
		Employee emp = feignClient.getEmployee();
		return String.format("%s, %s!", emp.toString(), name);
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
