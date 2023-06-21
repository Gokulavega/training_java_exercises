package com.Avega.Training.Client;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.Avega.Training.Comparator.ScoreComparator;
import com.Avega.Training.Execption.EmployeeNotFoundExecption;
import com.Avega.Training.Execption.SkillNotFoundExecption;
import com.Avega.Training.Pojo.Allocation;
import com.Avega.Training.Pojo.Employee;
import com.Avega.Training.Pojo.Skill;
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
	
	public static void main(String[] args) throws IOException, EmployeeNotFoundExecption, SkillNotFoundExecption {
		
		SkillService skill = new SkillServiceImp();
		EmployeeService employee = new EmployeeServiceImp();
		TrainingService training = new TrainingServiceImp();
		AllocationService allocation = new AllocationServiceImp();
		
		skill.loadExcelToDB("C:\\Users\\Gokul\\skill.xlsx");
		
		allocation.createAllocation(new Allocation("ALL001","TR001","EMP001","pass",75,"good"));
		allocation.createAllocation(new Allocation("ALL002","TR002","EMP002","pass",85,"good"));
		
		training.loadDBToExcel(Date.valueOf(LocalDate.now()));
		
		training.findAllTraining().forEach(a -> System.out.println(a));
		allocation.findAllAllocation().forEach(a -> System.out.println(a));
		List<Allocation> all = new ArrayList<Allocation>(allocation.findAllAllocation());
		Collections.sort(all, new ScoreComparator());
		all.forEach(a -> System.out.println(a));
		
		Skill s1 = new Skill("sk006","h");
		Skill s2 = new Skill("sk007","u");
		Set<Skill> set1 = new LinkedHashSet<>();
		set1.add(s1);
		set1.add(s2);
		
		employee.createEmployee(new Employee("emp003","h",Date.valueOf(LocalDate.of(2023, 01, 01)),"it","csc",set1));
		training.createTraining(new Training("TR002","tech1",Date.valueOf(LocalDate.of(2023, 01, 01)),Date.valueOf(LocalDate.of(2023, 06, 01)),"02",employee.findEmployee("emp002"),skill.findSkill("SK002")));
		
	}
}
