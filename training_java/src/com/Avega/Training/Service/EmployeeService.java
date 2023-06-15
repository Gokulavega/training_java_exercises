package com.Avega.Training.Service;

import java.util.List;

import com.Avega.Training.Execption.EmployeeNotFoundExecption;
import com.Avega.Training.Pojo.Employee;

public interface EmployeeService {
	
	List<Employee> findAllEmployee();
	Employee findEmployee(String id) throws EmployeeNotFoundExecption;
	boolean createEmployee(Employee employee);
	boolean removeEmployee(String id);
	boolean editEmployee(Employee employee);
}
