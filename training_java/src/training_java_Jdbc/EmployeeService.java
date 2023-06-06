package training_java_Jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
	
	List<Employee> findAllEmployee();
	Employee findEmployee(String id);
	boolean createEmployee(Employee employee);
	boolean removeEmployee(String id);
	Employee editEmployee(Employee employee);
	boolean writeFile(Employee employee);
	boolean readFile();
	int addBatch() throws SQLException;
	boolean callableStatement();
	List<String> convertFileToList();
	public void loadDBToExcel(String excelFilePath) throws IOException;
}
