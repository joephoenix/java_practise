package phoenix.patterns.p03Factory;

public class MincedMeatEggplantFactory extends Creator {

	@Override
	public Food createFoodFactory() {
		return new MincedMeatEggplant();
	}

}
