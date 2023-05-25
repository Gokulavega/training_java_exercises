package training_java_Jdbc;

import java.util.List;

import training_java.EmployeeNotFoundException;

public interface EmployeeDao {
	
	List<Employee> getAllEmployee();
	Employee getEmployee(String id) throws EmployeeNotFoundException;
	boolean addEmployee(Employee employee);
	boolean deleteEmployee(String id);
	Employee updateEmployee(Employee employee);
}
