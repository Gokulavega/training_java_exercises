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
	    
	 //   4. Implement a Java program to find the sum of all elements in a list of doubles.
	    
        List<Double> list = new ArrayList<>();
        list.add(13.0);
        list.add(13.5);
        list.add(22.0);
        list.add(17.5);
        double sum = 0.0;
        for (double num : list) {
            sum += num;
        }
        System.out.println("Sum of all elements in the list: " + sum);
        
    //    5. Write a Java program to find the index of a specific element in a list of strings.
        
        List<String> listElement = new ArrayList<>();
        listElement.add("apple");
        listElement.add("mango");
        listElement.add("orange");
        listElement.add("jackfruit");
        listElement.add("lemon");
        System.out.println("index of a specific element : " + listElement.indexOf("lemon"));
        
    //    6. Implement a Java program to reverse the order of elements in a list of integers.
        
        List<Integer> numberReverse = new ArrayList<>();
        numberReverse.add(1);
        numberReverse.add(2);
        numberReverse.add(3);
        numberReverse.add(4);
        numberReverse.add(5);
		Collections.reverse(numberReverse);
        System.out.println("reverse the order : " + numberReverse);
        
    //    7. Write a Java program to merge two sorted lists of integers into a single sorted list.
        
        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(10);
        list1.add(15);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(7);
        list2.add(12);
        List<Integer> mergedList = new ArrayList<>();
        mergedList.addAll(list1);
        mergedList.addAll(list2);
        
        Collections.sort(mergedList);
        
        System.out.println("merge list : " + mergedList);
        
    //    8. Implement a Java program to find the second largest element in a list of integers.
        
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        System.out.println(al);

        int j = Collections.max(al);

        System.out.println("Max in the array is " + j);
        al.remove(al.indexOf(j));
        int max2 = Collections.max(al);
        System.out.println(max2);
        
    //    9. Write a Java function to find the intersection of two lists of integers.
        
        List<Integer> list11 = new ArrayList<>();
        list11.add(5);
        list11.add(10);
        list11.add(15);
        List<Integer> list21 = new ArrayList<>();
        list21.add(10);
        list21.add(15);
        list21.add(20);
        List<Integer> intersection = new ArrayList<>(list11);
        intersection.retainAll(list21);
        System.out.println("Intersection of the two lists: " + intersection);
        
    //    10. Implement a Java program to remove all elements from a list that are divisible by a specific number.
        
        List<Integer> list111 = new ArrayList<>();
        list111.add(10);
        list111.add(5);
        list111.add(20);
        list111.add(15);
        int divisor = 2;
        list111.removeIf(num -> num % divisor == 0);
        System.out.println("elements from a list that are not divisible by the specific number : " + divisor + " : " + list111);
		



	}

}
