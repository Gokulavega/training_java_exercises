package training_java_dao_pattern;

import java.util.Map;

public class Bank {
	private String bankName;
	private String address;
	Map<String,Account> account;
	private String bankId;
	@Override
	public String toString() {
		return "Bank [bankName=" + bankName + ", address=" + address + ", account=" + account + ", bankId=" + bankId
				+ "]";
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Map<String, Account> getAccount() {
		return account;
	}
	public void setAccount(Map<String, Account> account) {
		this.account = account;
	}
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public Bank(String bankName, String address, Map<String, Account> account, String bankId) {
		super();
		this.bankName = bankName;
		this.address = address;
		this.account = account;
		this.bankId = bankId;
	}
	public Bank() {
		
	}
	
	
}
