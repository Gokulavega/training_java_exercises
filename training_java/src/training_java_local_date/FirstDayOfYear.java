package training_java_local_date;

import java.time.LocalDate;

public class FirstDayOfYear {

	public static void main(String[] args) {
		
	//	5.	Write a Java program to get the date of the first day of the current year using LocalDate.
		
		LocalDate current = LocalDate.now();
		
		LocalDate firstDayOfYear = LocalDate.of(current.getYear(), 01, 01);
		
		System.out.println("firstDayOfYear : " + firstDayOfYear);
	}

}
