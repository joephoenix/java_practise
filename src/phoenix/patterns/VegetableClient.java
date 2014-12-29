package phoenix.patterns;

import phoenix.patterns.p14Template.ChineseVegetable;
import phoenix.patterns.p14Template.Eggplant;
import phoenix.patterns.p14Template.Spinach;

public class VegetableClient {

	public static void main(String[] args) {
		Spinach spinach = new Spinach();
		spinach.cookVegetable();

		ChineseVegetable cv = new ChineseVegetable();
		cv.cookVegetable();

		Eggplant eggplant = new Eggplant();
		eggplant.cookVegetable();
	}

}
