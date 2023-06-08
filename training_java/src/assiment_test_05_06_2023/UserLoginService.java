package assiment_test_05_06_2023;

import java.util.List;

public interface UserLoginService {
	
	List<UserLogin> findAllUser();
	boolean createUser(UserLogin userLogin);
	boolean removeUser(String id);
	UserLogin editUser(UserLogin userLogin);
	boolean checkUserNameAndPassword(String userName, String password);
}
