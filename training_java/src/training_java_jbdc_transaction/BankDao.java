package training_java_jbdc_transaction;

import java.sql.Connection;

public interface BankDao {
	
	public void withdraw(Connection connection,Account fromAccount, Double amount) throws AccountNotFoundExecption, InsuficientBalanceExecption;
	public void deposit(Connection connection,Account toAccount, Double amount) throws AccountNotFoundExecption;
}
