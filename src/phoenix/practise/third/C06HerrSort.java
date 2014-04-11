package phoenix.practise.third;

public class C06HerrSort {

	public static void C06HerrSort(int[] a, int incr[]) {
		/****************************
		 * 接受两个数组作为参数， 第一个为待排序的数组，第二个为增量数组
		 ***********************/
		// 定义增量
		int span;
		// 获得数组长度
		int alen = a.length;
		// 外循环，根据增量的个数循环，每个增量一次排序
		for (int i = 0; i < incr.length; i++) {
			span = incr[i]; // 初始化增量
			// 内循环，j代表所分的组数
			for (int j = 0; j < span; j++) {
				// 组内直接插入排序
				for (int k = 0; k < alen - span; k += span) {
					int p = k;
					// current
					int temp = a[k + span];
					while (p >= 0 && a[p] > temp) {
						a[p + span] = a[p];
						p -= span;
					}
					a[p + span] = temp;
				}
			}
		}

	}

	public static void main(String[] args) {
		int incr[] = { 5, 3, 1 };
		int[] test1 = { 2, 300, 5, 8, 7, 9, 10, 256, 248, 14 };
		C06HerrSort.C06HerrSort(test1, incr);
		for (int i = 0; i < test1.length; i++) {
			System.out.print(test1[i] + " ");
		}

	}

}
