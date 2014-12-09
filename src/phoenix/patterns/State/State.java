package phoenix.patterns.State;

public abstract class State {

	// properties
	public Account account;
	public double balance;
	public StateType type;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public StateType getType() {
		return type;
	}

	public void setType(StateType type) {
		this.type = type;
	}

	// methods
	public abstract void deposit(double amount);

	public abstract void withdraw(double amount);

	public abstract void payInterest();

}
