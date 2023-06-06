package training_java_Jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import training_java.EmployeeNotFoundException;

public class EmployeeServiceImp implements EmployeeService {
	
	Logger logger = Logger.getLogger(EmployeeServiceImp.class.getName());
	Connection con = Jdbc.getConnected();
	PreparedStatement ps = null;
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

	@Override
	public boolean writeFile(Employee employee) {
		boolean iswrite = false;
		try {
			try (FileOutputStream file = new FileOutputStream("C:\\Users\\Gokul\\record.txt", true)) {
				Employee emp = new Employee();
				emp.setEmployeeId(employee.getEmployeeId());
				emp.setEmployeeName(employee.getEmployeeName());
				emp.setDateOfJoining(employee.getDateOfJoining());
				emp.setSalary(employee.getSalary());
				
				String employeeString = emp.toString() + "\n";
				try {
					file.write(employeeString.getBytes());
					iswrite = true;
					logger.info("write");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				throw e;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return iswrite;
	}

	@Override
	public boolean readFile() {
		boolean isread = false;
		try {
			FileReader file = new FileReader("C:\\Users\\Gokul\\record.txt");
			BufferedReader bufferedReader = new BufferedReader(file);
			String employeeReader;
			String sql = "INSERT INTO employee VALUES(?,?,?,?)";
			try {
				while((employeeReader = bufferedReader.readLine()) != null) {
					String value[] = employeeReader.split(",");
					try {
						ps = con.prepareStatement(sql);
						ps.setString(1, value[0]);
						ps.setString(2, value[1]);
						ps.setDate(3, Date.valueOf(LocalDate.parse(value[2])));
						ps.setDouble(4, Double.parseDouble(value[3]));
						int count = ps.executeUpdate();
						if(count > 0) {
							logger.info("read");
							isread = true;
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isread;
	}

	@Override
	public int addBatch() throws NumberFormatException, SQLException {
		int sum = 0;
		List<String> file = convertFileToList();
			String sql = "INSERT INTO employee VALUES(?,?,?,?)";
			for(String str : file) {
				List<String> record = Arrays.asList(str.split(","));
				ps = con.prepareStatement(sql);
				ps.setString(1, record.get(0));
				ps.setString(2, record.get(1));
				ps.setDate(3, Date.valueOf(LocalDate.parse(record.get(2))));
				ps.setDouble(4, Double.parseDouble(record.get(3)));
				ps.addBatch();
				ps.executeBatch();
				sum++;
			}		
		return sum;
	}

	@Override
	public boolean callableStatement() {
		boolean isCalled = false;
		try {
			CallableStatement cs = con.prepareCall("{?  = call get_count()}");
			cs.registerOutParameter(1, Types.INTEGER);
			
			cs.execute();
			isCalled = true;
			System.out.println(cs.getInt(1));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isCalled;
	}

	@Override
	public List<String> convertFileToList() {
		List<String> result = null;
		try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\Gokul\\record.txt"))) {
			result = lines.collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void loadDBToExcel(String excelFilePath) throws IOException {
		
		List<Employee> employeeList = dao.getAllEmployee();
		
		Workbook workbook = null;
		
		if(excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook();
		} else if(excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook();
		} else {
			throw new IllegalArgumentException("file is not excel file");
		}
		
		// creating sheet
		XSSFSheet sheet = (XSSFSheet) workbook.createSheet();
		
		//styling cell
		CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		Font font = sheet.getWorkbook().createFont();
		font.setBold(true);
		
		font.setFontHeightInPoints((short) 16);
		cellStyle.setFont(font);
		
		//creating header
		Row row = sheet.createRow(0);
		Cell cellEmpId = row.createCell(0);
		
		cellEmpId.setCellStyle(cellStyle);
		cellEmpId.setCellValue("emp_id");
		
		Cell cellName = row.createCell(1);
		cellName.setCellStyle(cellStyle);
		cellName.setCellValue("emp_name");
		
		Cell cellDate = row.createCell(2);
		cellDate.setCellStyle(cellStyle);
		cellDate.setCellValue("emp_date");
		
		Cell cellSalary= row.createCell(3);
		cellSalary.setCellStyle(cellStyle);
		cellSalary.setCellValue("emp_salary");
		
		//creating data cell
		
		int rowCount = 1;
		for (Employee employee : employeeList) {
			row = sheet.createRow(rowCount++);
			
			Cell cell = row.createCell(0);
			cell.setCellValue(employee.getEmployeeId());
			cell = row.createCell(1);
			cell.setCellValue(employee.getEmployeeName());
			cell = row.createCell(2);
			cell.setCellValue(employee.getDateOfJoining());
			cell = row.createCell(3);
			cell.setCellValue(employee.getSalary());
		}
		
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(excelFilePath);
			workbook.write(fileOut);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			workbook.close();
			fileOut.close();
		}
	}
}
