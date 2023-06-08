package assiment_test_05_06_2023;

public class Main {

	public static void main(String[] args) {
		
		UserLoginService user = new UserLoginServiceImp();
		
//		user.createUser(new UserLogin("001", "arun", "arun@1"));
//		user.createUser(new UserLogin("002", "naveen", "naveen@2"));
		
		System.out.println(user.findAllUser());
		
		System.out.println(user.checkUserNameAndPassword("arun", "arun@1"));
	}

}
