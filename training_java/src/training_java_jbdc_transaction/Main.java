package training_java_jbdc_transaction;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		Bank_Service bankService = new Bank_Service_Imp();
		
		Double transferAmount = 1000.00;
		Account fromAccount = new Account();
		fromAccount.setAccountNo(1314200L);
		
		Account toAccount = new Account();
		toAccount.setAccountNo(1314201L);
		
		try {
			bankService.fundTransfer(fromAccount, toAccount, transferAmount);
		} catch (SQLException | AccountNotFoundExecption | InsuficientBalanceExecption e) {
			System.out.println(e.getMessage());
		}
	}

}
