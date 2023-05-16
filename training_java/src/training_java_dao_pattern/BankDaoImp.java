package training_java_dao_pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankDaoImp implements BankDao {
	
	List<Bank> banks = new ArrayList<>();
	@Override
	public List<Bank> getAllBank() {
		// TODO Auto-generated method stub
		return banks;
	}

	@Override
	public Bank getBank(String id) throws BankNotFoundException {
		Bank bank = null;
		for(Bank bankList : banks) {
			if(bankList.getBankId().equalsIgnoreCase(id)) {
				bank = bankList;
				break;
			}
		}
		
		if(bank == null) {
			throw new BankNotFoundException();
		}
		return bank;
	}

	@Override
	public List<Account> getAccount(String id) {
		List<Account> accountList = null;
		for(Bank bank : banks) {
			if(bank.getBankId().equalsIgnoreCase(id)) {
				accountList = (List<Account>) bank.getAccount().values();
				break;
			}
		}
		return accountList;
	}

	@Override
	public boolean addBank(Bank bank) {
		// TODO Auto-generated method stub
		return banks.add(bank);
	}

	@Override
	public boolean deleteBank(Bank bank) {
		// TODO Auto-generated method stub
		return banks.remove(bank);
	}

	@Override
	public Bank updateBank(Bank bank) {
		Bank updateBank = null;
		for(Bank bankList : banks) {
			if(bankList.getBankId().equalsIgnoreCase(bank.getBankId())) {
				bankList.setAddress(bank.getAddress());
				bankList.setAccount(bank.getAccount());
				updateBank = bankList;
				break;
			}
		}
		return updateBank;
	}

	@Override
	public boolean assingAccountToBank(String bankId, List<Account> account) {
		boolean flag = false;
		Map<String,Account> accountList=new ConcurrentHashMap<>();
		for(Bank bankList : banks) {
			if(bankList.getBankId().equalsIgnoreCase(bankId)) {
				for(Account accounts : account) {
					accountList.put(accounts.getAccountNumber(), accounts);
				}
				bankList.setAccount(accountList);
				flag = true;
				break;
			}
		}
		return flag;
	}
	
}
