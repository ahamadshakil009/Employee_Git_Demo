package com.example.demo.service;


import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.example.demo.exceptions.EmployeeNotFound;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	
	EmployeeRepository repository;
	
//	public EmployeeServiceImpl(EmployeeRepository repository) {
//		super();
//		this.repository = repository;
//	}

	@Override
	public String saveEmployee(Employee employee) {
		repository.save(employee);
		return "Employee Saved Successfully";
	}

	@Override
	public String updateEmployee(Employee employee) {

		repository.save(employee);
		return "Employee Updated Successfully";
	}

	@Override
	public String delateEmployee(int empId) {
		repository.deleteById(empId);
		return "Employee deleted";
	}

	@Override
	public Employee getEmployee(int empId) throws EmployeeNotFound {
		Optional<Employee> optional = repository.findById(empId);
		
		
		if(optional.isEmpty()) {
			throw new EmployeeNotFound("no Employee found with given Id..");
		}
		else {
		return optional.get();
		}
	}

	@Override
	public List<Employee> getAllEmployee() {

		return repository.findAll();
	}

	@Override
	public List<Employee> getEmployeeByDesg(String empDesg) {

		return repository.getEmployeeByDesg(empDesg);
	}

	@Override
	public List<Employee> getEmployeeBetweenSal(int initialSal, int finalSal) {

		return repository.getEmployeeBetweenSal(initialSal, finalSal);
	}




}
