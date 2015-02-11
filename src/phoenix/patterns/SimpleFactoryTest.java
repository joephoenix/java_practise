package phoenix.patterns;

import phoenix.patterns.p02SimpleFactory.Food;
import phoenix.patterns.p02SimpleFactory.FoodSimpleFactory;

public class SimpleFactoryTest {

	public static void main(String[] args) {
		Food f1 = FoodSimpleFactory.cookingFoodInKitchen("番茄炒蛋");
		f1.cookFood();

		System.out.println("****===========================****");
		System.out.println("Cooking the second food");
		System.out.println("****===========================****");

		Food f2 = FoodSimpleFactory.cookingFoodInKitchen("土豆肉丝");
		f2.cookFood();

		System.out.println("****===========================****");
		System.out.println("Cooking the third food");
		System.out.println("****===========================****");

		Food f3 = FoodSimpleFactory.cookingFoodInKitchen("肉末茄子");
		f3.cookFood();
	}
}
