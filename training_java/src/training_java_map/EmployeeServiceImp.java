package training_java_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImp implements EmployeeInerface {

	Map<Integer, Employee> map = new HashMap<>();
	
	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return new ArrayList(map.values());
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		List<Employee> employeeList = new ArrayList<>();
		for(Employee employee : map.values()) {
			if(employee.getName().equalsIgnoreCase(name)) {
				employeeList.add(employee);
			}
		}
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return map.get(id);
	}

	@Override
	public boolean addEmployee(Employee employee) {
		boolean flag = false;
		map.put(employee.getEmpId(), employee);
		if(map.get(employee.getEmpId()) != null)
			flag = true;
		return flag;
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		boolean flag = false;
		map.remove(employee.getEmpId());
		if(map.get(employee.getEmpId()) == null)
			flag = true;
		return flag;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee updateEmployee = null;
		updateEmployee = map.get(employee.getEmpId());
		updateEmployee.setName(employee.getName());
		updateEmployee.setSalary(employee.getSalary());
		updateEmployee.setDesignation(employee.getDesignation());
		map.put(employee.getEmpId(), updateEmployee);
		return updateEmployee;
	}

}
