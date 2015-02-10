package phoenix.patterns;

import phoenix.patterns.p03Factory.Creator;
import phoenix.patterns.p03Factory.Food;
import phoenix.patterns.p03Factory.MincedMeatEggplantFactory;
import phoenix.patterns.p03Factory.ShreddedPorkWithPotatoesFactory;
import phoenix.patterns.p03Factory.TomatoScrambledEggsFactory;

public class NormalFactoryTest {

	public static void main(String[] args) {
		Creator spwpf = new ShreddedPorkWithPotatoesFactory();
		Creator tsef = new TomatoScrambledEggsFactory();
		Creator mmef = new MincedMeatEggplantFactory();

		Food tse = tsef.createFoodFactory();
		tse.cook();

		System.out.println();
		System.out.println("***==============================***");
		System.out.println();

		Food spwp = spwpf.createFoodFactory();
		spwp.cook();

		System.out.println();
		System.out.println("***==============================***");
		System.out.println();

		Food mme = mmef.createFoodFactory();
		mme.cook();
	}

}
