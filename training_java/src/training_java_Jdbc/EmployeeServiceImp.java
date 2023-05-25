package training_java_Jdbc;

import java.util.List;

import training_java.EmployeeNotFoundException;

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
	public boolean createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return dao.addEmployee(employee);
	}

	@Override
	public boolean removeEmployee(String id) {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(id);
	}

	@Override
	public Employee editEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(employee);
	}
}
