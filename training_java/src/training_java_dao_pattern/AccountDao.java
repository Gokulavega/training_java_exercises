package training_java_dao_pattern;

import java.util.List;

public interface AccountDao {
	
	List<Account> getAllAccount();
	List<Account> getAccountByname(String name);
	Account getAccount(String id);
	boolean addAccount(Account account);
	boolean deleteAccount(Account account);
	Account updateAccount(Account account);
}
