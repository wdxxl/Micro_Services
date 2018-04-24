package com.wdxxl.services;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wdxxl.domain.Employee;

@FeignClient(name="employee-producer")
public interface RemoteCallService {
	@RequestMapping(method=RequestMethod.GET, value="/employee_obj")
	public Employee getData();
}
