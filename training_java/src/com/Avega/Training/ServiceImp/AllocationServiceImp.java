package com.Avega.Training.ServiceImp;

import java.util.List;

import com.Avega.Training.Dao.AllocationDao;
import com.Avega.Training.DaoImp.AllocationDaoImp;
import com.Avega.Training.Pojo.Allocation;
import com.Avega.Training.Service.AllocationService;

public class AllocationServiceImp implements AllocationService{
	
	AllocationDao dao = null;

	public AllocationServiceImp() {
		this.dao = new AllocationDaoImp();
	}

	@Override
	public List<Allocation> findAllAllocation() {
		// TODO Auto-generated method stub
		return dao.getAllAllocation();
	}

	@Override
	public Allocation findAllocation(String id) {
		// TODO Auto-generated method stub
		return dao.getAllocation(id);
	}

	@Override
	public boolean createAllocation(Allocation allocation) {
		// TODO Auto-generated method stub
		return dao.addAllocation(allocation);
	}

	@Override
	public boolean removeAllocation(String id) {
		// TODO Auto-generated method stub
		return dao.deleteAllocation(id);
	}

	@Override
	public boolean editAllocation(Allocation allocation) {
		// TODO Auto-generated method stub
		return dao.updateAllocation(allocation);
	}
	
	
}
