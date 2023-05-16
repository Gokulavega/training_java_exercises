package training_java_dao_pattern;

import java.util.List;

public interface BankService {
	
	List<Bank> findAllBank();
	Bank findBank(String id);
	List<Account> findAllAccount(String id);
	boolean createBank(Bank bank);
	boolean removeBank(Bank bank);
	Bank editBank(Bank bank);
	boolean LoadAccountToBank(String bankId,List<Account> account);
	int deposit(String bankId,String accountNumber,int balance);
	int withdraw(String bankId,String accountNumber,int balance);
}
