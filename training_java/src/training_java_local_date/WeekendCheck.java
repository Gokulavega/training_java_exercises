package training_java_local_date;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekendCheck {

	public static void main(String[] args) {
		
	//	7.	Write a Java program to check whether a given LocalDate object falls on a weekend or not.
		
		LocalDate date = LocalDate.of(2023, 05, 07);
		
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		
		boolean isWeekend = dayOfWeek == dayOfWeek.SATURDAY || dayOfWeek == dayOfWeek.SUNDAY;
		
		System.out.println(date + " isWeekend " + isWeekend);
	}

}
