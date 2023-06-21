package com.Avega.Training.Comparator;

import java.util.Comparator;

import com.Avega.Training.Pojo.Allocation;

public class ScoreComparator implements Comparator<Allocation>{

	@Override
	public int compare(Allocation o1, Allocation o2) {
		// TODO Auto-generated method stub
		return new Integer(o1.getScore()).compareTo(o2.getScore());
	}

}
