package com.Avega.Training.Client;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import com.Avega.Training.Pojo.Allocation;
import com.Avega.Training.Pojo.Employee;
import com.Avega.Training.Pojo.Training;
import com.Avega.Training.Service.AllocationService;
import com.Avega.Training.Service.EmployeeService;
import com.Avega.Training.Service.SkillService;
import com.Avega.Training.Service.TrainingService;
import com.Avega.Training.ServiceImp.AllocationServiceImp;
import com.Avega.Training.ServiceImp.EmployeeServiceImp;
import com.Avega.Training.ServiceImp.SkillServiceImp;
import com.Avega.Training.ServiceImp.TrainingServiceImp;

public class TestClient {
	
	public static void main(String[] args) throws IOException {
		
		SkillService skill = new SkillServiceImp();
		EmployeeService employee = new EmployeeServiceImp();
		TrainingService training = new TrainingServiceImp();
		AllocationService allocation = new AllocationServiceImp();
		
		skill.loadExcelToDB("C:\\Users\\Gokul\\skill.xlsx");
		
		employee.createEmployee(new Employee("EMP001","arun",Date.valueOf(LocalDate.of(2003, 03, 13)),"developer","it","SK003"));
		employee.createEmployee(new Employee("EMP002","kumar",Date.valueOf(LocalDate.of(2006, 06, 13)),"developer","it","SK003"));
		employee.createEmployee(new Employee("EMP003","santhanam",Date.valueOf(LocalDate.of(2009, 9, 13)),"developer","it","SK003"));
		
		training.createTraining(new Training("TR001","tech",Date.valueOf(LocalDate.of(2023, 01, 05)),Date.valueOf(LocalDate.of(2023, 06, 05)),"01","arun","SK003"));
		training.createTraining(new Training("TR002","logics",Date.valueOf(LocalDate.of(2023, 06, 05)),Date.valueOf(LocalDate.of(2023, 9, 05)),"01","kumar","SK003"));
		
		allocation.createAllocation(new Allocation("ALL001","TR001","EMP001","pass",75,"good"));
		allocation.createAllocation(new Allocation("ALL002","TR002","EMP002","pass",85,"good"));
		
		training.loadDBToExcel(Date.valueOf(LocalDate.now()));
		
	}
}
