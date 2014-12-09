package phoenix.patterns.p19State;

public class RedState extends State {

	public RedState(State state) {
		this.balance = state.getBalance();
		this.account = state.getAccount();
		StateType rType = new StateType();
		rType.setName("Overdraft");
		rType.setInterest(0.00);
		rType.setLowerLimit(-100.00);
		rType.setUpperLimit(0.00);
		this.type = rType;
	}

	@Override
	public void deposit(double amount) {
		balance += amount;
		stateChangeCheck();

	}

	@Override
	public void withdraw(double amount) {
		System.out.println("no money can be withdrawed!");
	}

	@Override
	public void payInterest() {
		System.out.println("no interest cound be given");
	}

	private void stateChangeCheck() {
		if (balance > type.getLowerLimit()) {
			account.state = new SilverState(this);
		}
	}

}
