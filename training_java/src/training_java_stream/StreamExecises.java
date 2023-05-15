package training_java_stream;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamExecises {

	public static void main(String[] args) throws IOException {
		
//	//	1. Creating a stream from a collection:
//		List<String> names = Arrays.asList("jhon","peter","jack");
//		
//		Stream<String> stream = names.stream();
//		
//		stream.forEach(s -> System.out.println(s));
//		
//	//	2. Creating a stream from an array:
//		
//		int[] numbers = {1,2,3,4,5};
//		IntStream stream1 = Arrays.stream(numbers);
//		stream1.forEach(s -> System.out.println(s));
//		
//	//	3. Creating a stream of random numbers:
//		
//		Random random = new Random();
//		Stream<Integer> ran = random.ints(10,0,100).boxed();
//		ran.forEach(s -> System.out.println(s));
//		
//	//	4. Creating an infinite stream:
//		
//		Stream<Integer> ini = Stream.iterate(0, n->n+1);
//	//	ini.forEach(s -> System.out.println(s));
//		
//	//	5. Creating a stream from a file:
//		
//		Path path = Paths.get("file txt");
//		Stream<String> file = Files.lines(path);
		
	//	1. Given a list of strings, return a new list that contains only the strings that have a length of 3.
		
		List<String> originalList = Arrays.asList("cat", "dog", "bird", "lion");
		List<String> resultList = originalList.stream().filter(s -> s.length() == 3).collect(Collectors.toList());
		System.out.println(resultList);
		
	//	2. Given a list of integers, return a new list that contains the absolute value of each number.
		
		List<Integer> intList = Arrays.asList(-3, 5, 0, -8, 4);
		List<Integer> resultList1 = intList.stream().map(Math::abs).collect(Collectors.toList());
		System.out.println(resultList1);
		
	//	3. Given a list of strings, return a new list that contains the strings in reverse order.

		List<String> oriList = Arrays.asList("apple", "banana", "cherry");
		List<String> revList = oriList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(revList);
				
	//	4. Given a list of integers, return a new list that contains only the prime numbers.
		List<Integer> original = Arrays.asList(2, 4, 5, 7, 9, 10, 11, 13);
		List<Integer> primeList = original.stream().filter(n -> IntStream.rangeClosed(2, (int) Math.sqrt(n))
                .allMatch(i -> n % i != 0))
				.collect(Collectors.toList());
		System.out.println(primeList);
		
	//	5. Given a list of strings, return a new list that contains the strings in uppercase and sorted in reverse order.
		
		List<String> oriList1 = Arrays.asList("apple", "Banana", "cherry", "date", "Orange");
		List<String> revList1 = oriList1.stream()
		                                      .map(String::toUpperCase)
		                                      .sorted(Collections.reverseOrder())
		                                      .collect(Collectors.toList());
		System.out.println(revList1);
		
	//	6. Given a list of integers, return a new list that contains the square root of each number.
				
		List<Integer> square = Arrays.asList(4, 9, 16, 25);
		List<Double> squareList = square.stream().map(Math::sqrt).collect(Collectors.toList());
		System.out.println(squareList);
		
	//	7. Given a list of strings, return a new list that contains only the strings that end with the letter "s".
		
		List<String> originals = Arrays.asList("dogs", "cats", "bears", "elephants", "rhinos");
		List<String> sList = originals.stream().filter(s -> s.endsWith("s")).collect(Collectors.toList());
		System.out.println(sList);
		
	//	8. Given a list of integers, return the average value.
		
		List<Integer> originalAverage = Arrays.asList(3, 4, 5, 6, 7);
		double average = originalAverage.stream().mapToInt(Integer::intValue).average().orElse(Double.NaN);
		System.out.println(average);
		
	//	9. Given a list of strings, return a new list that contains only the strings that are longer than their position in the list.
		
		List<String> inputList = Arrays.asList("Java", "is", "a", "programming", "language");
		List<String> resultLonger = IntStream.range(0, inputList.size())
		        .filter(i -> inputList.get(i).length() > i)
		        .mapToObj(inputList::get)
		        .collect(Collectors.toList());
		System.out.println(resultLonger);
		
	//	10. Given a list of integers, return a new list that contains only the numbers that are greater than their index in the list.
		
		List<Integer> inputList1 = Arrays.asList(5, 2, 7, 1, 8, 4);
		List<Integer> resultGreater = IntStream.range(0, inputList1.size())
		        .filter(i -> inputList1.get(i) > i)
		        .mapToObj(inputList1::get)
		        .collect(Collectors.toList());
		System.out.println(resultGreater);
		
	//	11. Given a list of strings, return a new list that contains the concatenation of all the strings.
		
		List<String> input = Arrays.asList("Java", "is", "a", "programming", "language");
		String resultString = input.stream().reduce("", String::concat);
		System.out.println(resultString);
		
	//	12. Given a list of integers, return a new list that contains the difference between each adjacent pair of numbers.
		
		List<Integer> inputint = Arrays.asList(5, 2, 7, 1, 8, 4);
		List<Integer> resultAdjacent = IntStream.range(0, inputint.size() - 1)
		        .map(i -> inputint.get(i + 1) - inputint.get(i))
		        .boxed()
		        .collect(Collectors.toList());
		System.out.println(resultAdjacent);
		
	//	13. Given a list of strings, return a new list that contains only the strings that are composed entirely of uppercase letters.
		
		List<String> input1 = Arrays.asList("JAVA", "is", "a", "PROGRAMMING", "language");
		List<String> result1 = input1.stream()
		        .filter(str -> str.matches("[A-Z]+"))
		        .collect(Collectors.toList());
		System.out.println(result1);
		
	//	14. Given a list of strings, return a new list that contains only the strings that are palindromes and have an odd length.
		
		List<String> in = Arrays.asList("racecar", "deified", "Java", "radar", "Kayak", "programming");
		List<String> resultin = in.stream()
				        .filter(str -> str.length() % 2 != 0 && str.equalsIgnoreCase(new StringBuilder(str).reverse().toString()))
				        .collect(Collectors.toList());
		System.out.println(resultin);
	}

}
