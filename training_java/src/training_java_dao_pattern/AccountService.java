package training_java_dao_pattern;

import java.util.List;

public interface AccountService {
	
	List<Account> findAllAccount();
	List<Account> findAccountByname(String name);
	Account findAccount(String id);
	boolean createAccount(Account account);
	boolean removeAccount(Account account);
	Account editAccount(Account account);
}
