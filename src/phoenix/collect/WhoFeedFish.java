package phoenix.collect;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
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

	protected static void removeObject(List<Integer> iList, Integer i) {
		int seq = 0;
		int length = iList.size();
		for (int j = 0; j < length; j++) {
			if (iList.get(j).equals(i)) {
				seq = j;
				break;
			}
		}
		iList.remove(seq);
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
		// 按照第4个条件，绿色的房子在白色的房子的左边
		// 所以第一间房子不是白色，最后一间房子不是绿色
		Set<List<String>> clg4 = new HashSet<List<String>>();
		for (List<String> cl : clg14) {
			if (!cl.get(0).equals("White") && !cl.get(4).equals("Green")) {
				clg4.add(cl);
			}
		}
		List<Integer> sequence = new ArrayList<Integer>();
		sequence.add(0);
		sequence.add(1);
		sequence.add(2);
		sequence.add(3);
		sequence.add(4);
		// 经过前几项的筛选，国家、颜色和饮料的候选项减少了许多，可以组合在一起筛选了
		// 按照第1个条件，英国人住在红色房屋里，组成颜色和国家的组合
		// 按照第5个条件筛选颜色和饮料之间的组合（绿色房屋的屋主喝咖啡）
		// 按照第3个条件筛选国家和喝饮料的组合（丹麦人喝茶）
		LinkedList<List<String>> clg01 = new LinkedList<List<String>>();
		LinkedList<List<String>> cg01 = new LinkedList<List<String>>();
		LinkedList<List<String>> dg01 = new LinkedList<List<String>>();
		for (List<String> cl : clg4) {
			for (List<String> c : cg9) {
				for (List<String> d : dg8) {
					for (int i : sequence) {
						if (d.get(i).equals("Tea") && c.get(i).equals("Danish")) {
							List<Integer> seqa = new ArrayList<Integer>();
							seqa.addAll(sequence);
							removeObject(seqa, i);
							for (int j : seqa) {
								if (d.get(j).equals("Coffer")
										&& cl.get(j).equals("Green")) {
									List<Integer> seqb = new ArrayList<Integer>();
									seqb.addAll(seqa);
									removeObject(seqb, j);
									for (int k : seqb) {
										if (c.get(k).equals("England")
												&& cl.get(k).equals("Red")) {
											clg01.add(cl);
											dg01.add(d);
											cg01.add(c);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		// 去除重复的内容
		Set<List<String>> colorSet01 = new HashSet<List<String>>();
		for (List<String> cla : clg01) {
			colorSet01.add(cla);
		}
		Set<List<String>> countrySet01 = new HashSet<List<String>>();
		for (List<String> ca : cg01) {
			countrySet01.add(ca);
		}
		Set<List<String>> drinkSet01 = new HashSet<List<String>>();
		for (List<String> da : dg01) {
			drinkSet01.add(da);
		}
		// ----------------------------------------------------------
		// 7,吸Dunhill香烟的是黄色屋主
		Set<List<String>> sg7 = new HashSet<List<String>>();
		Set<List<String>> clg7 = new HashSet<List<String>>();
		for (List<String> cla : colorSet01) {
			for (int i : sequence) {
				if (cla.get(i).equals("Yellow")) {
					for (List<String> sa : smokeGroup) {
						if (sa.get(i).equals("Dunhill")) {
							sg7.add(sa);
							clg7.add(cla);
						}
					}
				}
			}
		}
		// 13,吸Prince香烟是德国人
		Set<List<String>> sg13 = new HashSet<List<String>>();
		Set<List<String>> cg13 = new HashSet<List<String>>();
		for (List<String> ca : countrySet01) {
			for (int i : sequence) {
				if (ca.get(i).equals("Germay")) {
					for (List<String> sa : sg7) {
						if (sa.get(i).equals("Dunhill")) {
							sg13.add(sa);
							cg13.add(ca);
						}
					}
				}
			}
		}
		// 12,吸BlueMaster香烟的屋主喝啤酒
		// 15,只喝开水的人住在吸Blend香烟的人的隔壁
		LinkedList<List<String>> dg02 = new LinkedList<List<String>>();
		LinkedList<List<String>> sg02 = new LinkedList<List<String>>();
		for (List<String> sa : sg13) {
			for (List<String> da : drinkSet01) {
				for (Integer i : sequence) {
					if (da.get(i).equals("Water")) {
						if (i == 0) {
							String dd = sa.get(i + 1);
							if (dd.equals("Blend")) {
								List<Integer> seqa = new ArrayList<Integer>();
								seqa.addAll(sequence);
								removeObject(seqa, i);
								for (int j : seqa) {
									if (da.get(j).equals("Beer")
											&& sa.get(j).equals("BlueMaster")) {
										dg02.add(da);
										sg02.add(sa);
									}
								}
							}
						} else if (i == 4) {
							String dd = sa.get(i - 1);
							if (dd.equals("Blend")) {
								List<Integer> seqa = new ArrayList<Integer>();
								seqa.addAll(sequence);
								removeObject(seqa, i);
								for (int j : seqa) {
									if (da.get(j).equals("Beer")
											&& sa.get(j).equals("BlueMaster")) {
										dg02.add(da);
										sg02.add(sa);
									}
								}
							}
						} else {
							String dd1 = sa.get(i - 1);
							String dd2 = sa.get(i + 1);
							if (dd1.equals("Blend") || dd2.equals("Blend")) {
								List<Integer> seqa = new ArrayList<Integer>();
								seqa.addAll(sequence);
								removeObject(seqa, i);
								for (int j : seqa) {
									if (da.get(j).equals("Beer")
											&& sa.get(j).equals("BlueMaster")) {
										dg02.add(da);
										sg02.add(sa);
									}
								}
							}
						}
					}
				}
			}
		}
		Set<List<String>> drinkSet02 = new HashSet<List<String>>();
		for (List<String> da : dg02) {
			drinkSet02.add(da);
		}
		Set<List<String>> smokeSet02 = new HashSet<List<String>>();
		for (List<String> sa : sg02) {
			smokeSet02.add(sa);
		}
		Set<List<String>> colorSet02 = new HashSet<List<String>>();
		for (List<String> cla : clg7) {
			colorSet02.add(cla);
		}
		Set<List<String>> countrySet02 = new HashSet<List<String>>();
		for (List<String> ca : cg13) {
			countrySet02.add(ca);
		}
		// 2,瑞典人养了一只狗,
		// 6,吸PallMall香烟的屋主养鸟
		// 所以瑞典人不吸PallMall香烟, 德国人吸Prince香烟
		LinkedList<List<String>> cg03 = new LinkedList<List<String>>();
		LinkedList<List<String>> sg03 = new LinkedList<List<String>>();
		for (List<String> ca : countrySet02) {
			for (List<String> sa : smokeSet02) {
				for (Integer i : sequence) {
					if (ca.get(i).equals("Swiden")
							&& !sa.get(i).equals("PallMall")) {
						List<Integer> seqa = new ArrayList<Integer>();
						seqa.addAll(sequence);
						removeObject(seqa, i);
						for (int j : seqa) {
							if (ca.get(j).equals("Germay")
									&& sa.get(j).equals("Prince")) {
								cg03.add(ca);
								sg03.add(sa);
							}
						}
					}
				}
			}
		}
		// 去除重复,香烟和国家
		Set<List<String>> smokeSet03 = new HashSet<List<String>>();
		for (List<String> sa : sg03) {
			smokeSet03.add(sa);
		}
		Set<List<String>> countrySet03 = new HashSet<List<String>>();
		for (List<String> ca : cg03) {
			countrySet03.add(ca);
		}
		// 11,养马的屋主在吸Dunhill香烟的人家的隔壁
		// 10,养猫人家的在吸Blend香烟的人家的隔壁
		// 黄色屋主吸Dunhill香烟
		// 只喝开水的人住在吸Blend香烟的人的隔壁
		// 瑞典人不吸PallMall香烟, 德国人吸Prince香烟
		// 所以黄色屋主不养马， 德国人不养狗

		// ---------------------------------------------------------
		System.out.println("---国家:" + countrySet03.size() + "---饮料:"
				+ drinkSet02.size() + "---颜色:" + colorSet02.size() + "---香烟"
				+ smokeSet03.size());

		int n = colorSet02.size();
		for (int j = 0; j < n; j++) {
			List<String> ds = (List<String>) colorSet02.toArray()[j];
			// List<String> cs = (List<String>) sg03.toArray()[j];
			// List<String> cls = (List<String>) clg01.toArray()[j];
			// for (String cl : cls) {
			// System.out.print("[" + cl + "]" + " ");
			// }
			// System.out.print("\n\r");
			// for (String c : cs) {
			// System.out.print("[" + c + "]" + " ");
			// }
			// System.out.print("\n\r");
			for (String d : ds) {
				System.out.print("[" + d + "]" + " ");
			}
			System.out.print("\n\r");
			System.out.println("---------------------------");

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
