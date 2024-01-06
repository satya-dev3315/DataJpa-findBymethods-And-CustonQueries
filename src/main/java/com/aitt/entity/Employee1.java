package com.aitt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "employee1")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee1 {

	@Id
	@Column(name = "emp_id")
	private Integer empId;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "emp_salary")
	private Double empSalary;

	@Column(name = "emp_gender")
	private String empGender;

	@Column(name = "emp_department")
	private String empDepartment;

}
