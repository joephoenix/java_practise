package phoenix.collect.wff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JudgeMent {
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

}
