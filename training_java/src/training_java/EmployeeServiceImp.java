package training_java;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EmployeeServiceImp implements EmployeeService {
	
	EmployeeDao dao = null;
	
	
	public EmployeeServiceImp() {
		this.dao = new EmployeeDaoService();
	}

	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return dao.getAllEmployee();
	}

	@Override
	public Employee findEmployee(String id) {
		Employee employee = null;
		try {
			employee = dao.getEmployee(id);
		} catch (EmployeeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<Skill> findAllSkill(String id) {
		// TODO Auto-generated method stub
		return dao.getSkill(id);
	}

	@Override
	public boolean createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return dao.addEmployee(employee);
	}

	@Override
	public boolean removeEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(employee);
	}

	@Override
	public Employee editEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(employee);
	}
	
	@Override
	public Map<String, String> getEmployeeBySkill() {
		Map<String,String> employeeList = new ConcurrentHashMap<>();
		List<Employee> employees = dao.getAllEmployee();
		for(Employee employee : employees) {
			if(employee.getEmployeeId() != null) {
				for(Skill skill : employee.getSkills()) {
					if(skill.getSkillName().equalsIgnoreCase("java") || skill.getSkillName().equalsIgnoreCase("spring boot")) {
						employeeList.put(employee.getEmployeeId(), employee.getEmployeeName());
					}
				}
			}
		}
		return employeeList;
	}

}
