package phoenix.practise.third;

public class C04ChooseSort {

	private static void ChooseSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			// 对数组循环，假设数据排在前面的元素总比后面的小，
			// 然后与后面的数据进行比较
			int k = i;
			for (int j = i + 1; j < a.length; j++) {
				// 对数据遍历，寻找最小的数据元素的数组下标
				if (a[j] < a[k]) {
					k = j;
				}
			}
			if (i != k) {
				int temp = a[i];
				a[i] = a[k];
				a[k] = temp;
			}
		}
	}

	public static void main(String[] args) {
		// 测试数组
		int[] test = { 51, 38, 49, 27, 62, 5, 16 };
		// 调用函数排序
		ChooseSort(test);
		// 打印排序后结果
		for (int i : test) {
			System.out.print(i + "    ");
		}
	}

}
