package training_java_collections;

public class Main {

	public static void main(String[] args) {
		
		InterfaceDemo demo = new InterfaceDemoImpl();
		
		demo.display("!");
		
		demo.change("0", "1", "5");
		
		demo.count();
		
		int []arr = {0,1,0,1,0};
		
		demo.arr(arr);
		
		demo.displayNumber("9119");
		
		demo.printPermutn("abb", " ");
		
		demo.digitsRoot(19283113);
		
		int []a = {1,2,3,2,4,2,1};
		
		int []b = {2};
		
		demo.arrays(a, b);
		
		demo.number("1 2 3 4 5");
	}

}
