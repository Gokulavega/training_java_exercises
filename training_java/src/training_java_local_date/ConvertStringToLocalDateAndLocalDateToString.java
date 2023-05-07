package training_java_local_date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConvertStringToLocalDateAndLocalDateToString {

	public static void main(String[] args) {
		
	//	10.	Convert String to LocalDate  /LocalDate  to string.
		
		String dateString = "2023-05-07";
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate date1 = LocalDate.parse(dateString, formatter);
		
		System.out.println("date : " + date1);
		
		LocalDate date2 = LocalDate.of(2023, 05, 07);
		
		String stringDate = date2.format(formatter);
		
		System.out.println("stringDate : " + stringDate);
	}

}
