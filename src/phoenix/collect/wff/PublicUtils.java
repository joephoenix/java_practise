package phoenix.collect.wff;

import java.util.ArrayList;
import java.util.List;

public class PublicUtils {

	/**
	 * 把数组转化为list
	 * 
	 * @param array
	 * @return
	 */
	public static List<String> arrayToList(String[] array) {
		List<String> rlt = new ArrayList<String>();
		for (String item : array) {
			rlt.add(item);
		}
		return rlt;
	}

	/**
	 * 打印一个集合列表的内容
	 * 
	 * @param arrayList
	 */
	public static void printArrayList(List<String[][]> arrayList) {
		for (String[][] cl : arrayList) {
			for (String[] array : cl) {
				String row = "[";
				for (String item : array) {
					int x = item.length();
					if (x < 10) {
						for (int y = 0; y < 10 - x; y++) {
							item += " ";
						}
					}
					row += item + ",";
				}
				System.out.println(row.substring(0, row.length() - 1) + "]");
			}
			System.out.println("-------------------------------");
		}
	}

	/**
	 * 打印一个组合列表的内容
	 * 
	 * @param arrays
	 */
	public static void printArray(List<List<String>> arrays) {
		for (List<String> items : arrays) {
			for (String item : items) {
				System.out.print(" " + item + " ");
			}
			System.out.println();
		}
		System.out.println("There are total about " + arrays.size() + " combo");
	}

	/**
	 * 递归组成不同类型的排列组合
	 * 
	 * @param items
	 * @return
	 */
	public static List<List<String>> comboItems(List<String> items) {
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
