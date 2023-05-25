package training_java;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {
	
	List<Employee> getAllEmployee();
	Employee getEmployee(String id) throws EmployeeNotFoundException;
	List<Skill> getSkill(String id);
	boolean addEmployee(Employee employee);
	boolean deleteEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	boolean assignSkillToEmployee(String employeeId, List<Skill> skill);
}
