package phoenix.collect.wff;

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
		JudgeMent jm = new JudgeMent();
		ComboJudge cj = new ComboJudge();
		// colors
		List<String> colors = PublicUtils.arrayToList(new String[] { "Blue",
				"Yellow", "Red", "Green", "White" });
		List<List<String>> clrlt = PublicUtils.comboItems(colors);
		List<List<String>> after14 = jm.forteenCondition(clrlt);
		List<List<String>> after4 = jm.forthCondition(after14);
		// wff.printArray(after4);
		// contries
		List<String> contries = PublicUtils.arrayToList(new String[] {
				"England", "Norway", "Danish", "Germay", "Swiden" });
		List<List<String>> ctrlt = PublicUtils.comboItems(contries);
		List<List<String>> after9 = jm.nightCondition(ctrlt);
		// wff.printArray(after9);
		// drinks
		List<String> drinks = PublicUtils.arrayToList(new String[] { "Water",
				"Beer", "Milk", "Tea", "Coffee" });
		List<List<String>> drrlt = PublicUtils.comboItems(drinks);
		List<List<String>> after8 = jm.eighthCondition(drrlt);
		// wff.printArray(after8);
		// smokes
		List<String> smokes = PublicUtils.arrayToList(new String[] {
				"PallMall", "Dunhill", "Blend", "BlueMaster", "Prince" });
		List<List<String>> smrlt = PublicUtils.comboItems(smokes);
		// pets
		List<String> pettes = PublicUtils.arrayToList(new String[] { "Dog",
				"Fish", "Horse", "Bird", "Cat" });
		List<List<String>> ptrlt = PublicUtils.comboItems(pettes);

		/*****
		 * 第一部分，排列一个国家的组合列，不重合，然后判断宠物、红色、饮料，香烟是否符合要求，需要同时生效,第1，2，3，13个判断
		 ****/
		// 第一个判断
		Map<String, List<List<String>>> after1 = jm.firstCondition(after9,
				after4);
		// 第三个判断
		Map<String, List<List<String>>> after3 = jm.thirdCondition(
				after1.get("contry"), after8);
		// 第二个判断
		Map<String, List<List<String>>> after2 = jm.secondCondition(
				after3.get("contry"), ptrlt);
		// 第十三个判断
		Map<String, List<List<String>>> after13 = jm.thirdteenCondition(
				after2.get("contry"), smrlt);
		/***** 第二部分，对上面的结果再次筛选，如第5，6，7，12的判断； **********/
		// 第五个判断
		Map<String, List<List<String>>> after5 = jm.fifthCondition(
				after1.get("colors"), after3.get("drinks"));
		// 第六个判断
		Map<String, List<List<String>>> after6 = jm.sixthCondition(
				after13.get("smokes"), after2.get("pettes"));
		// 第七个判断
		Map<String, List<List<String>>> after7 = jm.seventhCondition(
				after5.get("colors"), after6.get("smokes"));
		// 第十二个判断
		Map<String, List<List<String>>> after12 = jm.twelfthCondition(
				after7.get("smokes"), after5.get("drinks"));
		/***** 第三部分,把国家、颜色和饮料这三项组合起来，然后筛选出符合判断条件的组合。 ****/
		List<String[][]> combo_CN_CL_DR = cj.countryDrinkColorCombo(
				after2.get("contry"), after5.get("colors"),
				after12.get("drinks"));
		/***** 第四部分， 加入 香烟的那一行 *****/
		List<String[][]> combo_CN_CL_DR_CG = cj.addCigraterToCombo(
				combo_CN_CL_DR, after7.get("smokes"));
		/****** 第五部分，加入宠物的那一行 *****/
		List<String[][]> combo_5all = cj.addPetsToCombo(combo_CN_CL_DR_CG,
				after6.get("pettes"));
		/***** 第六部分，使用第10，11，15判断筛选之后的内容是否符合条件 *****/
		List<String[][]> answer = cj.integritySelects(combo_5all);
		/***** 第七部分，打印出谁养鸟 *****/
		for (String[][] an : answer) {
			int i = 0;
			for (String item_pt : an[4]) {
				if (item_pt == "Fish") {
					System.out.println(an[0][i] + " may feed Fish");
				}
				i++;
			}
		}

	}
}
