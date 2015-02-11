package phoenix.patterns.p02SimpleFactory;

public class FoodSimpleFactory {
	public static Food cookingFoodInKitchen(String type) {
		Food food = null;
		switch (type) {
		case "土豆肉丝":
			food = new ShreddedPorkWithPotatoes();
			break;
		case "番茄炒蛋":
			food = new TomatoScrambledEggs();
			break;
		case "肉末茄子":
			food = new MincedMeatEggplant();
			break;
		default:
			food = new TomatoScrambledEggs();
			break;
		}
		return food;
	}
}
