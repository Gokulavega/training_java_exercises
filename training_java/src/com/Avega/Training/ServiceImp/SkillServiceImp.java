package com.Avega.Training.ServiceImp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Avega.Training.Dao.SkillDao;
import com.Avega.Training.DaoImp.SkillDaoImp;
import com.Avega.Training.Execption.SkillNotFoundExecption;
import com.Avega.Training.Pojo.Skill;
import com.Avega.Training.Service.SkillService;

public class SkillServiceImp implements SkillService{
	
	static Logger logger = Logger.getLogger(SkillServiceImp.class.getName());
	
	SkillDao dao = null;
	
	public SkillServiceImp() {
		this.dao = new SkillDaoImp();
	}

	@Override
	public List<Skill> findAllSkill() {
		// TODO Auto-generated method stub
		return dao.getAllSkill();
	}

	@Override
	public Skill findSkill(String id) throws SkillNotFoundExecption {
		// TODO Auto-generated method stub
		return dao.getSkill(id);
	}

	@Override
	public boolean createSkill(Skill skill) {
		// TODO Auto-generated method stub
		return dao.addSkill(skill);
	}

	@Override
	public boolean removeSkill(String id) {
		// TODO Auto-generated method stub
		return dao.deleteSkill(id);
	}

	@Override
	public boolean editSkill(Skill skill) {
		// TODO Auto-generated method stub
		return dao.updateSkill(skill);
	}
	
	@Override
	public List<Skill> loadExcelToDB(String excelFilePath) {
		List<Skill> skills = new ArrayList<>();

		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File(excelFilePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("No of sheets" + workbook.getNumberOfSheets());

		Sheet sheet = workbook.getSheetAt(0);

		Iterator<Row> iterator = sheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			Skill skill = new Skill();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				int columnIndex = cell.getColumnIndex();
				if (columnIndex == 0)
					skill.setSkill_id(cell.getStringCellValue());
				skill.setDescription(cell.getStringCellValue());
			}
			dao.addSkill(skill);
			skills.add(skill);

		}
		try {
			workbook.close();
			inputStream.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return skills;
	}
	
	
}
