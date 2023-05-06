package training_java_map;

import java.util.List;

public interface EmployeeInerface {
	
	List<Employee> getEmployee();
	
	List<Employee> getEmployeeByName(String name);
	
	Employee getEmployeeById(int id);
	
	boolean addEmployee(Employee employee);
	
	boolean deleteEmployee(Employee employee);
	
	Employee updateEmployee(Employee employee);

}
