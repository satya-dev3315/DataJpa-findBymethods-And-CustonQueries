package com.aitt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.aitt.service.Employee1Service;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(Application.class, args);
		Employee1Service employee1Service = context.getBean(Employee1Service.class);
		//employee1Service.saveMultipleRecords();
		//employee1Service.getEmployeesByDepartment("sales");
		//employee1Service.getEmployeesByGender("male");
		//employee1Service.getEmployeesByDepartmentAndGender("sales", "female");
		//employee1Service.getEmpSalaryGreaterThanEqual(28000f);
		
		//callin custom queries
		//employee1Service.getAllEmpRecords();
		//employee1Service.getEmpUsingId();
		
		//employee1Service.getAllEmpsUsingHql();
		//employee1Service.getAllEmpsUsingSql();
		
		//employee1Service.deleteRecordUsing_id(104);
		
		//employee1Service.updateRecordUsingEmpId("Satya-Prakash", 101);
		
		//employee1Service.getNameAndDeptsHql();
		
		employee1Service.insertRecordHql();
		
		
	}

}
