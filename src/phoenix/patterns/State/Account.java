package phoenix.patterns.State;

public class Account {
	public State state;
	public String owner;
	// 余额
	public double balance;

	public Account(String owner) {
		this.owner = owner;
		this.state = new SilverState(0.00, this);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getBalance() {
		return state.balance;
	}

	// 存钱
	public void deposit(double amount) {
		state.deposit(amount);
		System.out.println("存款金额为:" + amount);
		System.out.println("账户余额为：" + getBalance());
		System.out.println("账户状态为：" + this.state.getType().getName());
	}

	// 取钱
	public void withdraw(double amount) {
		state.withdraw(amount);
		System.out.println("取款金额为:" + amount);
		System.out.println("账户余额为：" + getBalance());
		System.out.println("账户状态为：" + this.state.getType().getName());
	}

	// 利息
	public void payInterest() {
		state.payInterest();
		System.out.println("账户余额为：" + getBalance());
		System.out.println("账户状态为：" + this.state.getType().getName());
	}
}
