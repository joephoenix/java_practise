package phoenix.practise.third;

import java.util.Random;

public class C05AscendSort {

	public C05AscendSort() {
		System.out.println("直接插入排序法");
	}

	/**
	 * 直接插入法递增排序
	 * 
	 * @param with
	 * @return
	 */
	private int[] sortAscending(int[] with) {
		// 取得带插入数组的长度
		int length = with.length;
		// 新建一个等长的待插入数组
		int[] temp = new int[length];
		// 初始化temp数组的元素为with[0]
		temp[0] = with[0];

		// --------------------
		// 遍历with数组
		for (int i = 1; i < length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (with[i] >= temp[j]) {
					// 如果待排序列中的元素大于等于有序序列中的元素，则插入
					temp[j + 1] = with[i];
					break;
				} else {
					temp[j + 1] = temp[j];
					// 如果遍历到的元素小于已存在temp中的数组，
					// 则预留空间，在内循环的下次遍历中会temp[j]的空间会被with[i]填充
					// 或者继续向前预留空间
					if (j == 0) {
						// with[[i]是有序序列中最小的，因此排在开头
						temp[j] = with[i];
					}
				}
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		// 随机生成测试数组
		int[] test = new int[20];
		int x = 0;
		while (x < 20) {
			Random random = new Random();
			test[x] = random.nextInt(100);
			x++;
		}
		// int[] test = { 49, 38, 65, 97, 76, 13, 27, 49 };
		// 中间变量
		int[] temp;
		// 排序
		C05AscendSort as = new C05AscendSort();
		temp = as.sortAscending(test);

		// 遍历及打印排序后的数组
		for (int i : temp) {
			System.out.print(i + " ");
		}

	}

}
