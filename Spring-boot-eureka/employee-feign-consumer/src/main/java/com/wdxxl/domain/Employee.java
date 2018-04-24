package com.wdxxl.domain;

import java.io.Serializable;

public class Employee implements Serializable{
	private static final long serialVersionUID = -923627169243467023L;

	private String name;
	private String designation;
	private String empId;
	private int salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", designation=" + designation + ", empId=" + empId + ", salary=" + salary
				+ "]";
	}

}
