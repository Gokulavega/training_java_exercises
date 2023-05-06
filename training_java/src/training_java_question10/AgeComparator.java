package training_java_question10;

import java.util.Comparator;

public class AgeComparator implements Comparator< Trainee> {

	@Override
	public int compare(Trainee o1, Trainee o2) {
		// TODO Auto-generated method stub
		return new Integer(o1.getAge()).compareTo(o2.getAge());
	}

}
