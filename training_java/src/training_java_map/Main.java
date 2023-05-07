package training_java_map;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		
		EmployeeInerface emp = new EmployeeServiceImp();
		
		emp.addEmployee(new Employee(13,"simbu",10000,"full stack"));
		emp.addEmployee(new Employee(15,"jai",10000,"developer"));
		emp.addEmployee(new Employee(17,"jeva",10000,"react developer"));
		
		System.out.println(emp.getEmployeeByName("jeva"));
		System.out.println(emp.updateEmployee(new Employee(13,"manmadan",10000,"full stack")));
		System.out.println(emp.getEmployee());
		
		ProductInterface pro = new ProductServiceImp();
		
		pro.addProduct(new Product(13,"jim jam",10,"biscut",LocalDate.of(2023, 03, 13),LocalDate.of(2023, 05, 17),1));
		pro.addProduct(new Product(17,"hide and seek",30,"biscut",LocalDate.of(2023, 02, 19),LocalDate.of(2023, 05, 21),2));
		pro.addProduct(new Product(20,"milk biscute",25,"biscut",LocalDate.of(2023, 05, 27),LocalDate.of(2023, 07, 29),3));
		
		System.out.println(pro.getProductByName("milk biscute"));
		System.out.println(pro.getProductById(13));
		System.out.println(pro.getExpireDate());
		System.out.println(pro.getManufacturingDate());
	}

}
