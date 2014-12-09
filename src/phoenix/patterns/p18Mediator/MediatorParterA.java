package phoenix.patterns.p18Mediator;

public class MediatorParterA extends MediatorAbstractCard {

	@Override
	public void changeCount(int count, MediatorAbstract ma) {
		ma.changeCount(count);
	}

}
