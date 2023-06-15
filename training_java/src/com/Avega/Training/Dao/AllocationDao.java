package com.Avega.Training.Dao;

import java.util.List;

import com.Avega.Training.Pojo.Allocation;

public interface AllocationDao {
	
	List<Allocation> getAllAllocation();
	Allocation getAllocation(String id);
	boolean addAllocation(Allocation allocation);
	boolean deleteAllocation(String id);
	boolean updateAllocation(Allocation allocation);
}
