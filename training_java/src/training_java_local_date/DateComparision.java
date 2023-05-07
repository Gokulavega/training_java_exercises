package training_java_local_date;

import java.time.LocalDate;

public class DateComparision {

	public static void main(String[] args) {
		
	//	8.	Write a Java program to check whether a given LocalDate object is before or after another given LocalDate object.
		
		LocalDate date1 = LocalDate.of(2022, 03, 13);
		LocalDate date2 = LocalDate.of(2023, 05, 17);
		
		if(date1.isBefore(date2))
			System.out.println(date1 + " is before " + date2);
		else
			System.out.println(date1 + " is after " + date2);
	}

}
