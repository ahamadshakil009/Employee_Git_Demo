package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.EmployeeNotFound;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController //@Controller + @ResponseBody
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {

    private  EmployeeService service; // http://localhost:1009:employees


	
	
	
	@GetMapping("/message") //http://localhost:1009/employees/message
	public String getMessage() {
		return "leave us we are getting sleep!!";
	}
	
	@PostMapping("/save")
	public String createEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}
	
	@PutMapping("/update")
	public String updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public String removeEmployee(@PathVariable("id") int empId) {
		return service.delateEmployee(empId);
	}
	
	@GetMapping("/fetch/{id}")
	public Employee getEmployee(@PathVariable("id") int empId) throws EmployeeNotFound{
		return service.getEmployee(empId);
	}
	
	@GetMapping("/fetchAll")
	public List<Employee> getAllEmployee(){
		return service.getAllEmployee();
	}
	
	@GetMapping("/fetchAllByDesg/{empDesg}")
	public List<Employee> getAllEmployeeByDesg(@PathVariable String empDesg){
		return service.getEmployeeByDesg(empDesg);
	}
	
	@GetMapping("/fetchAllBetween")
	public List<Employee> getllEmployees(@RequestParam("sal1") int initialSal,@RequestParam("sal2") int finalSal){
		return service.getEmployeeBetweenSal(initialSal, finalSal);
	}
	
	
}
