package phoenix.patterns;

import phoenix.patterns.p09Decorator.Accessories;
import phoenix.patterns.p09Decorator.ApplePhone;
import phoenix.patterns.p09Decorator.Phone;
import phoenix.patterns.p09Decorator.PhoneDecorator;
import phoenix.patterns.p09Decorator.Sticker;

public class DecoratorTest {

	public static void main(String[] args) {
		Phone iphone = new ApplePhone();

		// sticker to phone
		PhoneDecorator iphone_sticker = new Sticker(iphone);
		iphone_sticker.print();
		System.out.println("------------------------------");

		// add accessories
		PhoneDecorator iphone_access = new Accessories(iphone);
		iphone_access.print();
		System.out.println("------------------------------");

		Sticker iphone_one = new Sticker(iphone);
		Accessories iphone_all = new Accessories(iphone_one);
		iphone_all.print();
		System.out.println("------------------------------");
	}
}
