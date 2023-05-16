package training_java_dao_pattern;

public class Main {

	public static void main(String[] args) {
		
		BankService bankService = new BankServiceImp();
		AccountService accountService = new AccountServiceImp();
		bankService.createBank(new Bank("sbi","1st a",null,"sbi001"));
		accountService.createAccount(new Account("1313131","ravi",10000));
		
		System.out.println(accountService.findAccount("1313131"));
		
		bankService.LoadAccountToBank("sbi001", accountService.findAllAccount());
		
		System.out.println(bankService.findBank("sbi001"));
		
		bankService.deposit("sbi001", "1313131", 13000);
		
		System.out.println(bankService.findBank("sbi001"));
		
		bankService.withdraw("sbi001", "1313131", 13000);
		
		System.out.println(bankService.findBank("sbi001"));
	}

}
