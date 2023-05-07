package training_java_local_date;

import java.time.Month;

public class CurrentLocalDate {

	public static void main(String[] args) {
		
	//	1.	Write a Java program to get the current date using LocalDate and print it.
		
		java.time.LocalDate current = java.time.LocalDate.now();
		
		System.out.println("current : " + current);
		
	//	2.	Write a Java program to get the year, month, and day of the current date using LocalDate.
		
		int year = current.getYear();
		Month month = current.getMonth();
		int day = current.getDayOfMonth();
		
		System.out.println("year : " + year);
		System.out.println("month : " + month);
		System.out.println("day : " + day);
	}

}
