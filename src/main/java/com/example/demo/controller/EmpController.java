package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmpService;
import com.example.demo.service.KafkaProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sample.spring.kafka.services.KafKaProducerService;

import java.util.List;

@RestController
public class EmpController {
@Autowired
EmpService empService;

@Autowired
private KafkaProducerService producerService;

@PostMapping("/addEmployee")
public String addEmployee(@RequestBody Employee employee)throws JsonProcessingException {
    return empService.saveEmployee(employee);
}

@PostMapping("/addEmployees")
public List<Employee> addEmployee(@RequestBody List<Employee> employees) {
    return empService.saveEmployees(employees);
}

@GetMapping("/employees")
public String findAllEmployees() throws JsonProcessingException{
    return empService.getEmployees();
}

@GetMapping("/employeeById")
public String findEmployeeById(@RequestParam int id) throws JsonProcessingException {
    return empService.getById(id);
}


@GetMapping("/employeeByName")
public String findEmployeeByName(@RequestParam String name) throws JsonProcessingException{
    return empService.getByName(name);
}

@PostMapping("/createManager/{id}")
public String createManagerUsingKafka(@PathVariable("id") int id) throws JsonProcessingException {
    return producerService.createManager(id);
}
       
}
