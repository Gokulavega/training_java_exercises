package training_java_execl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

	public static void main(String[] args) throws IOException {
		
		try (Workbook workBook = new XSSFWorkbook()) {
			Sheet sheet = workBook.createSheet("Employee Data");
			
			Row headerRow = sheet.createRow(0);
			
			headerRow.createCell(0).setCellValue("Name");
			headerRow.createCell(1).setCellValue("Age");
			headerRow.createCell(2).setCellValue("Department");
			
			Employee employee = new Employee("john", 13, "industry");
			
			Row dataRow = sheet.createRow(1);
			
			dataRow.createCell(0).setCellValue(employee.getName());
			dataRow.createCell(1).setCellValue(employee.getAge());
			dataRow.createCell(2).setCellValue(employee.getDepartment());
			
			for(int i = 0; i < 3; i++) {
				sheet.autoSizeColumn(i);
			}
			
			String path = "C:\\Users\\Gokul\\employeeData.xlsx";
			
			try {
				FileOutputStream file = new FileOutputStream(path, true);
				try {
					workBook.write(file);
					System.out.println("execl is created");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String path = "C:\\\\Users\\\\Gokul\\\\employeeData.xlsx";
		
		try {
			FileInputStream file = new FileInputStream(path);
			
			Workbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheetAt(0);
			
			List<Employee> employees = new ArrayList<>();
			for(int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				
				if(row != null) {
					Employee employee = new Employee();
					
					employee.setName(row.getCell(0).getStringCellValue());
					employee.setAge((int) row.getCell(1).getNumericCellValue());
					employee.setDepartment(row.getCell(2).getStringCellValue());
					employees.add(employee);
				}
			}
			System.out.println("read");
			for (Employee employee : employees) {
				System.out.println(employee);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
