package training_java_collections_exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class MainQuestion1To10 {

	public static void main(String[] args) {
		
	//	1. Write a Java program to find the maximum element in a list of integers.
		List<Integer> number = new ArrayList<>();
		number.add(1);
		number.add(2);
		number.add(3);
		number.add(4);
		number.add(5);
		System.out.println("collections max value : " + Collections.max(number));
		
	//	2. Implement a Java program to sort a list of strings in ascending order.
		List < String > myList = new ArrayList < String > ();
	    myList.add("W");
	    myList.add("T");
	    myList.add("A");
	    myList.add("G");
	    myList.add("I");
	    myList.add("B");
	    myList.add("Z");
	    myList.add("0");
	    myList.add("U");
	    myList.add("7");

	    System.out.println("The unsorted List is:");

	    for (String myStr: myList) {
	      System.out.print(" " + myStr);
	    }
	    Collections.sort(myList);

	    System.out.println("\nThe Sorted List is");

	    for (String myStr: myList) {
	      System.out.print(" " + myStr);
	    }

	 //   3. Write a Java function to remove duplicate elements from a list of integers.
	    HashSet<Integer> output = new HashSet<>();
	    output.add(1);
	    output.add(1);
	    output.add(2);
	    output.add(3);
	    output.add(5);
	    
	    System.out.println(output);
	}

}
