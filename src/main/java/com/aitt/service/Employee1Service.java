package com.aitt.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.aitt.entity.Employee1;
import com.aitt.repo.Employee1Repo;
import com.aitt.repo.GetNameAndDeptI;

@Service
public class Employee1Service {

	// for dependency injection use this n create cons
	private Employee1Repo repo;

	public Employee1Service(Employee1Repo repo) {
		super();
		this.repo = repo;
	}

	// to insert records in table
	public void saveMultipleRecords() {

		Employee1 employee1 = new Employee1();
		employee1.setEmpId(101);
		employee1.setEmpName("Eric");
		employee1.setEmpGender("male");
		employee1.setEmpDepartment("sales");
		employee1.setEmpSalary(20000.89);

		Employee1 employee2 = new Employee1();
		employee2.setEmpId(102);
		employee2.setEmpName("Trish");
		employee2.setEmpGender("female");
		employee2.setEmpDepartment("sales");
		employee2.setEmpSalary(25000.77);

		Employee1 employee3 = new Employee1();
		employee3.setEmpId(103);
		employee3.setEmpName("Rob");
		employee3.setEmpGender("male");
		employee3.setEmpDepartment("manager");
		employee3.setEmpSalary(35000.55);

		Employee1 employee4 = new Employee1();
		employee4.setEmpId(104);
		employee4.setEmpName("Ema");
		employee4.setEmpGender("female");
		employee4.setEmpDepartment("manager");
		employee4.setEmpSalary(28000.55);

		List<Employee1> asList = Arrays.asList(employee1, employee2, employee3, employee4);
		asList.forEach(System.out::println);
	}

//	public void getEmployeesByDepartment(String dept) {
//		List<Employee1> list = repo.findByEmpDepartment(dept);
//		list.forEach(System.out::println);

//	public void getEmployeesByGender(String gender) {
//		List<Employee1> list = repo.findByEmpGender(gender);
//		list.forEach(System.out::println);

//	public void getEmployeesByDepartmentAndGender(String dept,String gender) {
//		List<Employee1> list = repo.findByEmpDepartmentAndEmpGender(dept, gender);
//		list.forEach(System.out::println);
//	}

//	public void getEmpSalaryGreaterThanEqual(float salary) {
//		List<Employee1> list = repo.findByEmpSalaryGreaterThanEqual(salary);
//		list.forEach(System.out::println);
//	}

	// custom queries

//	public void getAllEmpRecords() {
//		List<Employee1> list = repo.getAllEmployees();
//		list.forEach(System.out::println);

//	public void getEmpUsingId() {
//		Employee1 emp = repo.getEmpById(101);
//		System.out.println(emp);
//	}

//	public void getAllEmpsUsingHql() {
//		List<Employee1> allEmpsUsingHql = repo.getAllEmpsUsingHql();
//		allEmpsUsingHql.forEach(System.out::println);
//	}

//	public void getAllEmpsUsingSql() {
//		List<Employee1> allEmpsUsingSql = repo.getAllEmpsUsingSql();
//		allEmpsUsingSql.forEach(System.out::println);
//	}

//	public void deleteRecordUsing_id(Integer eId) {
//		repo.deleteRecordUsing_id(eId);
//	}

//	public void updateRecordUsingEmpId(String eName,Integer eId) {
//		repo.updateRecordUsingId(eName, eId);
//	}

	// retrieve emp name n dept

	public void getNameAndDeptsHql() {
		List<GetNameAndDeptI> nameAndDeptsHql = repo.getNameAndDeptsHql();
		nameAndDeptsHql.forEach(e -> System.out.println(e.getEmpName() + ":" + e.getEmpDepartment()));
	}

	
	// insert a record

	public void insertRecordHql() {
		repo.insertRecordHql();
	}
}
