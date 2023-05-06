package training_java_question10;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		
		Trainee [] batch1 = {
				new Trainee(131513,"kumar",9032158713l,"kumar@kumtest.com","male",13),
				new Trainee(131514,"kum",8032158713l,"kumar@kumtest.com","male",16),
				new Trainee(131515,"kumari",7032158713l,"kumar@kumtest.com","female",17)
		};
		
		Trainee [] batch2 = {
				new Trainee(131516,"simbu",6032158713l,"simbu@kumtest.com","male",27),
				new Trainee(131517,"kumba",5032158713l,"kumar@kumtest.com","female",33),
				new Trainee(131518,"ravi",4032158713l,"kumar@kumtest.com","male",83)
		};
		
		Batch batch = new Batch(LocalDate.of(2023, 03, 13), LocalDate.of(2023, 05, 17), batch1);
		Batch batchs = new Batch(LocalDate.of(2023, 03, 15), LocalDate.of(2023, 05, 23), batch2);
		
		System.out.println(batch.getTrainee(131513));
		for (Trainee trainee : batchs.getTrainee("male")) {
			if(trainee != null)
			System.out.println(trainee);
		}
		
		TreeSet<Trainee> set = new TreeSet<Trainee>(new AgeComparator());
		set.addAll(Arrays.asList(batch1));
		set.addAll(Arrays.asList(batch2));
		System.out.println(set);

	}

}
