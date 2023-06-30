package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import com.exceptionhandler.NullPointerException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	//AutoWiring to the Service class...
	@Autowired
	private EmployeeService employeeService;

	
	// insert employee data 
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.saveEmployee(employee);
		System.out.println(emp);
		return ResponseEntity.ok().body(emp);
	}
	
	// Get Employee Data by id...
	@GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id){
	  Employee emp = employeeService.getEmployeeById(id);
	  return ResponseEntity.ok().body(emp);
  }
	// Delete Employee Data...
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable Integer id) throws NullPointerException {
		employeeService.deleteEmployee(id);
	}
	
	//update employee by id 
	@PutMapping("/update/{id}")  
	public Employee update(@PathVariable("id") Integer id, @RequestBody Employee employee) throws NullPointerException {  
	Employee emp = employeeService.updateEmployee( id, employee);
	   return emp;  
	}  
	
	//Get All Employee Data...
	@GetMapping("/getalldata")
    public List<Employee> getAllPets() {
		List<Employee> emp =  (List<Employee>) employeeService.getAllEmpData();
		return (List<Employee>) emp;
    }  
	
	// Find data list by city 3
	@GetMapping("/getbycity/{city}")
	public ResponseEntity<List<Employee>> findByCity(@PathVariable("city") String city){
		List<Employee> emplist = employeeService.findByCity(city);
		return ResponseEntity.ok().body(emplist);
	}
	
 }
