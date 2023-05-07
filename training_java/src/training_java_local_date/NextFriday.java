package training_java_local_date;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class NextFriday {

	public static void main(String[] args) {
		
	//	4.	Write a Java program to get the next Friday after a given LocalDate object.
		
		LocalDate date = LocalDate.of(2023, 05, 07);
		
		LocalDate nextFriday = date.with(DayOfWeek.FRIDAY).plusDays(7);
		
		System.out.println("nextFriday : " + nextFriday);
	}

}
