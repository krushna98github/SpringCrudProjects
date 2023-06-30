package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import com.exceptionhandler.NullPointerException;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

        // Insert Employee Data...
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	   // Get Employee by id ....
	@Override
	public Employee getEmployeeById(Integer Id) {
		Employee employee = employeeRepository.findById(Id);
		return employee;
	}

        // delete employee by id...
	@Override
	public void deleteEmployee(Integer id) throws NullPointerException {
		if(id != null) {
		employeeRepository.deleteById(id);
		}else {
			throw new NullPointerException("The Given Id is Null");
		}
	}

      //update employee by id 
	@Override
	public Employee updateEmployee(Integer id, Employee employee) throws NullPointerException {
		Employee emp = employeeRepository.findById(id);
		Employee empl = null;
		if(emp == null) {
	       throw new NullPointerException("The Given Id is Null");
		}else {
			emp.setCity(employee.getCity());
		    emp.setName(employee.getName());
		     empl = employeeRepository.save(emp);
		}
		      return empl;
	}

	@Override
	public List<Employee> getAllEmpData() {
		return (List<Employee>) employeeRepository.findAll();
		
	}

	@Override
	public List<Employee> findByCity(String city) {
		List<Employee> employee = employeeRepository.findByCity(city);
		return employee;
	}
	
}
