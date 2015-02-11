package phoenix.patterns.p02SimpleFactory;

public class MincedMeatEggplant extends Food {

	@Override
	public void cookFood() {
		System.out.println("Frying the minced Meat");
		System.out.println("Cut eggplants into small piece");
		System.out.println("Toast the minced Meat and eggplants together");
	}

}
