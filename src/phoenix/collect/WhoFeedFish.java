package phoenix.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 
 * 逻辑判断题目，按照条件推论出谁养鱼，
 * 
 * 详见说明文档WhoFeedFish.html
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

	// 组成条件list，抽烟的排序，一共120种变化，5*4*3*2*1
	protected List<String[]> CreateGroup() {
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

	protected List<List<String>> assimilateGroup(List<String> input) {
		List<List<String>> result = new ArrayList<List<String>>();
		for (int i = 0; i < 5; i++) {
			List<String> group = new ArrayList<String>();
			String color1 = input.get(i);
			group.add(color1);
			List<String> inm1 = input;
			inm1.remove(i);
			for (int j = 0; j < 4; j++) {
				String color2 = inm1.get(j);
				group.add(color2);
				List<String> inm2 = inm1;
				inm2.remove(j);
				for (int k = 0; k < 3; k++) {
					String color3 = inm2.get(k);
					group.add(color3);
					List<String> inm3 = inm2;
					inm3.remove(k);
					for (int l = 0; l < 2; l++) {
						String color4 = inm3.get(l);
						group.add(color4);
						List<String> inm4 = inm3;
						inm4.remove(l);
						for (int m = 0; m < 1; m++) {
							String color5 = inm4.get(m);
							group.add(color5);
						}
					}
				}
			}
			result.add(group);
		}
		return result;
	}

	// 求阶乘的结果
	protected int factorial(int n) {
		if (n < 0 || n > 16) {
			System.err.println("n must be great than 0 and less than 17");
			return -1;
		} else if (n == 0) {
			return 1;
		} else {
			int result = 1;
			for (int i = 1; i <= n; i++) {
				result *= i;
			}
			return result;
		}
	}

	public static void main(String[] args) {
		String[][] aaa = new String[5][5];

	}
}
