package com.Avega.Training.Dao;

import java.util.List;

import com.Avega.Training.Execption.TrainingNotFoundExecption;
import com.Avega.Training.Pojo.Training;

public interface TrainingDao {
	
	List<Training> getAllTraining();
	Training getTraining(String id) throws TrainingNotFoundExecption;
	boolean addTraining(Training training);
	boolean deleteTraining(String id);
	boolean updateTraining(Training training);
}
