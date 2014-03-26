package phoenix.practise.second;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortAscend {

	private Scanner sc;

	public static void main(String[] args) {
		System.out.println("Please input three number to sort:");
		String rootPath = SortAscend.class.getResource("/").toString();
		rootPath = rootPath.substring(0, rootPath.lastIndexOf("/"));
		rootPath = rootPath.substring(0, rootPath.lastIndexOf("/"));
		rootPath = rootPath.substring(0, rootPath.lastIndexOf("/"));
		System.out.println(rootPath+"/");
		SortAscend sa = new SortAscend();
		List<Integer> ls = new ArrayList<Integer>();
		while (true) {
			int nm = sa.input();
			if (nm == 0) {
				break;
			}
			ls.add(nm);
		}
		// 排序
		List<Integer> sorted = new ArrayList<Integer>();
		sorted = sa.bobbleSort(ls);
		for (Integer i : sorted) {
			System.out.print(i + " ");
		}
		sa.close();
	}

	public int input() {
		sc = new Scanner(System.in);
		int number = sc.nextInt();
		return number;
	}

	public void close() {
		sc.close();
	}

	public List<Integer> bobbleSort(List<Integer> inList) {
		int[] numbers = new int[inList.size()];
		for (int i = 0; i < inList.size(); i++) {
			numbers[i] = (int) inList.get(i);
		}

		for (int x = 0; x < numbers.length; x++) {
			for (int y = 0; y < x; y++) {
				if (numbers[x] < numbers[y]) {
					int temp = numbers[x];
					numbers[x] = numbers[y];
					numbers[y] = temp;
				}
			}
		}
		List<Integer> result = new ArrayList<Integer>();
		for (int k : numbers) {
			result.add(k);
		}
		return result;
	}

}
