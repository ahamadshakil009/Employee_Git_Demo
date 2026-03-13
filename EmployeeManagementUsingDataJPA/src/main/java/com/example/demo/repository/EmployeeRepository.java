package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Employee;
//															.--> Entity class name
//														    |			.--> primary key DataType
//															|			|
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{ // persist(),merge(),remove(),find()--> 1 row operation
																				// createQueary()--> for multi row operations

	

	@Query("select e from Employee e where e.empDesg =?1")
	public abstract List<Employee> getEmployeeByDesg(String empDesg);//

	@Query("select e from Employee e where e.empSal between ?1 and ?2")
	public abstract List<Employee> getEmployeeBetweenSal(int initialSal, int finalSal);
}


//Repository
//CRUDRepository--> for basic CRUD operation
//JpaRepository --> for pagination and other functions