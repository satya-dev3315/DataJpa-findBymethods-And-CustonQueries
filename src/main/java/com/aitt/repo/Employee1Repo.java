package com.aitt.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.aitt.entity.Employee1;

public interface Employee1Repo extends CrudRepository<Employee1, Integer> {

	// FindByMethod queries -> to retrieve records based on non primary key column
	// like ->

	// select * from employee1 where emp_department =: dept;
	// here,whatever value we pass as a parameter in main class, that will inject in
	// this method param , hence we wrote :dept,so it get value at runtime
	// here findBy is mandatory, and then concat required variable name frm entity
	// class
	// we took return type as list because there can me many candidates in
	// department
	// generated query by this method automatically by jpa is: select * from
	// employee1 where emp_department = :dept;

	// public List<Employee1> findByEmpDepartment(String dept);
	// public List<Employee1> findByEmpGender(String gender);

	// select * from employee1 where emp_department = :dept and emp_gender= :gender;
	// //position n order r imp here
	// public List<Employee1> findByEmpDepartmentAndEmpGender(String dept, String
	// gender);

	// select * from employee1 where emp_salary >= :salary;
	// public List<Employee1> findByEmpSalaryGreaterThanEqual(float salary);

//custom queries-can write any name

//	@Query("from Employee1")
//	public List<Employee1> getAllEmployees();

	// @Query("from Employee1 where empId =:id") //this id must be same as down so
	// down id will itialize n inject to query :id
	// variable id, so it will
	// public Employee1 getEmpById(Integer id);

	// select queries

//	@Query("from Employee1")
//	public List<Employee1> getAllEmpsUsingHql();

//	@Query(value = "select * from employee1" , nativeQuery = true)
//	public List<Employee1> getAllEmpsUsingSql();

	// above we have hql n sql queries performing same operations,
	// so jpa will consider above hql by default query n convert it to sql,but down
	// query we
	// need to tell to jpa that dont convert this down query into sql because its
	// already is sql query .By default jpa will take hql query.

	/*
	 * By default every time any query is passed as hql, it will consider it as a
	 * select query. But if we want to execute non select queries like insertion,
	 * updation n deletion we need to inform jpa about it otherwise it will throw
	 * exception. For that use @Modifying .When we r retrieving the
	 * data @Transaction is nt required but if we r inserting,updating or delting ,
	 * its required.When we want to modify the table data using custom query
	 * , @Transactional is req.For retrieve/select/get queries Transactional n
	 * modifying nt required
	 */

	// delete query, we returing emp obj as one record = one obj

//	@Transactional
//	@Modifying
//	@Query("delete from Employee1 where empId=:eId")
//	public void deleteRecordUsing_id(Integer eId);
//	

	// update query : we r updatin using empId

//	@Transactional
//	@Modifying
//	@Query("update Employee1 set empName=:eName where empId=:eId") 
//	public void updateRecordUsingId(String eName,Integer eId);
	
	
	//getting 2 records
	
	@Query(value = "select emp_name as empName , emp_department as empDepartment from Employee1",nativeQuery = true)
	public List<GetNameAndDeptI> getNameAndDeptsHql();
	
//	@Transactional
//	@Modifying
//	@Query(value ="INSERT INTO Employee1 (emp_id, emp_name, emp_salary,emp_gender,emp_department) "
//			+ "SELECT customer_id, customer_name, customer_salary,customer_gender,customer_department FROM Customer",nativeQuery = true)
//	public void insertRecordHql();
	
	
	@Transactional
	@Modifying
	@Query(value ="INSERT INTO Employee1 (emp_id, emp_name, emp_salary,emp_gender,emp_department) "
			+ "SELECT customer_id, customer_name, customer_salary,customer_gender,customer_department FROM Customer",nativeQuery = true)
	public void insertRecordHql();

}
