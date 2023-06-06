package training_java_Jdbc;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) throws SQLException, IOException {
		
		EmployeeService emp = new EmployeeServiceImp();
		
//		emp.createEmployee(new Employee("131015","ravi",Date.valueOf(LocalDate.of(2020, 02, 02)),10000.00));
//		emp.createEmployee(new Employee("131017","kumar",Date.valueOf(LocalDate.of(2020, 02, 02)),10000.00));
//		emp.createEmployee(new Employee("131003","hemanth",Date.valueOf(LocalDate.of(2020, 02, 02)),10000.00));
//		emp.createEmployee(new Employee("131005","hema",Date.valueOf(LocalDate.of(2020, 02, 02)),10000.00));
//		
//		emp.findAllEmployee().forEach(employee -> System.out.println(employee));
//		
//		System.out.println(emp.findEmployee("131015"));
//		
//		emp.removeEmployee("131005");
//		
//		emp.editEmployee(new Employee("131015","ravi king",Date.valueOf(LocalDate.of(2020, 02, 02)),10000.00));
//		
//		emp.writeFile(new Employee("131012","arun",Date.valueOf(LocalDate.of(2023, 02, 02)),10000.00));
//		emp.writeFile(new Employee("131016","naveen",Date.valueOf(LocalDate.of(2023, 02, 06)),10000.00));
//		emp.writeFile(new Employee("131018","kavya",Date.valueOf(LocalDate.of(2023, 01, 15)),10000.00));
//		emp.writeFile(new Employee("131014","linga",Date.valueOf(LocalDate.of(2023, 01, 06)),10000.00));
//		
//		emp.readFile();
		
//		emp.findAllEmployee().forEach(employee -> System.out.println(employee));
//		
//		System.out.println(emp.addBatch());
//		
//		emp.findAllEmployee().forEach(e -> System.out.println(e));
		
		emp.loadDBToExcel("C:\\Users\\Gokul\\employee.xlsx");
		
//		emp.callableStatement();
	}

}
