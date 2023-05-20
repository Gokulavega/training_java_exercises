package training_java_stream;

import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Stream_io_charArray {

	public static void main(String[] args) {
		
		CharArrayWriter cout = new CharArrayWriter();
		
		String str = "Example for char array writer";
		
		try {
			cout.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileWriter file = null;
		
		try {
			file = new FileWriter("C:\\Users\\Gokul\\file_writer.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileWriter file3 = null;
		
		try {
			file3 = new FileWriter("C:\\Users\\Gokul\\file_writer3.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			cout.writeTo(file);
			cout.writeTo(file3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				file.close();
				file3.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
