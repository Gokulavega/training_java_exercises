package assiment_test_05_06_2023;

import java.util.List;

public interface UserLoginDao {
	List<UserLogin> getAllUser();
	boolean addUser(UserLogin userLogin);
	boolean deleteUser(String id);
	UserLogin updateUser(UserLogin userLogin);
}
