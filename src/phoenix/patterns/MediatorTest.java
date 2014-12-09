package phoenix.patterns;

import phoenix.patterns.p18Mediator.AbstractCard;
import phoenix.patterns.p18Mediator.InitState;
import phoenix.patterns.p18Mediator.MediatorAbstract;
import phoenix.patterns.p18Mediator.MediatorAbstractCard;
import phoenix.patterns.p18Mediator.MediatorParter;
import phoenix.patterns.p18Mediator.MediatorParterA;
import phoenix.patterns.p18Mediator.MediatorParterB;
import phoenix.patterns.p18Mediator.ParterA;
import phoenix.patterns.p18Mediator.ParterAlphaWinState;
import phoenix.patterns.p18Mediator.ParterB;
import phoenix.patterns.p18Mediator.ParterBletWinState;

public class MediatorTest {

	public static void main(String[] args) {
		MediatorTest mt = new MediatorTest();
		// mt.NoUseMediator();
		mt.UseMediatorPattern();

	}

	public void UseMediatorPattern() {
		MediatorAbstractCard macA = new MediatorParterA();
		MediatorAbstractCard macB = new MediatorParterB();

		// 初始化起始资金
		macA.MoneyCount = 20;
		macB.MoneyCount = 20;

		// 声明中介者
		MediatorAbstract am = new MediatorParter(new InitState());

		// A,B玩家进入平台进行游戏
		am.Enter(macA);
		am.Enter(macB);

		// A赢了
		am.cpstate = new ParterAlphaWinState(am);
		am.changeCount(5);

		// B赢了
		am.cpstate = new ParterBletWinState(am);
		am.changeCount(7);
	}

	/**
	 * 未使用中介者模式的方法的测试
	 */
	public void NoUseMediator() {
		AbstractCard p1 = new ParterA();
		p1.MoneyCount = 20;
		AbstractCard p2 = new ParterB();
		p2.MoneyCount = 20;

		// A赢了钱，则B的钱减少了，A的钱增加了
		p1.changeCount(5, p2);

		// B赢了钱，A的钱也减少了
		p2.changeCount(12, p1);

	}

}
