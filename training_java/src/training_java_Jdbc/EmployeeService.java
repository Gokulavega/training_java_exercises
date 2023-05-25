package training_java_Jdbc;

import java.util.List;

public interface EmployeeService {
	
	List<Employee> findAllEmployee();
	Employee findEmployee(String id);
	boolean createEmployee(Employee employee);
	boolean removeEmployee(String id);
	Employee editEmployee(Employee employee);
}
