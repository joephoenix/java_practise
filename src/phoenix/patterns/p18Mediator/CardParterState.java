package phoenix.patterns.p18Mediator;

public abstract class CardParterState {
	protected MediatorAbstract ma;

	public abstract void changeCount(int count);
}
