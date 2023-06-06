package training_java_jbdc_transaction;

import java.sql.Connection;
import java.sql.SQLException;

public class Bank_Service_Imp implements Bank_Service{

	BankDao bankDao = new BankDaoImp();
	
	@Override
	public void fundTransfer(Account fromAccount, Account toAccount, Double amount)
			throws AccountNotFoundExecption, InsuficientBalanceExecption, SQLException {
		
		Connection connection = DbUtil.getConnected();
		
		
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		try {
			connection.setAutoCommit(false);
			
			bankDao.withdraw(connection, fromAccount, amount);
			bankDao.deposit(connection, toAccount, amount);
			
			connection.commit();
			}catch (Exception e) {
				if(connection != null) {
					connection.rollback();
				}
				System.out.println(e.getMessage());
			}finally {
				if(connection != null) {
					connection.close();
				}
			}
	}

}
