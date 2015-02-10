package phoenix.patterns.p03Factory;

public class MincedMeatEggplant extends Food {

	@Override
	public void cook() {
		System.out.println("Frying the minced Meat");
		System.out.println("Cut eggplants into small piece");
		System.out.println("Toast the minced Meat and eggplants together");
	}

}
