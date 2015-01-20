package phoenix.patterns.p09Decorator;

public class Sticker extends PhoneDecorator {

	public Sticker(Phone p) {
		super(p);
	}

	@Override
	public void print() {
		super.print();
		// add new operate
		addSticker();
	}

	public void addSticker() {
		System.out.println("The iphone had sticker paper now");
	}

}
