package training_java_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class Stream_serializable {

	public static void main(String[] args) throws IOException {
		
		//Stream_serializable
		Book book = new Book("131313","vikram",13.0,LocalDate.of(2003, 06, 03));
		
		FileOutputStream fout = new FileOutputStream("C:\\Users\\Gokul\\serializable.txt");
		ObjectOutputStream obj = new ObjectOutputStream(fout);
		obj.writeObject(book);
		
		//Stream_deserializable
		ObjectInputStream objin = new ObjectInputStream(new FileInputStream("C:\\Users\\Gokul\\serializable.txt"));
		try {
			System.out.println(objin.readObject());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
