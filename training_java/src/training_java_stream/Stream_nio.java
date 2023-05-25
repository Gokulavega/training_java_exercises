package training_java_stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Stream_nio {

	public static void main(String[] args) {
		
		Path source = Paths.get("C:\\Users\\Gokul\\file.txt");
		Path destination = Paths.get("C:\\Users\\Gokul\\copy\\file.txt");
		
		try {
			Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("successfully copied");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
