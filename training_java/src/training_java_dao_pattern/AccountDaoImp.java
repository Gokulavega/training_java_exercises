package training_java_dao_pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class AccountDaoImp implements AccountDao {
	
	ConcurrentHashMap<String, Account> accounts = new ConcurrentHashMap<>();
	
	
	@Override
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		return new ArrayList(accounts.values());
	}

	@Override
	public List<Account> getAccountByname(String name) {
		List<Account> accountList = new ArrayList<>();
		for(Account account : accounts.values()) {
			if(account.getAccountName().equalsIgnoreCase(name)) {
				accountList.add(account);
			}
		}
		return accountList;
	}

	@Override
	public Account getAccount(String id) {
		// TODO Auto-generated method stub
		return accounts.get(id);
	}

	@Override
	public boolean addAccount(Account account) {
		boolean flag = false;
		accounts.put(account.getAccountNumber(), account);
		if(accounts.get(account.getAccountNumber()) != null) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteAccount(Account account) {
		boolean flag = false;
		accounts.remove(account.getAccountNumber(), account);
		if(accounts.get(account.getAccountNumber()) == null) {
			flag = true;
		}
		return flag;
	}

	@Override
	public Account updateAccount(Account account) {
		
		Account updateAccount = accounts.get(account.getAccountNumber());
		updateAccount.setAccountName(account.getAccountName());
		updateAccount.setBalance(account.getBalance());
		accounts.put(account.getAccountNumber(), updateAccount);
		
		return accounts.get(account.getAccountNumber());
	}

}
