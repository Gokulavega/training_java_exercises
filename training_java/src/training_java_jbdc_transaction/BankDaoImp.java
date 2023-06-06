package training_java_jbdc_transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankDaoImp implements BankDao{

	@Override
	public void withdraw(Connection connection, Account fromAccount, Double amount)
			throws AccountNotFoundExecption, InsuficientBalanceExecption {
		Account account = getCurrentAccountDetail(connection, fromAccount.getAccountNo());
		if(account != null) {
			if(account.getAccountBalance() < amount) {
				throw new InsuficientBalanceExecption("Insufficient funds");
			}
		}else {
			throw new AccountNotFoundExecption("account does not exist");
		}
		
		String sql = "UPDATE bank SET account_balance = ? WHERE account_no = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			Double updateBalance = account.getAccountBalance() - amount;
			
			ps.setDouble(1, updateBalance);
			ps.setLong(2, account.getAccountNo());
			
			int count = ps.executeUpdate();
			if(count > 0) {
				System.out.println("amount is debited");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deposit(Connection connection, Account toAccount, Double amount)
			throws AccountNotFoundExecption {
		
		Account account = getCurrentAccountDetail(connection, toAccount.getAccountNo());
		if(account == null) {
			throw new AccountNotFoundExecption("account does not exist");
		}
		
		String sql = "UPDATE bank SET account_balance = ? WHERE account_no = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			Double updateBalance = account.getAccountBalance() + amount;
			
			ps.setDouble(1, updateBalance);
			ps.setLong(2, account.getAccountNo());
			
			int count = ps.executeUpdate();
			
			if(count < 0) {
				System.out.println("amount is critided");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Account getCurrentAccountDetail(Connection connection, Long accountNo) {
		String sql = "SELECT * FROM bank WHERE account_no = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, accountNo);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Account dbAccount = new Account();
				dbAccount.setAccountNo(rs.getLong("account_no"));
				dbAccount.setAccountBalance(rs.getDouble("account_balance"));
				dbAccount.setAccountType(rs.getString("account_type"));
				dbAccount.setAccountHolderName(rs.getString("account_holder_name"));
				return dbAccount;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
