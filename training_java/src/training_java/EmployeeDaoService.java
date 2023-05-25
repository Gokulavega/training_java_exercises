package training_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EmployeeDaoService implements EmployeeDao {
	
	List<Skill> skills = new ArrayList<>();
	List<Employee> employees = new ArrayList<>();
	
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employees;
	}

	@Override
	public Employee getEmployee(String id) throws EmployeeNotFoundException {
		Employee employee = null;
		for(Employee employeeList : employees) {
			if(employeeList.getEmployeeId().equals(id)) {
				employee = employeeList;
				break;
			}
		}
		if(employee == null) {
			throw new EmployeeNotFoundException();
		}
		return employee;
	}

	@Override
	public List<Skill> getSkill(String id) {
		List<Skill> skillList = null;
		for(Employee employee : employees) {
			if(employee.getEmployeeId().equalsIgnoreCase(id)) {
				skillList = (List<Skill>) employee.getSkills();
				break;
			}
		}
		return skillList;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employees.add(employee);
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employees.remove(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee updateEmployee = null;
		for(Employee employeeList : employees) {
			if(employeeList.getEmployeeId().equalsIgnoreCase(employee.getEmployeeId())) {
				employeeList.setEmployeeName(employee.getEmployeeName());
				employeeList.setSalary(employee.getSalary());
				employeeList.setDateOfJoining(employee.getDateOfJoining());
				employeeList.setSkills(employee.getSkills());
				updateEmployee = employeeList;
				break;
			}
		}
		return updateEmployee;
	}

	@Override
	public boolean assignSkillToEmployee(String employeeId, List<Skill> skill) {
		boolean flag = false;
		Map<String, Skill> skillList = new ConcurrentHashMap<>();
		for(Employee empList : employees) {
			if(empList.getEmployeeId().equalsIgnoreCase(employeeId)) {
				for(Skill skills : skill) {
					skillList.put(skills.getSkillId(), skills);
				}
			}
		}
		return flag;
	}

}
