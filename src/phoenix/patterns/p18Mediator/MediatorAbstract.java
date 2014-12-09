package phoenix.patterns.p18Mediator;

import java.util.ArrayList;
import java.util.List;

public abstract class MediatorAbstract {

	public List<MediatorAbstractCard> malist = new ArrayList<MediatorAbstractCard>();

	public CardParterState cpstate;

	public MediatorAbstract(CardParterState cpstate) {
		this.cpstate = cpstate;
	}

	public void Enter(MediatorAbstractCard mac) {
		malist.add(mac);
	}

	public void Exit(MediatorAbstractCard mac) {
		malist.remove(mac);
	}

	public void changeCount(int count) {
		cpstate.changeCount(count);
	}
}
