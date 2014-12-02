package phoenix.collect.wff;

import java.util.ArrayList;
import java.util.List;

public class ComboJudge {

	/**
	 * 使用第10个，第11个和第15个对筛选后的组合进行判断
	 * 
	 * 吸Blend香烟的人住在养猫人家的隔壁
	 * 
	 * 养马的屋主在吸Dunhill香烟的人家的隔壁
	 * 
	 * 只喝开水的人住在吸Blend香烟的人的隔壁
	 * 
	 * @param allRows
	 *            完整的5个组合数组,国家颜色饮料香烟宠物
	 * @return
	 */
	public List<String[][]> integritySelects(List<String[][]> allRows) {
		List<String[][]> rlt = new ArrayList<String[][]>();
		for (String[][] cl : allRows) {
			boolean bIsMatch10 = false;
			boolean bIsMatch11 = false;
			boolean bIsMatch15 = false;
			int i = 0;
			for (String item_cg : cl[3]) {
				if (item_cg == "Blend") {
					if (i == 0) {
						if (cl[4][i + 1] == "Cat") {
							bIsMatch10 = true;
						} else {
							bIsMatch10 = false;
						}
					} else if (i == 4) {
						if (cl[4][i - 1] == "Cat") {
							bIsMatch10 = true;
						} else {
							bIsMatch10 = false;
						}
					} else {
						if (cl[4][i - 1] == "Cat" || cl[4][i + 1] == "Cat") {
							bIsMatch10 = true;
						} else {
							bIsMatch10 = false;
						}
					}
				}
				i++;
			}
			int j = 0;
			for (String item_cg : cl[3]) {
				if (item_cg == "Dunhill") {
					if (j == 0) {
						if (cl[4][j + 1] == "Horse") {
							bIsMatch11 = true;
						} else {
							bIsMatch11 = false;
						}
					} else if (j == 4) {
						if (cl[4][j - 1] == "Horse") {
							bIsMatch11 = true;
						} else {
							bIsMatch11 = false;
						}
					} else {
						if (cl[4][j - 1] == "Horse" || cl[4][j + 1] == "Horse") {
							bIsMatch10 = true;
						} else {
							bIsMatch10 = false;
						}
					}
				}
				j++;
			}
			int k = 0;
			for (String item_cg : cl[3]) {
				if (item_cg == "Blend") {
					if (k == 0) {
						if (cl[2][k + 1] == "Water") {
							bIsMatch15 = true;
						} else {
							bIsMatch15 = false;
						}
					} else if (k == 4) {
						if (cl[2][k - 1] == "Water") {
							bIsMatch15 = true;
						} else {
							bIsMatch15 = false;
						}
					} else {
						if (cl[2][k - 1] == "Water" || cl[2][k + 1] == "Water") {
							bIsMatch15 = true;
						} else {
							bIsMatch15 = false;
						}
					}
				}
				k++;
			}
			if (bIsMatch10 && bIsMatch11 && bIsMatch15) {
				rlt.add(cl);
			}
		}
		return rlt;
	}

	/**
	 * 把香烟的条件加入到国家、颜色、饮料和香烟组成的二维数组中，然后筛选出符合判断条件的组合。
	 * 
	 * 使用第2个条件、第6个条件
	 * 
	 * @param fourRows
	 *            国家颜色饮料香烟的二维数组列表
	 * @param arrayspt
	 *            宠物的组合列表
	 * @return
	 */
	public List<String[][]> addPetsToCombo(List<String[][]> fourRows,
			List<List<String>> arrayspt) {
		List<String[][]> rlt = new ArrayList<String[][]>();
		for (String[][] cl : fourRows) {
			for (List<String> items : arrayspt) {
				String[][] comboItem = new String[5][5];
				comboItem[0] = cl[0];
				comboItem[1] = cl[1];
				comboItem[2] = cl[2];
				comboItem[3] = cl[3];
				items.toArray(comboItem[4]);
				if (isMatch_2_6(comboItem)) {
					rlt.add(comboItem);
				}
			}
		}
		return rlt;
	}

	/**
	 * 
	 * 判断是否符合第2个，第6个条件判断：
	 * 
	 * 瑞典人养了一只狗； 吸PallMall香烟的屋主养鸟
	 * 
	 * @param comboItem
	 *            国家、颜色、饮料、香烟和宠物的排列组合
	 * @return
	 */
	protected boolean isMatch_2_6(String[][] comboItem) {
		boolean bIsMatch2 = false;
		boolean bIsMatch6 = false;
		int i = 0;
		for (String item_cn : comboItem[0]) {
			if (item_cn == "Swiden") {
				if (comboItem[4][i] == "Dog") {
					bIsMatch2 = true;
				}
			}
			i++;
		}
		int j = 0;
		for (String item_cg : comboItem[3]) {
			if (item_cg == "PallMall") {
				if (comboItem[4][j] == "Bird") {
					bIsMatch6 = true;
				}
			}
			j++;
		}
		if (bIsMatch2 && bIsMatch6) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 把香烟的条件加入到国家、颜色和饮料组成的二维数组中，然后筛选出符合判断条件的组合。
	 * 
	 * 使用第7个，第12个，第13个判断条件
	 * 
	 * @param CNCLDR
	 *            国家颜色饮料的二维数组列表
	 * @param arrayscg
	 *            香烟的组合列表
	 * @return
	 */
	public List<String[][]> addCigraterToCombo(List<String[][]> CNCLDR,
			List<List<String>> arrayscg) {
		List<String[][]> rlt = new ArrayList<String[][]>();
		for (String[][] cl : CNCLDR) {
			for (List<String> items : arrayscg) {
				String[][] comboItem = new String[4][5];
				comboItem[0] = cl[0];
				comboItem[1] = cl[1];
				comboItem[2] = cl[2];
				items.toArray(comboItem[3]);
				if (isMatch7_12_13(comboItem)) {
					rlt.add(comboItem);
				}
			}
		}
		return rlt;
	}

	/**
	 * 
	 * 判断是否符合第7个，第12个和第13个条件判断：
	 * 
	 * 黄色屋主吸Dunhill香烟； 吸BlueMaster香烟的屋主喝啤酒；德国人吸Prince香烟
	 * 
	 * @param comboItem
	 *            国家、颜色、饮料和香烟的排列组合
	 * @return
	 */
	protected boolean isMatch7_12_13(String[][] comboItem) {
		boolean bIsMatch07 = false;
		boolean bIsMatch12 = false;
		boolean bIsMatch13 = false;
		int i = 0;
		for (String item_cl : comboItem[1]) {
			if (item_cl == "Yellow") {
				if (comboItem[3][i] == "Dunhill") {
					bIsMatch07 = true;
				}
			}
			i++;
		}
		int j = 0;
		for (String item_dr : comboItem[2]) {
			if (item_dr == "Beer") {
				if (comboItem[3][j] == "BlueMaster") {
					bIsMatch12 = true;
				}
			}
			j++;
		}
		int k = 0;
		for (String item_cn : comboItem[0]) {
			if (item_cn == "Germay") {
				if (comboItem[3][k] == "Prince") {
					bIsMatch13 = true;
				}
			}
			k++;
		}

		if (bIsMatch07 && bIsMatch12 && bIsMatch13) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 把国家、颜色和饮料这三项组合起来，然后筛选出符合判断条件的组合。 使用第1个，第3个，第5个条件判断
	 * 
	 * @param arrays1
	 *            国家的组合列表
	 * @param arrays2
	 *            颜色的组合列表
	 * @param arrays3
	 *            饮料的组合列表
	 * @return
	 */
	public List<String[][]> countryDrinkColorCombo(List<List<String>> arrays1,
			List<List<String>> arrays2, List<List<String>> arrays3) {
		List<String[][]> rlt = new ArrayList<String[][]>();
		for (List<String> items1 : arrays1) {
			for (List<String> items2 : arrays2) {
				for (List<String> items3 : arrays3) {
					String[][] comboItem = new String[3][5];
					items1.toArray(comboItem[0]);
					items2.toArray(comboItem[1]);
					items3.toArray(comboItem[2]);
					if (isMatch1_3_5(comboItem)) {
						rlt.add(comboItem);
					}
				}
			}
		}
		return rlt;
	}

	/**
	 * 判断是否符合第1个，第3个和第5个条件判断： 英国人住在红色房屋里； 丹麦人喝茶；绿色房屋的屋主喝咖啡
	 * 
	 * @param comboItem
	 *            国家、颜色和饮料的排列组合
	 * @return
	 */
	protected boolean isMatch1_3_5(String[][] comboItem) {
		boolean bIsMatch1 = false;
		boolean bIsMatch3 = false;
		boolean bIsMatch5 = false;
		int i = 0;
		for (String item_cn : comboItem[0]) {
			if (item_cn == "England") {
				if (comboItem[1][i] == "Red") {
					bIsMatch1 = true;
				}
			}
			i++;
		}
		int j = 0;
		for (String item_cn : comboItem[0]) {
			if (item_cn == "Danish") {
				if (comboItem[2][j] == "Tea") {
					bIsMatch3 = true;
				}
			}
			j++;
		}
		int k = 0;
		for (String item_cl : comboItem[1]) {
			if (item_cl == "Green") {
				if (comboItem[2][k] == "Coffee") {
					bIsMatch5 = true;
				}
			}
			k++;
		}

		if (bIsMatch1 && bIsMatch3 && bIsMatch5) {
			return true;
		} else {
			return false;
		}
	}
}
