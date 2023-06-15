package com.Avega.Training.ServiceImp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Avega.Training.Dao.TrainingDao;
import com.Avega.Training.DaoImp.TrainingDaoImp;
import com.Avega.Training.Execption.TrainingNotFoundExecption;
import com.Avega.Training.Pojo.Training;
import com.Avega.Training.Service.TrainingService;

public class TrainingServiceImp implements TrainingService{
	
	static Logger logger = Logger.getLogger(TrainingServiceImp.class.getName());
	TrainingDao dao = null;

	public TrainingServiceImp() {
		this.dao = new TrainingDaoImp();
	}

	@Override
	public List<Training> findAllTraining() {
		// TODO Auto-generated method stub
		return dao.getAllTraining();
	}

	@Override
	public Training findTraining(String id) throws TrainingNotFoundExecption {
		// TODO Auto-generated method stub
		return dao.getTraining(id);
	}

	@Override
	public boolean createTraining(Training training) {
		// TODO Auto-generated method stub
		return dao.addTraining(training);
	}

	@Override
	public boolean removeTraining(String id) {
		// TODO Auto-generated method stub
		return dao.deleteTraining(id);
	}

	@Override
	public boolean editTraining(Training training) {
		// TODO Auto-generated method stub
		return dao.updateTraining(training);
	
	}

	@Override
	public void loadDBToExcel(Date date) throws IOException {
		List<Training> trainingList = dao.getAllTraining();
		
		Workbook workbook = new XSSFWorkbook();
		
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
		Cell celltraining_id = row.createCell(0);
		
		celltraining_id.setCellStyle(cellStyle);
		celltraining_id.setCellValue("training_id");
		
		Cell celldescription = row.createCell(1);
		celldescription.setCellStyle(cellStyle);
		celldescription.setCellValue("description");
		
		Cell cellDate = row.createCell(2);
		cellDate.setCellStyle(cellStyle);
		cellDate.setCellValue("start_date");
		
		Cell celldate1= row.createCell(3);
		celldate1.setCellStyle(cellStyle);
		celldate1.setCellValue("end_date");
		
		Cell cellrequestor= row.createCell(4);
		cellrequestor.setCellStyle(cellStyle);
		cellrequestor.setCellValue("requestor_id");
		
		Cell celltrainer= row.createCell(5);
		celltrainer.setCellStyle(cellStyle);
		celltrainer.setCellValue("trainer");
		
		Cell cellskill= row.createCell(6);
		cellskill.setCellStyle(cellStyle);
		cellskill.setCellValue("skill_id");
		
		//creating data cell
		
		int rowCount = 1;
		for (Training training : trainingList) {
			int month = training.getEnd_date().getMonth();
			if(month == date.getMonth()) {
				row = sheet.createRow(rowCount++);
				
				Cell cell = row.createCell(0);
				cell.setCellValue(training.getTraining_id());
				cell = row.createCell(1);
				cell.setCellValue(training.getDescription());
				cell = row.createCell(2);
				cell.setCellValue(training.getStart_date());
				cell = row.createCell(3);
				cell.setCellValue(training.getEnd_date());
				cell = row.createCell(4);
				cell.setCellValue(training.getRequestor_id());
				cell = row.createCell(5);
				cell.setCellValue(training.getTrainer());
				cell = row.createCell(6);
				cell.setCellValue(training.getSkill_id());
			}
			
		}
		
		for(int i = 0; i < row.getLastCellNum(); i++) {
			sheet.autoSizeColumn(i);
		}
		
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream("C:\\Users\\Gokul\\training.xlsx");
			workbook.write(fileOut);
			logger.info("Excel is generated");
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
