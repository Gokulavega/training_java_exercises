package training_java;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		SkillService skillService = new SkillServiceImp();
		EmployeeService employeeService = new EmployeeServiceImp();
		
		Skill s1 = new Skill("101310","java",null);
		Skill s2 = new Skill("101314","spring boot",null);
		Skill s3 = new Skill("101317","angular",null);
		Skill s4 = new Skill("101313","node js",null);
		
		Set<Skill> set1 = new LinkedHashSet<>();
		set1.add(s1);
		set1.add(s2);
		
		Set<Skill> set2 = new LinkedHashSet<>();
		set2.add(s3);
		set2.add(s4);
		
		Set<Skill> set3 = new LinkedHashSet<>();
		set3.add(s1);
		set3.add(s4);
		
		skillService.createSkill(s1);
		skillService.createSkill(s2);
		skillService.createSkill(s3);
		skillService.createSkill(s4);
		
		employeeService.createEmployee(new Employee("1301513","ravi",LocalDate.of(2013, 06, 13),10000.00,set1));
		employeeService.createEmployee(new Employee("1301515","kumar",LocalDate.of(2015, 06, 15),10000.00,set2));
		employeeService.createEmployee(new Employee("1301517","peter",LocalDate.of(2017, 06, 17),10000.00,set3));
		System.out.println(employeeService.findEmployee("1301513"));
		System.out.println(employeeService.getEmployeeBySkill());
	}

}
