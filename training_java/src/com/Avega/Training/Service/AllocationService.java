package com.Avega.Training.Service;

import java.util.List;

import com.Avega.Training.Pojo.Allocation;

public interface AllocationService {
	
	List<Allocation> findAllAllocation();
	Allocation findAllocation(String id);
	boolean createAllocation(Allocation allocation);
	boolean removeAllocation(String id);
	boolean editAllocation(Allocation allocation);
}
