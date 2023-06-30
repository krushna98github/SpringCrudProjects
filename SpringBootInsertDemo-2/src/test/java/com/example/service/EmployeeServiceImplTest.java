package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class EmployeeServiceImplTest {
	
	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;
	
	@Mock
	EmployeeRepository employeeRepository;
	
	@Test
	public void saveEmployeeTest() {
		Employee employee1 = new Employee();
		employee1.setId(10);
		employee1.setName("Krushna");
		employee1.setCity("Shirdi");
		
		when(employeeRepository.save(employee1)).thenReturn(employee1);
		assertEquals(employee1, employeeServiceImpl.saveEmployee(employee1));
	}
	
	
	

}
