package phoenix.patterns.p18Mediator;

public class ParterAlphaWinState extends CardParterState {

	public ParterAlphaWinState(MediatorAbstract concretema) {
		this.ma = concretema;
	}

	@Override
	public void changeCount(int count) {
		for (MediatorAbstractCard mac : ma.malist) {
			if (mac instanceof MediatorParterA) {
				MediatorParterA mpa = (MediatorParterA) mac;
				mpa.MoneyCount += count;
				System.out.println("player A have " + mpa.MoneyCount
						+ " dollar now");
			} else {
				mac.MoneyCount -= count;
				System.out.println("player B have " + mac.MoneyCount
						+ " dollar now");
			}
		}
	}

}
