package training_java_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamExecrise1_15 {

	public static void main(String[] args) {
		
	//	1. Given a list of integers, find the sum of all the even numbers.
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int sum = numbers.parallelStream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
		System.out.println(sum);
		
	//	2. Given a list of strings, return a new list that contains only the strings that have a length greater than 5.
		
		List<String> originalList = Arrays.asList("apple", "Banana", "cherry", "date", "Orange");
		List<String> resultList = originalList.stream().filter(s -> s.length() >= 5).collect(Collectors.toList());
		System.out.println(resultList);
		
	//	3. Given a list of integers, return the maximum value.
		
		List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Optional<Integer> max = numbersList.stream().max(Integer::compareTo);
		System.out.println(max);
		
	//	4. Given a list of strings, return a new list that contains only the uppercase strings.
		
		List<String> list = Arrays.asList("apple", "Banana", "cherry", "date", "Orange");
		List<String> upper = list.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(upper);
		
	//	5. Given a list of strings, return a new list that contains only the strings that start with the letter "A".
		
		List<String> aList = Arrays.asList("dogs", "Animal", "bears", "elephants", "rhinos");
		List<String> aresultList = aList.stream().filter(s -> s.startsWith("A")).collect(Collectors.toList());
		System.out.println(aresultList);
		
	//	6. Given a list of integers, return a new list that contains only the even numbers and double each number.
		
		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> sum1 = numbers1.parallelStream().filter(n -> n % 2 == 0).map(n -> n * 2).collect(Collectors.toList());
		System.out.println(sum1);
		
	//	7. Given a list of strings, return a new list that contains the first letter of each string.
		
		List<String> aList1 = Arrays.asList("dogs", "1animal", "bears", "elephants", "rhinos");
		List<String> resultList1 = aList1.stream()
		        .filter(str -> str.matches("[a-z]+")).collect(Collectors.toList());
		System.out.println(resultList1);
		
	//	8. Given a list of integers, return a new list that contains only the numbers that are divisible by 3 and 5.
		
		List<Integer> number = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
		List<Integer> sumDiv = number.stream().filter(n -> n % 3 == 0 && n % 5 == 0).collect(Collectors.toList());
		System.out.println(sumDiv);
		
	//	9. Given a list of strings, return a new list that contains the length of each string.
		
		
		List<String> originalList1 = Arrays.asList("apple", "Banana", "cherry", "date", "Orange");
		int[] resultList11 = originalList1.stream().mapToInt(String::length).toArray();
		System.out.println(Arrays.toString(resultList11));
		
	//	10. Given a list of integers, return the sum of all the numbers that are greater than 10.
		
		List<Integer> num = Arrays.asList(1, 20, 30, 40, 50, 60, 70, 80, 90, 100);
		int sumGreater = num.stream().filter(n -> n > 10).mapToInt(Integer::intValue).sum();
		System.out.println(sumGreater);
		
	//	11. Given a list of strings, return a new list that contains only the strings that contain the letter "e".
		
		List<String> eList = Arrays.asList("dogs", "Animal", "bears", "elephants", "rhinos");
		List<String> eresultList = eList.stream().filter(s -> s.contains("e")).collect(Collectors.toList());
		System.out.println(eresultList);
		
	//	12. Given a list of integers, return a new list that contains the square of each number.
		
		List<Integer> square = Arrays.asList(4, 9, 16, 25);
		List<Double> resultsquare = square.stream().map(Math::sqrt).collect(Collectors.toList());
		System.out.println(resultsquare);
		
	//	13. Given a list of strings, return a new list that contains only the strings that are palindrome.
		
		List<String> inputList = Arrays.asList("racecar", "deified", "Java", "radar", "Kayak", "programming");
		List<String> result = inputList.stream()
		        .filter(str -> str.equalsIgnoreCase(new StringBuilder(str).reverse().toString()))
		        .collect(Collectors.toList());
		System.out.println(result);
		
	//	14. Given a list of integers, return the product of all the numbers.
		
		List<Integer> number1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> numPro = number1.stream().map(n -> n * n).collect(Collectors.toList());
		System.out.println(numPro);
		
	//	15. Given a list of strings, return a new list that contains only the strings that are anagrams of the word "listen".
		
		List<String> words = Arrays.asList("silent", "listen", "enlist", "inlets");
		List<String> anagrams = words.stream().filter(word -> Arrays.equals(word.chars().sorted().toArray() ,"listen".chars().sorted().toArray())).collect(Collectors.toList());
		System.out.println(anagrams);
	}

}
