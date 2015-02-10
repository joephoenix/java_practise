package phoenix.patterns.p03Factory;

public class TomatoScrambledEggs extends Food {

	@Override
	public void cook() {
		System.out.println("put the eggs into pan, then fried them");
		System.out.println("get the eggs which fried back");
		System.out.println("put the tomatoes into pan");
		System.out.println("put the fried eggs into "
				+ "pan then cook with tomatoes");
	}

}
