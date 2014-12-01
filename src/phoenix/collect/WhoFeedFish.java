package phoenix.collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public static void main(String args[]) {
		WhoFeedFish wff = new WhoFeedFish();
		// colors
		List<String> colors = wff.arrayToList(new String[] { "Blue", "Yellow",
				"Red", "Green", "White" });
		List<List<String>> clrlt = wff.comboItems(colors);
		List<List<String>> after14 = wff.forteenCondition(clrlt);
		List<List<String>> after4 = wff.forthCondition(after14);
		// wff.printArray(after4);
		// contries
		List<String> contries = wff.arrayToList(new String[] { "England",
				"Norway", "Danish", "Germay", "Swiden" });
		List<List<String>> ctrlt = wff.comboItems(contries);
		List<List<String>> after9 = wff.nightCondition(ctrlt);
		// wff.printArray(after9);
		// drinks
		List<String> drinks = wff.arrayToList(new String[] { "Water", "Beer",
				"Milk", "Tea", "Coffee" });
		List<List<String>> drrlt = wff.comboItems(drinks);
		List<List<String>> after8 = wff.eighthCondition(drrlt);
		// wff.printArray(after8);
		// smokes
		List<String> smokes = wff.arrayToList(new String[] { "PallMall",
				"Dunhill", "Blend", "BlueMaster", "Prince" });
		List<List<String>> smrlt = wff.comboItems(smokes);
		// pets
		List<String> pettes = wff.arrayToList(new String[] { "Dog", "Fish",
				"Horse", "Bird", "Cat" });
		List<List<String>> ptrlt = wff.comboItems(pettes);

		/*------------------------开始混合判断---------------------------*/
		// 第一部分，排列一个国家的组合列，不重合，然后判断宠物、红色、饮料，香烟是否符合要求，需要同时生效
		// 第1，2，3，13个判断
		// 第二部分，对上面的结果再次筛选，如第5，6，7，12的判断；
		// 第三部分，在对结果进行筛选判断，使用第10，11，15的判断

		// 第一个判断
		Map<String, List<List<String>>> after1 = wff.firstCondition(after9,
				after4);
		// wff.printArray(after1.get("contry"));
		// wff.printArray(after1.get("colors"));
		// 第二个判断
		Map<String, List<List<String>>> after2 = wff.secondCondition(
				after1.get("contry"), ptrlt);
		// wff.printArray(after2.get("contry"));
		// wff.printArray(after2.get("pettes"));
		Map<String, List<List<String>>> after3 = wff.thirdCondition(
				after2.get("contry"), after8);
		// wff.printArray(after3.get("contry"));
		// wff.printArray(after3.get("drinks"));
		Map<String, List<List<String>>> after5 = wff.fifthCondition(
				after1.get("colors"), after3.get("drinks"));
		// wff.printArray(after5.get("colors"));
		// wff.printArray(after5.get("drinks"));
		Map<String, List<List<String>>> after7 = wff.seventhCondition(
				after5.get("colors"), smrlt);
		// wff.printArray(after7.get("colors"));
		// wff.printArray(after7.get("smokes"));
		Map<String, List<List<String>>> after13 = wff.thirdteenCondition(
				after3.get("contry"), after7.get("smokes"));
		// wff.printArray(after13.get("contry"));
		// wff.printArray(after13.get("smokes"));
		Map<String, List<List<String>>> after12 = wff.twelfthCondition(
				after13.get("smokes"), after5.get("drinks"));
		// wff.printArray(after12.get("smokes"));
		// wff.printArray(after12.get("drinks"));
		Map<String, List<List<String>>> after15 = wff.fifteenthCondition(
				after12.get("smokes"), after12.get("drinks"));
		// wff.printArray(after15.get("smokes"));
		// wff.printArray(after15.get("drinks"));
		Map<String, List<List<String>>> after6 = wff.sixthCondition(
				after15.get("smokes"), after2.get("pettes"));
		// wff.printArray(after6.get("smokes"));
		// wff.printArray(after6.get("pettes"));
		Map<String, List<List<String>>> after10 = wff.tenthCondition(
				after6.get("smokes"), after6.get("pettes"));
		// wff.printArray(after10.get("smokes"));
		// wff.printArray(after10.get("pettes"));
		Map<String, List<List<String>>> after11 = wff.eleventhCondition(
				after10.get("smokes"), after10.get("pettes"));
		wff.printArray(after11.get("smokes"));
		wff.printArray(after11.get("pettes"));
	}

	/**
	 * 第一个判断，英国人住在红色房屋里，比较两个组合
	 * 
	 * @param arrays1
	 *            国家的List
	 * @param arrays2
	 *            颜色的List
	 * @return
	 */
	protected Map<String, List<List<String>>> firstCondition(
			List<List<String>> arrays1, List<List<String>> arrays2) {
		Map<String, List<List<String>>> rlt = new HashMap<String, List<List<String>>>();
		List<List<String>> selets1 = new ArrayList<List<String>>();
		List<List<String>> selets2 = new ArrayList<List<String>>();
		for (List<String> items1 : arrays1) {
			for (List<String> items2 : arrays2) {
				for (int i = 0; i < 5; i++) {
					if (items1.get(i) == "England" && items2.get(i) == "Red") {
						if (!selets1.contains(items1)) {
							selets1.add(items1);
						}
						if (!selets2.contains(items2)) {
							selets2.add(items2);
						}
					}
				}
			}
		}
		rlt.put("contry", selets1);
		rlt.put("colors", selets2);
		return rlt;
	}

	/**
	 * 第二个判断，瑞典人养了一只狗
	 * 
	 * @param arrays1
	 *            国家的组合列表
	 * @param arrays2
	 *            宠物的组合列表
	 * @return
	 */
	protected Map<String, List<List<String>>> secondCondition(
			List<List<String>> arrays1, List<List<String>> arrays2) {
		Map<String, List<List<String>>> rlt = new HashMap<String, List<List<String>>>();
		List<List<String>> selets1 = new ArrayList<List<String>>();
		List<List<String>> selets2 = new ArrayList<List<String>>();
		for (List<String> items1 : arrays1) {
			for (List<String> items2 : arrays2) {
				for (int i = 0; i < 5; i++) {
					if (items1.get(i) == "Swiden" && items2.get(i) == "Dog") {
						if (!selets1.contains(items1)) {
							selets1.add(items1);
						}
						if (!selets2.contains(items2)) {
							selets2.add(items2);
						}
					}
				}
			}
		}
		rlt.put("contry", selets1);
		rlt.put("pettes", selets2);
		return rlt;
	}

	/**
	 * 第三个判断，丹麦人喝茶
	 * 
	 * @param arrays1
	 *            国家的组合列表
	 * @param arrays2
	 *            饮料的组合列表
	 * @return
	 */
	protected Map<String, List<List<String>>> thirdCondition(
			List<List<String>> arrays1, List<List<String>> arrays2) {
		Map<String, List<List<String>>> rlt = new HashMap<String, List<List<String>>>();
		List<List<String>> selets1 = new ArrayList<List<String>>();
		List<List<String>> selets2 = new ArrayList<List<String>>();
		for (List<String> items1 : arrays1) {
			for (List<String> items2 : arrays2) {
				for (int i = 0; i < 5; i++) {
					if (items1.get(i) == "Danish" && items2.get(i) == "Tea") {
						if (!selets1.contains(items1)) {
							selets1.add(items1);
						}
						if (!selets2.contains(items2)) {
							selets2.add(items2);
						}
					}
				}
			}
		}
		rlt.put("contry", selets1);
		rlt.put("drinks", selets2);
		return rlt;
	}

	/**
	 * 第四个判断，绿色的房子在白色的房子的左边，绿色房子的序号比白色房子小
	 * 
	 * @param arrays
	 * @return
	 */
	protected List<List<String>> forthCondition(List<List<String>> arrays) {
		List<List<String>> rlt = new ArrayList<List<String>>();
		for (List<String> items : arrays) {
			int greenOrder = 0;
			int whiteOrder = 0;
			int Order = 0;
			for (String item : items) {
				Order++;
				if (item == "Green") {
					greenOrder = Order;
				}
				if (item == "White") {
					whiteOrder = Order;
				}
			}
			if (greenOrder < whiteOrder) {
				rlt.add(items);
			}
		}
		return rlt;
	}

	/**
	 * 第五个判断，绿色房屋的屋主喝咖啡
	 * 
	 * @param arrays1
	 *            颜色的组合列表
	 * @param arrays2
	 *            饮料的组合列表
	 * @return
	 */
	protected Map<String, List<List<String>>> fifthCondition(
			List<List<String>> arrays1, List<List<String>> arrays2) {
		Map<String, List<List<String>>> rlt = new HashMap<String, List<List<String>>>();
		List<List<String>> selets1 = new ArrayList<List<String>>();
		List<List<String>> selets2 = new ArrayList<List<String>>();
		for (List<String> items1 : arrays1) {
			for (List<String> items2 : arrays2) {
				for (int i = 0; i < 5; i++) {
					if (items1.get(i) == "Green" && items2.get(i) == "Coffee") {
						if (!selets1.contains(items1)) {
							selets1.add(items1);
						}
						if (!selets2.contains(items2)) {
							selets2.add(items2);
						}
					}
				}
			}
		}
		rlt.put("colors", selets1);
		rlt.put("drinks", selets2);
		return rlt;
	}

	/**
	 * 第六个判断，吸PallMall香烟的屋主养鸟
	 * 
	 * @param arrays1
	 *            香烟的组合列表
	 * @param arrays2
	 *            宠物的组合列表
	 * @return
	 */
	protected Map<String, List<List<String>>> sixthCondition(
			List<List<String>> arrays1, List<List<String>> arrays2) {
		Map<String, List<List<String>>> rlt = new HashMap<String, List<List<String>>>();
		List<List<String>> selets1 = new ArrayList<List<String>>();
		List<List<String>> selets2 = new ArrayList<List<String>>();
		for (List<String> items1 : arrays1) {
			for (List<String> items2 : arrays2) {
				for (int i = 0; i < 5; i++) {
					if (items1.get(i) == "PallMall" && items2.get(i) == "Bird") {
						if (!selets1.contains(items1)) {
							selets1.add(items1);
						}
						if (!selets2.contains(items2)) {
							selets2.add(items2);
						}
					}
				}
			}
		}
		rlt.put("smokes", selets1);
		rlt.put("pettes", selets2);
		return rlt;
	}

	/**
	 * 第7个判断，黄色屋主吸Dunhill香烟
	 * 
	 * @param arrays1
	 *            颜色的组合列表
	 * @param arrays2
	 *            香烟的组合列表
	 * @return
	 */
	protected Map<String, List<List<String>>> seventhCondition(
			List<List<String>> arrays1, List<List<String>> arrays2) {
		Map<String, List<List<String>>> rlt = new HashMap<String, List<List<String>>>();
		List<List<String>> selets1 = new ArrayList<List<String>>();
		List<List<String>> selets2 = new ArrayList<List<String>>();
		for (List<String> items1 : arrays1) {
			for (List<String> items2 : arrays2) {
				for (int i = 0; i < 5; i++) {
					if (items1.get(i) == "Yellow" && items2.get(i) == "Dunhill") {
						if (!selets1.contains(items1)) {
							selets1.add(items1);
						}
						if (!selets2.contains(items2)) {
							selets2.add(items2);
						}
					}
				}
			}
		}
		rlt.put("colors", selets1);
		rlt.put("smokes", selets2);
		return rlt;
	}

	/**
	 * 第八个判断，位于最中间的屋主喝牛奶
	 * 
	 * @param arrays
	 * @return
	 */
	protected List<List<String>> eighthCondition(List<List<String>> arrays) {
		List<List<String>> rlt = new ArrayList<List<String>>();
		for (List<String> items : arrays) {
			if (items.get(2) == "Milk") {
				rlt.add(items);
			}
		}
		return rlt;
	}

	/**
	 * 第九个判断，挪威人住在第一间房子
	 * 
	 * @param arrays
	 * @return
	 */
	protected List<List<String>> nightCondition(List<List<String>> arrays) {
		List<List<String>> rlt = new ArrayList<List<String>>();
		for (List<String> items : arrays) {
			if (items.get(0) == "Norway") {
				rlt.add(items);
			}
		}
		return rlt;
	}

	/**
	 * 第10个判断，吸Blend香烟的人住在养猫人家的隔壁
	 * 
	 * @param arrays1
	 *            香烟的组合列表
	 * @param arrays2
	 *            宠物的组合列表
	 * @return
	 */
	protected Map<String, List<List<String>>> tenthCondition(
			List<List<String>> arrays1, List<List<String>> arrays2) {
		Map<String, List<List<String>>> rlt = new HashMap<String, List<List<String>>>();
		List<List<String>> selets1 = new ArrayList<List<String>>();
		List<List<String>> selets2 = new ArrayList<List<String>>();
		for (List<String> items1 : arrays1) {
			for (List<String> items2 : arrays2) {
				if (nextJudgement(items1, "Blend", items2, "Cat")) {
					if (!selets1.contains(items1)) {
						selets1.add(items1);
					}
					if (!selets2.contains(items2)) {
						selets2.add(items2);
					}
				}
			}
		}
		rlt.put("smokes", selets1);
		rlt.put("pettes", selets2);
		return rlt;
	}

	/**
	 * 第11个判断，养马的屋主在吸Dunhill香烟的人家的隔壁
	 * 
	 * @param arrays1
	 *            香烟的组合列表
	 * @param arrays2
	 *            宠物的组合列表
	 * @return
	 */
	protected Map<String, List<List<String>>> eleventhCondition(
			List<List<String>> arrays1, List<List<String>> arrays2) {
		Map<String, List<List<String>>> rlt = new HashMap<String, List<List<String>>>();
		List<List<String>> selets1 = new ArrayList<List<String>>();
		List<List<String>> selets2 = new ArrayList<List<String>>();
		for (List<String> items1 : arrays1) {
			for (List<String> items2 : arrays2) {
				if (nextJudgement(items1, "Dunhill", items2, "Horse")) {
					if (!selets1.contains(items1)) {
						selets1.add(items1);
					}
					if (!selets2.contains(items2)) {
						selets2.add(items2);
					}
				}
			}
		}
		rlt.put("smokes", selets1);
		rlt.put("pettes", selets2);
		return rlt;
	}

	/**
	 * 第12个判断，吸BlueMaster香烟的屋主喝啤酒
	 * 
	 * @param arrays1
	 *            香烟的组合列表
	 * @param arrays2
	 *            饮料的组合列表
	 * @return
	 */
	protected Map<String, List<List<String>>> twelfthCondition(
			List<List<String>> arrays1, List<List<String>> arrays2) {
		Map<String, List<List<String>>> rlt = new HashMap<String, List<List<String>>>();
		List<List<String>> selets1 = new ArrayList<List<String>>();
		List<List<String>> selets2 = new ArrayList<List<String>>();
		for (List<String> items1 : arrays1) {
			for (List<String> items2 : arrays2) {
				for (int i = 0; i < 5; i++) {
					if (items1.get(i) == "BlueMaster"
							&& items2.get(i) == "Beer") {
						if (!selets1.contains(items1)) {
							selets1.add(items1);
						}
						if (!selets2.contains(items2)) {
							selets2.add(items2);
						}
					}
				}
			}
		}
		rlt.put("smokes", selets1);
		rlt.put("drinks", selets2);
		return rlt;
	}

	/**
	 * 第13个判断，德国人吸Prince香烟
	 * 
	 * @param arrays1
	 *            国家的组合列表
	 * @param arrays2
	 *            香烟的组合列表
	 * @return
	 */
	protected Map<String, List<List<String>>> thirdteenCondition(
			List<List<String>> arrays1, List<List<String>> arrays2) {
		Map<String, List<List<String>>> rlt = new HashMap<String, List<List<String>>>();
		List<List<String>> selets1 = new ArrayList<List<String>>();
		List<List<String>> selets2 = new ArrayList<List<String>>();
		for (List<String> items1 : arrays1) {
			for (List<String> items2 : arrays2) {
				for (int i = 0; i < 5; i++) {
					if (items1.get(i) == "Germay" && items2.get(i) == "Prince") {
						if (!selets1.contains(items1)) {
							selets1.add(items1);
						}
						if (!selets2.contains(items2)) {
							selets2.add(items2);
						}
					}
				}
			}
		}
		rlt.put("contry", selets1);
		rlt.put("smokes", selets2);
		return rlt;
	}

	/**
	 * 第14个判断，挪威人住在蓝色房屋隔壁，也就是第二间是蓝色。
	 * 
	 * @param arrays
	 * @return
	 */
	protected List<List<String>> forteenCondition(List<List<String>> arrays) {
		List<List<String>> rlt = new ArrayList<List<String>>();
		for (List<String> items : arrays) {
			if (items.get(1) == "Blue") {
				rlt.add(items);
			}
		}
		return rlt;
	}

	/**
	 * 第15个判断，只喝开水的人住在吸Blend香烟的人的隔壁
	 * 
	 * @param arrays1
	 *            香烟的组合列表
	 * @param arrays2
	 *            饮料的组合列表
	 * @return
	 */
	protected Map<String, List<List<String>>> fifteenthCondition(
			List<List<String>> arrays1, List<List<String>> arrays2) {
		Map<String, List<List<String>>> rlt = new HashMap<String, List<List<String>>>();
		List<List<String>> selets1 = new ArrayList<List<String>>();
		List<List<String>> selets2 = new ArrayList<List<String>>();
		for (List<String> items1 : arrays1) {
			for (List<String> items2 : arrays2) {
				if (nextJudgement(items1, "Blend", items2, "Water")) {
					if (!selets1.contains(items1)) {
						selets1.add(items1);
					}
					if (!selets2.contains(items2)) {
						selets2.add(items2);
					}
				}
			}
		}
		rlt.put("smokes", selets1);
		rlt.put("drinks", selets2);
		return rlt;
	}

	/**
	 * 相邻判断公用方法
	 * 
	 * @param items1
	 *            第一个组合
	 * @param con1
	 *            第一组合的条件
	 * @param items2
	 *            第二个组合
	 * @param con2
	 *            第二组合的条件
	 * @return
	 */
	protected boolean nextJudgement(List<String> items1, String con1,
			List<String> items2, String con2) {
		boolean answer = false;
		for (int i = 0; i < 5; i++) {
			if (i == 0) {
				if (items1.get(i) == con1 && items2.get(i + 1) == con2) {
					answer = true;
					break;
				}
			} else if (i == 4) {
				if (items1.get(i) == con1 && items2.get(i - 1) == con2) {
					answer = true;
					break;
				}
			} else {
				if (items1.get(i) == con1 && items2.get(i + 1) == con2) {
					answer = true;
					break;
				} else if (items1.get(i) == con1 && items2.get(i - 1) == con2) {
					answer = true;
					break;
				}
			}
		}
		return answer;
	}

	/**
	 * 
	 * @param array
	 * @return
	 */
	protected List<String> arrayToList(String[] array) {
		List<String> rlt = new ArrayList<String>();
		for (String item : array) {
			rlt.add(item);
		}
		return rlt;
	}

	/**
	 * 
	 * @param arrays
	 */
	protected void printArray(List<List<String>> arrays) {
		for (List<String> items : arrays) {
			for (String item : items) {
				System.out.print(" " + item + " ");
			}
			System.out.println();
		}
		System.out.println("There are total about " + arrays.size() + " combo");
	}

	/**
	 * 
	 * @param items
	 * @return
	 */
	protected List<List<String>> comboItems(List<String> items) {
		List<List<String>> rlt = new ArrayList<List<String>>();
		if (items.size() == 2) {
			List<String> combo1 = new ArrayList<String>();
			combo1.add(items.get(0));
			combo1.add(items.get(1));
			List<String> combo2 = new ArrayList<String>();
			combo2.add(items.get(1));
			combo2.add(items.get(0));
			rlt.add(combo1);
			rlt.add(combo2);
			return rlt;
		} else {
			for (String item : items) {
				List<String> cloneItems = new ArrayList<String>();
				cloneItems.addAll(items);
				cloneItems.remove(item);
				for (List<String> array : comboItems(cloneItems)) {
					array.add(item);
					rlt.add(array);
				}
			}
			return rlt;
		}
	}
}
