package com.wdxxl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wdxxl.domain.Employee;
import com.wdxxl.services.RemoteCallService;

@Controller
public class ConsumerControllerFeignClient {
	@Autowired
	private RemoteCallService remoteCallService;

	public Employee getEmployee() {
		Employee emp = remoteCallService.getData();
		return emp;
	}
}
