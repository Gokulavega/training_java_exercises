package com.Avega.Training.ServiceImp;

import java.util.List;

import com.Avega.Training.Dao.EmployeeDao;
import com.Avega.Training.DaoImp.EmployeeDaoImp;
import com.Avega.Training.Execption.EmployeeNotFoundExecption;
import com.Avega.Training.Pojo.Employee;
import com.Avega.Training.Service.EmployeeService;

public class EmployeeServiceImp implements EmployeeService{
	
	EmployeeDao dao = null;

	public EmployeeServiceImp() {
		this.dao = new EmployeeDaoImp();
	}

	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return dao.getAllEmployee();
	}

	@Override
	public Employee findEmployee(String id) throws EmployeeNotFoundExecption {
		// TODO Auto-generated method stub
		return dao.getEmployee(id);
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
	public boolean editEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(employee);
	
	}
}
