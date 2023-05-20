package training_java_stream;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Stream_io_read_and_write{

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("please enter the no of books : ");
		FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Gokul\\file.txt");
		int i = 0;
		String value = br.readLine();
		while (i< Integer.parseInt(value)) {
			Book book = new Book();
			System.out.println("please enter the book isbn number");
			book.setBookIsbn(br.readLine());
			System.out.println("please enter book name");
			book.setBookName(br.readLine());
			System.out.println("please enter price");
			double price = Double.parseDouble(br.readLine());
			book.setPrice(price);
			System.out.println("please enter the date");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String date = br.readLine();
			LocalDate dateMgf = LocalDate.parse(date, formatter);
			book.setDate(dateMgf);
			fileOut.write((book.toString() + "\n").getBytes());
			i++;
		}
		
		
		
		fileOut.close();
	}

}
