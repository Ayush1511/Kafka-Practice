package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmpRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.List;

@Service
public class EmpService {
	@Autowired
	EmpRepository empRepository;
	
	public String saveEmployee(Employee employee)throws JsonProcessingException {
		Employee emp=empRepository.save(employee);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(emp);

    return json;
	}
	 public String createManager(int id) throws JsonProcessingException {

	        Optional<Employee> employee = empRepository.findById(id);

	        if(employee.isPresent()){
	            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	            String json = ow.writeValueAsString(employee.get());

	            return json;
	        }else{
	            return "not exist";
	        }
	    }
	  public List<Employee> saveEmployees(List<Employee> employees) {
	        return empRepository.saveAll(employees);
	    }
	  
	  public String getEmployees()throws JsonProcessingException {
		  List<Employee> employee = empRepository.findAll();
	        if(employee.size() > 0){
	            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	            String json = ow.writeValueAsString(employee);
	            return json;
	        }else{
	            return "No Employee Found";
	        }
	    }
	
	public String getById(int id)throws JsonProcessingException {
		Optional<Employee> optional = empRepository.findById(id);
		if(optional.isPresent()) {
			 ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	         String json = ow.writeValueAsString(optional.get());
	         return json;
		}
		else {
			return "Employee not found";
		}
	}
	
	  public String getByName(String name)throws JsonProcessingException {
	         Employee emp = empRepository.findByName(name);
	         if(emp!=null) {
	        	 ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		         String json = ow.writeValueAsString(emp);
		         return json; 
	         }
	         else {
	 			return "Employee not found";
	 		}
	    }
	  
	  

}
