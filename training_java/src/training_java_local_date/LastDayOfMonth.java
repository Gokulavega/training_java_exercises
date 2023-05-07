package training_java_local_date;

import java.time.LocalDate;

public class LastDayOfMonth {

	public static void main(String[] args) {
		
	//	6.	Write a Java program to get the date of the last day of the current month using LocalDate.
		
		LocalDate current = LocalDate.now();
		
		LocalDate lastDayOfMonth = LocalDate.of(current.getYear(), current.getMonth(), current.lengthOfMonth());
		
		System.out.println("lastDayOfMonth : " + lastDayOfMonth);
	}

}
