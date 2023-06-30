package com.example.service;

import java.util.List;

import com.example.model.Employee;
import com.exceptionhandler.NullPointerException;

public interface EmployeeService {
	
	// insert data
	public Employee saveEmployee(Employee employee);
	
	// get data by id
	public Employee getEmployeeById(Integer Id);
	
	//delete data by id
	public void deleteEmployee(Integer id) throws NullPointerException;
	
	
	// update employee by id 
	public Employee updateEmployee(Integer id,Employee employee) throws NullPointerException;
	
	// get all data
	public List<Employee> getAllEmpData();
	
	//find list by city
	public List<Employee> findByCity(String city);

}
