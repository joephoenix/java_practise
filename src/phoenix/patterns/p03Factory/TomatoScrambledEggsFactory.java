package phoenix.patterns.p03Factory;

public class TomatoScrambledEggsFactory extends Creator {

	@Override
	public Food createFoodFactory() {
		return new TomatoScrambledEggs();
	}

}
