package phoenix.patterns.p18Mediator;

public class ParterBletWinState extends CardParterState {

	public ParterBletWinState(MediatorAbstract concretema) {
		this.ma = concretema;
	}

	@Override
	public void changeCount(int count) {
		for (MediatorAbstractCard mac : ma.malist) {
			if (mac instanceof MediatorParterB) {
				MediatorParterB mpb = (MediatorParterB) mac;
				mpb.MoneyCount += count;
				System.out.println("player B have " + mpb.MoneyCount
						+ " dollar now");
			} else {
				mac.MoneyCount -= count;
				System.out.println("player A have " + mac.MoneyCount
						+ " dollar now");
			}
		}
	}

}
