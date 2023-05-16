package training_java_dao_pattern;

import java.util.List;

public class BankServiceImp implements BankService{
	
	BankDao dao = null;
	
	public BankServiceImp() {
		this.dao = new BankDaoImp();
	}

	@Override
	public List<Bank> findAllBank() {
		// TODO Auto-generated method stub
		return dao.getAllBank();
	}

	@Override
	public Bank findBank(String id) {
		Bank bank = null;
		try {
			bank = dao.getBank(id);
		}
		catch (BankNotFoundException e) {
			e.printStackTrace();
		}
		return bank;
	}

	@Override
	public List<Account> findAllAccount(String id) {
		// TODO Auto-generated method stub
		return dao.getAccount(id);
	}

	@Override
	public boolean createBank(Bank bank) {
		// TODO Auto-generated method stub
		return dao.addBank(bank);
	}

	@Override
	public boolean removeBank(Bank bank) {
		// TODO Auto-generated method stub
		return dao.deleteBank(bank);
	}

	@Override
	public Bank editBank(Bank bank) {
		// TODO Auto-generated method stub
		return dao.updateBank(bank);
	}

	@Override
	public boolean LoadAccountToBank(String bankId, List<Account> account) {
		// TODO Auto-generated method stub
		return dao.assingAccountToBank(bankId, account);
	}

	@Override
	public int deposit(String bankId, String accountNumber, int balance) {
		int count = 0;
		Bank bank = findBank(bankId);
		Account account = bank.getAccount().get(accountNumber);
		if(account != null) {
			account.setBalance(account.getBalance() + balance);
			editBank(bank);
			count = account.getBalance();
		}
		return count;
	}

	@Override
	public int withdraw(String bankId,String accountNumber, int balance) {
		int count = 0;
		Bank bank = findBank(bankId);
		Account account = bank.getAccount().get(accountNumber);
		if(account != null) {
			if(account.getBalance() >= balance) {
			account.setBalance(account.getBalance() - balance);
			editBank(bank);
			count = account.getBalance();
			}
		}
		return count;
	}

}
