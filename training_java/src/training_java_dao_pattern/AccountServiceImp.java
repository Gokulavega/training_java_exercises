package training_java_dao_pattern;

import java.util.List;

public class AccountServiceImp implements AccountService {
	
	AccountDao dao = null;
	
	public AccountServiceImp() {
		this.dao = new AccountDaoImp();
	}

	@Override
	public List<Account> findAllAccount() {
		// TODO Auto-generated method stub
		return dao.getAllAccount();
	}

	@Override
	public List<Account> findAccountByname(String name) {
		// TODO Auto-generated method stub
		return dao.getAccountByname(name);
	}

	@Override
	public Account findAccount(String id) {
		// TODO Auto-generated method stub
		return dao.getAccount(id);
	}

	@Override
	public boolean createAccount(Account account) {
		// TODO Auto-generated method stub
		return dao.addAccount(account);
	}

	@Override
	public boolean removeAccount(Account account) {
		// TODO Auto-generated method stub
		return dao.deleteAccount(account);
	}

	@Override
	public Account editAccount(Account account) {
		// TODO Auto-generated method stub
		return dao.updateAccount(account);
	}

}
