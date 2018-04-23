package com.wdxxl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class ConsumerControllerRibbonClient {
	@Autowired
	private LoadBalancerClient loadBalancer;

	public String getEmployee(){
		ServiceInstance serviceInstance = loadBalancer.choose("employee-producer");
		String baseUrl = serviceInstance.getUri().toString();

		baseUrl=baseUrl+"/employee";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		return response.getBody();
	}

	private static HttpEntity<?> getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}

}
