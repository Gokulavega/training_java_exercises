package training_java;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
	
	List<Employee> findAllEmployee();
	Employee findEmployee(String id);
	List<Skill> findAllSkill(String id);
	boolean createEmployee(Employee employee);
	boolean removeEmployee(Employee employee);
	Employee editEmployee(Employee employee);
	Map<String, String> getEmployeeBySkill();
}
