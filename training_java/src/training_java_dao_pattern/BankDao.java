package training_java_dao_pattern;

import java.util.List;

public interface BankDao {
	
	List<Bank> getAllBank();
	Bank getBank(String id) throws BankNotFoundException;
	List<Account> getAccount(String id);
	boolean addBank(Bank bank);
	boolean deleteBank(Bank bank);
	Bank updateBank(Bank bank);
	boolean assingAccountToBank(String bankId,List<Account> account);
}
