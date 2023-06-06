package training_java_jbdc_transaction;

import java.sql.SQLException;

public interface Bank_Service {
	
	public void fundTransfer(Account fromAccount, Account toAccount, Double amount) throws AccountNotFoundExecption, InsuficientBalanceExecption, SQLException;
}
