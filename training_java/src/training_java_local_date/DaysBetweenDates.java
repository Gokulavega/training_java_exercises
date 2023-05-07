package training_java_local_date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DaysBetweenDates {

	public static void main(String[] args) {
		
	//	3.	Write a Java program to get the number of days between two LocalDate objects.
		
		LocalDate date1 = LocalDate.of(2022, 03, 13);
		LocalDate date2 = LocalDate.of(2023, 05, 17);
		
		long dateBetween = ChronoUnit.DAYS.between(date1, date2);
		
		System.out.println(date1 + " and " + date2 + " " + dateBetween);
	}

}
