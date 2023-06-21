package com.Avega.Training.Dao;

import java.util.List;

import com.Avega.Training.Execption.EmployeeNotFoundExecption;
import com.Avega.Training.Pojo.Employee;

public interface EmployeeDao {
	
	List<Employee> getAllEmployee();
	Employee getEmployee(String id) throws EmployeeNotFoundExecption;
	boolean addEmployee(Employee employee);
	boolean deleteEmployee(String id);
	boolean updateEmployee(Employee employee);
}
