package phoenix.patterns.State;

public class GoldState extends State {

	public GoldState(State state) {
		this.balance = state.balance;
		this.account = state.account;
		StateType gType = new StateType();
		gType.setName("GoldRich");
		gType.setInterest(0.05);
		gType.setLowerLimit(1000.00);
		gType.setUpperLimit(1000000.00);
		this.type = gType;
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
		if (balance < 0.0) {
			account.state = new RedState(this);
		} else if (balance < type.getLowerLimit()) {
			account.state = new SilverState(this);
		}
	}

}
