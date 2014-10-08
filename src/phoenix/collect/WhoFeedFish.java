package phoenix.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 一道逻辑题目的程序解法
 * 
 * 
 * @author chenxianxun
 *
 */
public class WhoFeedFish {
	private enum COLORS {
		Red, Green, White, Yellow, Blue
	}

	private enum PETS {
		Dog, Fish, Horse, Cat, Bird
	}

	private enum DRINKS {
		Coffer, Milk, Tea, Beer, Water
	}

	private enum SMOKES {
		Dunhill, Prince, PallMall, BlueMaster, Blend
	}

	private enum COUNTRIES {
		Germay, England, Norway, Danish, Swiden
	}

	protected List<String[]> CreateGroup(SMOKES smoke) {
		List<String[]> result = new ArrayList<String[]>();
		String[] group = new String[5];
		group[0] = SMOKES.values()[(new Random(5)).nextInt()].toString();
		group[1] = SMOKES.values()[(new Random(5)).nextInt()].toString();
		group[2] = SMOKES.values()[(new Random(5)).nextInt()].toString();
		group[3] = SMOKES.values()[(new Random(5)).nextInt()].toString();
		group[4] = SMOKES.values()[(new Random(5)).nextInt()].toString();
		//
		result.add(group);
		return result;
	}

	public static void main(String[] args) {
		String[][] aaa = new String[5][5];

	}
}
