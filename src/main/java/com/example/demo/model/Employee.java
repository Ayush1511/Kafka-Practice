package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "employee")
@Builder
public class Employee {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private int salary;

    @Column(name = "city")
    private String city;

    @Column(name = "email")
    private String email;

    @Column(name = "created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @UpdateTimestamp
    private Date createdAt;
    
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer id, String name, int salary, String city, String email, Date createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.city = city;
		this.email = email;
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
    
}

