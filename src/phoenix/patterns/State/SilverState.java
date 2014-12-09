package phoenix.patterns.State;

public class SilverState extends State {

	public SilverState(double balance, Account account) {
		this.balance = balance;
		this.account = account;
		StateType sType = new StateType();
		sType.setName("NormalCumstomer");
		sType.setInterest(0.0);
		sType.setLowerLimit(0.00);
		sType.setUpperLimit(1000.00);
		this.type = sType;
	}

	public SilverState(State state) {
		this.balance = state.balance;
		this.account = state.account;
		StateType sType = new StateType();
		sType.setName("NormalCumstomer");
		sType.setInterest(0.0);
		sType.setLowerLimit(0.00);
		sType.setUpperLimit(1000.00);
		this.type = sType;
	}

	@Override
	public void deposit(double amount) {
		balance += amount;
		stateChangeCheck();
	}

	@Override
	public void withdraw(double amount) {
		balance -= amount;
		stateChangeCheck();
	}

	@Override
	public void payInterest() {
		balance += type.getInterest() * balance;
		stateChangeCheck();
	}

	private void stateChangeCheck() {
		if (balance < type.getLowerLimit()) {
			account.state = new RedState(this);
		} else {
			account.state = new GoldState(this);
		}
	}

}
