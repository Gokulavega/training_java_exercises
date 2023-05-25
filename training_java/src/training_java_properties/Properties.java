package training_java_properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Properties {

	public static void main(String[] args) {
		
		java.util.Properties pro = new java.util.Properties();
		
		try {
			pro.load(new FileInputStream("C:\\Users\\Gokul\\data.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(pro.getProperty("username"));
		System.out.println(pro.getProperty("password"));
		System.out.println(pro.getProperty("db_connection"));
	}

}
