package training_java_dao_pattern;

public class BankNotFoundException extends Exception {
	
	public BankNotFoundException() {

	}

	public BankNotFoundException(String message) {
		super(message);
	}
}
