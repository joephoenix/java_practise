package phoenix.patterns.p03Factory;

public class ShreddedPorkWithPotatoesFactory extends Creator {

	@Override
	public Food createFoodFactory() {
		return new ShreddedPorkWithPotatoes();
	}

}
