package phoenix.patterns.p18Mediator;

public abstract class AbstractCard {

	public int MoneyCount;

	public int getMoneyCount() {
		return MoneyCount;
	}

	public void setMoneyCount(int moneyCount) {
		MoneyCount = moneyCount;
	}

	public AbstractCard() {
		MoneyCount = 0;
	}

	public abstract void changeCount(int count, AbstractCard ac);

}
