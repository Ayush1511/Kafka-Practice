package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpRequest {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EmpRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String name;
    private String salary;
    private String city;
    private String email;
	public EmpRequest(String name, String salary, String city, String email) {
		super();
		this.name = name;
		this.salary = salary;
		this.city = city;
		this.email = email;
	}
}
