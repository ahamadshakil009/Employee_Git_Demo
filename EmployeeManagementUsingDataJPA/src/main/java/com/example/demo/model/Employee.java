package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;


import lombok.NoArgsConstructor;

@Entity
@Table(name = "cts_emp_info")

@Data // Data = @Getter, @Setter, @ToString, NoArgsCons, @RequiredArgsConst
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empno")
	@Min(value = 1,message = "Empid Canot be -ve")
	private int empId;
	
	@NotBlank(message = "Emp name Cannot be Empty/Blank/Null")
	@Column(name = "ename", nullable = false, length = 10)
	@Size(min = 6, max = 145, message = "Name length miust be (6,15)")
	private String empName;
	
	@Min(value= 10000, message = "Salary cannot be below 10000")
	@Max(value=100000, message = "salary cannot be above 100000")
	private int empSal;
	
	@NotEmpty(message = "Desiganation cannot null/empty")
	private String empDesg;

}
