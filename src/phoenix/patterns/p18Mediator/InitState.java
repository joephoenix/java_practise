package phoenix.patterns.p18Mediator;

public class InitState extends CardParterState {

	public InitState() {
		System.out.println("game is just begining now!");
	}

	@Override
	public void changeCount(int count) {
		return;
	}

}
