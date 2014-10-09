package phoenix.collect;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

	public static void main(String[] args) {
		WhoFeedFish wff = new WhoFeedFish();
		Set<List<String>> colorGroup = wff.CreateColorGroup();
		Set<List<String>> petGroup = wff.CreatePetGroup();
		Set<List<String>> drinkGroup = wff.CreateDrinkGroup();
		Set<List<String>> smokeGroup = wff.CreateSmokeGroup();
		Set<List<String>> countryGroup = wff.CreateCountryGroup();

		// 按照第9个条件筛选国家的组合(挪威人住在第一间房屋里)
		Set<List<String>> cg9 = new HashSet<List<String>>();
		for (List<String> c : countryGroup) {
			if (c.get(0).equals("Norway")) {
				cg9.add(c);
			}
		}
		// 按照第8个中间人的喝牛奶的条件筛选饮料的组合(位于最中间的屋主喝牛奶)
		Set<List<String>> dg8 = new HashSet<List<String>>();
		for (List<String> d : drinkGroup) {
			if (d.get(2).equals("Milk")) {
				dg8.add(d);
			}
		}
		// 按照第14个条件筛选国家和颜色之间的组合（挪威人住在蓝色房子隔壁）
		// 由于挪威人固定住在第一间，所以第二间是蓝色
		Set<List<String>> clg14 = new HashSet<List<String>>();
		for (List<String> cl : colorGroup) {
			if (cl.get(1).equals("Blue")) {
				clg14.add(cl);
			}
		}
		// 按照第1个条件筛选国家和颜色的组合（英国人住在红色房屋里）
		// 按照第2个条件筛选国家和养宠物的组合（瑞典人养了一只狗）

		// 按照第13个条件筛选国家和抽烟之间的组合（德国人吸Prince香烟）
		// 按照第6个条件筛选香烟和宠物之间的组合（吸PallMall香烟的屋主养鸟）
		// 按照第7个条件筛选颜色和香烟之间的组合（黄色屋主吸Dunhill香烟）

		// 按照第5个条件筛选颜色和饮料之间的组合（绿色房屋的屋主喝咖啡）
		// 按照第12个条件筛选香烟和饮料之间的组合（吸BlueMaster香烟的屋主喝啤酒）
		// 按照第3个条件筛选国家和喝饮料的组合（丹麦人喝茶）
		Set<List<String>> dg02 = new HashSet<List<String>>();
		Set<List<String>> cg02 = new HashSet<List<String>>();
		Set<List<String>> clg02 = new HashSet<List<String>>();
		Set<List<String>> sg02 = new HashSet<List<String>>();
		Set<List<String>> pg02 = new HashSet<List<String>>();
		for (List<String> c : cg9) {
			for (List<String> p : petGroup) {
				for (int i = 0; i < 5; i++) {
					if (!p.get(i).equals("Dog")) {
						continue;
					} else if (!c.get(i).equals("Swiden")) {
						continue;
					} else {
						for (List<String> cl : clg14) {
							for (int j = 0; j < 5; j++) {
								if (!cl.get(j).equals("Red")) {
									continue;
								} else if (!c.get(j).equals("England")) {
									continue;
								} else {
									for (List<String> s : smokeGroup) {
										for (int k = 0; k < 5; k++) {
											if (!s.get(k).equals("Prince")) {
												continue;
											} else if (!c.get(k).equals(
													"Germay")) {
												continue;
											} else if (!s.get(k).equals(
													"PallMall")) {
												continue;
											} else if (!p.get(k).equals("Bird")) {
												continue;
											} else if (!s.get(k).equals(
													"Dunhill")) {
												continue;
											} else if (!cl.get(k).equals(
													"Yellow")) {
												continue;
											} else {
												for (List<String> d : drinkGroup) {
													for (int l = 0; l < 5; l++) {
														if (!d.get(l).equals(
																"Tea")) {
															continue;
														} else if (!c
																.get(l)
																.equals("Danish")) {
															continue;
														} else if (!d
																.get(l)
																.equals("Coffer")) {
															continue;
														} else if (!cl
																.get(l)
																.equals("Green")) {
															continue;
														} else if (!d.get(l)
																.equals("Beer")) {
															continue;
														} else if (!s
																.get(l)
																.equals("BlueMaster")) {
															continue;
														} else {
															dg02.add(d);
															sg02.add(s);
															cg02.add(c);
															clg02.add(cl);
															pg02.add(p);
															break;
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		System.out.println(dg02.size() + "---" + sg02.size() + "---"
				+ clg14.size() + "--" + pg02.size() + "---" + cg02.size());
		//
		for (List<String> p : pg02) {
			for (String pet : p) {
				System.out.print("[" + pet + "]" + " ");
			}
			System.out.print("\n\r");
		}
	}

	//
	protected String[] castToStringArray(Object array) {
		String[] ra = new String[5];
		List<String> ls = (List<String>) array;
		for (int i = 0; i < 5; i++) {
			ra[i] = String.valueOf(ls.get(i));
		}
		return ra;
	}

	// 组成条件的Set集合，颜色的排序，一共120种变化，5*4*3*2*1
	protected Set<List<String>> CreateColorGroup() {
		List<String> colorGroup = new ArrayList<String>();
		for (COLORS cl : COLORS.values()) {
			colorGroup.add(cl.toString());
		}
		return assimilateGroup(colorGroup, null);
	}

	// 组成条件的Set集合，宠物的排序，一共120种变化，5*4*3*2*1
	protected Set<List<String>> CreatePetGroup() {
		List<String> petGroup = new ArrayList<String>();
		for (PETS p : PETS.values()) {
			petGroup.add(p.toString());
		}
		return assimilateGroup(petGroup, null);
	}

	// 组成条件的Set集合，饮料的排序，一共120种变化，5*4*3*2*1
	protected Set<List<String>> CreateDrinkGroup() {
		List<String> drinkGroup = new ArrayList<String>();
		for (DRINKS d : DRINKS.values()) {
			drinkGroup.add(d.toString());
		}
		return assimilateGroup(drinkGroup, null);
	}

	// 组成条件的Set集合，抽烟的排序，一共120种变化，5*4*3*2*1
	protected Set<List<String>> CreateSmokeGroup() {
		List<String> smokeGroup = new ArrayList<String>();
		for (SMOKES s : SMOKES.values()) {
			smokeGroup.add(s.toString());
		}
		return assimilateGroup(smokeGroup, null);
	}

	// 组成条件的Set集合，抽烟的排序，一共120种变化，5*4*3*2*1
	protected Set<List<String>> CreateCountryGroup() {
		List<String> CountryGroup = new ArrayList<String>();
		for (COUNTRIES c : COUNTRIES.values()) {
			CountryGroup.add(c.toString());
		}
		return assimilateGroup(CountryGroup, null);
	}

	// 递归算法，计算一个数组的按顺序不同组合，每次组合都不相同
	protected Set<List<String>> assimilateGroup(List<String> input,
			List<String> fixed) {
		Set<List<String>> result = new HashSet<List<String>>();
		int n = input.size();
		if (n > 1) {
			for (int i = 0; i < n; i++) {
				// 读取本次添加的值，放置到固定的值中
				List<String> currentGroup = new ArrayList<String>();
				if (fixed == null) {
					String currentValue = input.get(i);
					currentGroup.add(currentValue);
				} else {
					currentGroup.addAll(fixed);
					String currentValue = input.get(i);
					currentGroup.add(currentValue);
				}
				// 为递归准备下次递归的数组
				List<String> nextGroup = new ArrayList<String>();
				nextGroup.addAll(input);
				nextGroup.remove(i);
				// 执行递归操作
				result.addAll(assimilateGroup(nextGroup, currentGroup));
			}
		} else {
			// 当数组长度为1时候，赋值结束递归
			List<String> currentGroup = new ArrayList<String>();
			currentGroup.addAll(fixed);
			String currentValue = input.get(0);
			currentGroup.add(currentValue);
			result.add(currentGroup);
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

}
