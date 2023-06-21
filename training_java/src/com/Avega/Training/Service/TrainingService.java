package com.Avega.Training.Service;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.Avega.Training.Execption.TrainingNotFoundExecption;
import com.Avega.Training.Pojo.Training;

public interface TrainingService {
	
	List<Training> findAllTraining();
	Training findTraining(String id) throws TrainingNotFoundExecption;
	boolean createTraining(Training training);
	boolean removeTraining(String id);
	boolean editTraining(Training training);
	public void loadDBToExcel(Date date) throws IOException;
	public void findTrainingOfThisMonth(Date date);
}
