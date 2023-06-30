package com.example.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Serializable>  {
	
	public Employee findById(Integer Id);
	
	
	@Query(value = "select * from employee c where city=?1", nativeQuery = true)
	public List<Employee> findByCity(String city);
 }
