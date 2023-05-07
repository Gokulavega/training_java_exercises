package training_java_local_date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MonthsBetweenDays {

	public static void main(String[] args) {
		
	//	9.	Write a Java program to find the difference in months between two given LocalDate objects.
		
		LocalDate date1 = LocalDate.of(2022, 03, 13);
		LocalDate date2 = LocalDate.of(2023, 05, 17);
		
		long monthsBetween = ChronoUnit.MONTHS.between(date1.withDayOfMonth(1), date2.withDayOfMonth(1));
		
		System.out.println("months between : " + date1 + " and " + date2 + " is " + monthsBetween);
	}

}
