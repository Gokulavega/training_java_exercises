package training_java_question7;

public class Main {

	public static void main(String[] args) {
		
		Employee[] management = {
				new Employee(131313,"karthic",10000,"manager"),
				new Employee(131314,"simbu",100000,"manager"),
				new Employee(131315,"kamal",1000000,"manager"),
		};
		
		Employee[] it = {
				new Employee(131316,"kar",11000,"fullstack"),
				new Employee(131317,"sim",120000,"devops"),
				new Employee(131318,"kam",1300000,"devops"),
		};
		
		Employee[] testor = {
				new Employee(131513,"test",10000,"testor"),
				new Employee(131515,"test1",10000,"testor")
		};
		
		Department [] dep = {
				new Department(01,"managament",management),
				new Department(02,"it",it),
				new Department(03,"it",testor)
		};
		
		Company avega = new Company("avega",dep);
		
		for(Employee emp : avega.getEmployeesByDept(02)) {
			System.out.println(emp);
		}
		
		for(Employee emp : avega.getEmployeesByDesignation("devops")) {
			if(emp != null)
				System.out.println(emp);
		}
		
		for(Employee emp : avega.getEmployeesBySalary(10000)) {
			if(emp != null)
				System.out.println(emp);
		}

	}

}
