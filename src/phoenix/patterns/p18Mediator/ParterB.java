package phoenix.patterns.p18Mediator;

public class ParterB extends AbstractCard {

	@Override
	public void changeCount(int count, AbstractCard ac) {
		this.MoneyCount += count;
		ac.MoneyCount -= count;
		System.out.println("player A have " + ac.MoneyCount + " dollar now");
		System.out.println("player B have " + MoneyCount + " dollar now");
	}

}
