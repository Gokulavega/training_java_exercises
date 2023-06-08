package assiment_test_05_06_2023;

import java.util.List;

public class UserLoginServiceImp implements UserLoginService{
	
	UserLoginDao dao = null;
	public UserLoginServiceImp() {
		this.dao = new UserloginDaoImp();
	}

	@Override
	public List<UserLogin> findAllUser() {
		// TODO Auto-generated method stub
		return dao.getAllUser();
	}

	@Override
	public boolean createUser(UserLogin userLogin) {
		// TODO Auto-generated method stub
		return dao.addUser(userLogin);
	}

	@Override
	public boolean removeUser(String id) {
		// TODO Auto-generated method stub
		return dao.deleteUser(id);
	}

	@Override
	public UserLogin editUser(UserLogin userLogin) {
		// TODO Auto-generated method stub
		return dao.updateUser(userLogin);
	}

	@Override
	public boolean checkUserNameAndPassword(String userName, String password) {
		
		boolean isUser = false;
		List<UserLogin> users = findAllUser();
		for(UserLogin user : users) {
			if(user.getUserName().equalsIgnoreCase(userName)) {
				if(user.getPassword().contentEquals(password))
					isUser = true;
				else
					isUser = false;
			}
		}
		return isUser;
	}

}
