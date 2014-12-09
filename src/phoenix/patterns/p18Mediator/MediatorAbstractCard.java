package phoenix.patterns.p18Mediator;

public abstract class MediatorAbstractCard {

	public int MoneyCount;

	public MediatorAbstractCard() {
		MoneyCount = 0;
	}

	public abstract void changeCount(int count, MediatorAbstract ma);

}
