package training_java_collections;

import java.util.ArrayList;
import java.util.Arrays;

public class InterfaceDemoImpl implements InterfaceDemo {

	@Override
	public void display(String symbol) {
		
		String str = "Paragraphs are medium-sized units of writing, longer than sentences, but shorter than sections, chapters, or entire works";
        str = str.toLowerCase();
        String s = null;
        String vow ="aeiou";
        ArrayList<Character> vowels = new ArrayList<Character>();
        for(int i=0;i<vow.length();i++)
        {
            vowels.add(vow.charAt(i));
        }
        
        for (int i = 0; i < str.length(); i++) {
            s = str.replaceAll("[aeiou]", symbol);
        }
        
        System.out.println(s);
	}

	@Override
	public void change(String zero, String one, String five) {
		
		String str = "Paragraphs are medium-sized units of writing, longer than sentences, but shorter than sections, chapters, or entire works";
        str = str.toLowerCase();
        String r = null;
        String vow ="aeiou";
        ArrayList<Character> vowels = new ArrayList<Character>();
        for(int i=0;i<vow.length();i++)
        {
            vowels.add(vow.charAt(i));
        }
        
        for (int i = 0; i < str.length(); i++) {
            r = str.replace("o", zero).replace("g", one).replace("s", five);
        }
        
        System.out.println(r);
	}

	@Override
	public void count() {
		
		String str = "Paragraphs are medium-sized units of writing, longer than sentences, but shorter than sections, chapters, or entire works";
        str = str.toLowerCase();
        int count = 0;
        String vow ="aeiou";
        ArrayList<Character> vowels = new ArrayList<Character>();
        for(int i=0;i<vow.length();i++)
        {
            vowels.add(vow.charAt(i));
        }
        
        for (int i = 0; i < str.length(); i++) {
            if(vowels.contains(str.charAt(i))){
                count++;
            }
        }
        
        System.out.println("Total no of vowels in string are: " + count);
	}

	@Override
	public void arr(int[] arr) {
		
		int count = 0;
		int number = 0;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i] == arr[j]) {
					number = arr[i];
					count++;
				}
			}
		}
		
		if(count % 2 != 0)
			System.out.println(number + " is odd");
	}

	@Override
	public void displayNumber(String num) {
		
		String[] digits = num.split("");
		  int[] intArr = new int[digits.length];
		  for (int i = 0; i < digits.length; i++) {
		        intArr[i] = Integer.parseInt(digits[i]);
		    }
		  
		  for (int i = 0; i < intArr.length; i++)
		  {
			  int res = 0;
			  res = res + (intArr[i] * intArr[i]);
			  System.out.print(res);
		  }
	}

	@Override
	public void printPermutn(String str, String ans) {
		
		if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
 
        for (int i = 0; i < str.length(); i++) {
 
            char ch = str.charAt(i);
 
            String ros = str.substring(0, i) +
                        str.substring(i + 1);
 
            printPermutn(ros, ans + ch);
        }
	}

	@Override
	public void digitsRoot(int n) {
		
		int root = 0;
		
        while (n > 0 || root > 9)
        {
             if (n == 0) {
                n = root;
                root = 0;
            }
             
            root += n % 10;
            n /= 10;
        }
        
        System.out.println(root);
	}

	@Override
	public void arrays(int[] a, int[] b) {
		
		int [] number = new int[a.length];
		int count = 0;
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < b.length; j++) {
				if(a[i] != b[j]) {
					number[count ++] = a[i];
				}
			}
		}
		System.out.println(Arrays.toString(number));
	}

	@Override
	public void number(String numbers) {
		
		String[] array = numbers.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=0; i< array.length; i++){
            int value = Integer.parseInt(array[i]);
            if (value < min) min = value;
            if (value > max) max = value;
        }
        
        System.out.println(min);
        System.out.println(max);
	}

	@Override
	public void removeElements(int[] array, int key) {
		
		int index = 0;
		for (int i=0; i<array.length; i++)
            if (array[i] != key)
                array[index++] = array[i];
		
		System.out.println(Arrays.toString(array));
	}

}
