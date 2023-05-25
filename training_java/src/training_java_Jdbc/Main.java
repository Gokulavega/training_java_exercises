package training_java_Jdbc;

import java.sql.Date;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		
		EmployeeService emp = new EmployeeServiceImp();
		
//		emp.createEmployee(new Employee("131015","ravi",Date.valueOf(LocalDate.of(2020, 02, 02)),10000.00));
//		emp.createEmployee(new Employee("131017","kumar",Date.valueOf(LocalDate.of(2020, 02, 02)),10000.00));
//		emp.createEmployee(new Employee("131003","hemanth",Date.valueOf(LocalDate.of(2020, 02, 02)),10000.00));
		emp.createEmployee(new Employee("131005","hema",Date.valueOf(LocalDate.of(2020, 02, 02)),10000.00));
		
		emp.findAllEmployee().forEach(employee -> System.out.println(employee));
		
		System.out.println(emp.findEmployee("131015"));
		
		emp.removeEmployee("131005");
		
		emp.editEmployee(new Employee("131015","ravi king",Date.valueOf(LocalDate.of(2020, 02, 02)),10000.00));
	}

}
