package phoenix.patterns.p09Decorator;

public class Accessories extends PhoneDecorator {

	public Accessories(Phone p) {
		super(p);
	}

	@Override
	public void print() {
		super.print();

		// add new operate
		addAccessories();
	}

	public void addAccessories() {
		System.out.println("The iphone had accessories now");
	}

}
