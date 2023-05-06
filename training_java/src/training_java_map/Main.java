package training_java_map;

public class Main {

	public static void main(String[] args) {
		
		EmployeeInerface emp = new EmployeeServiceImp();
		
		emp.addEmployee(new Employee(13,"simbu",10000,"full stack"));
		emp.addEmployee(new Employee(15,"jai",10000,"developer"));
		emp.addEmployee(new Employee(17,"jeva",10000,"react developer"));
		
		System.out.println(emp.getEmployeeByName("jeva"));
		System.out.println(emp.updateEmployee(new Employee(13,"manmadan",10000,"full stack")));
		System.out.println(emp.getEmployee());
	}

}
