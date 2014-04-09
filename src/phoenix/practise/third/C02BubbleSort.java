package phoenix.practise.third;

public class C02BubbleSort {
	public static void BubbleSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				// 内循环，一次对相邻的两个元素进行比较，
				// 并通过temp值将两个数据按照要求排序
				if (a[j + 1] < a[j]) {
					// 交换数据
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int test1[] = { 3, 1, 6, 49, 24, 38, 65, 97, 73, 8, 13, 27, 99 };
		System.out.println("old sort is :");
		for (int i = 0; i < test1.length; i++) {
			System.out.print(test1[i] + "  ");
		}
		System.out.println();
		System.out.println("current sort is :");
		BubbleSort(test1);
		for (int i = 0; i < test1.length; i++) {
			System.out.print(test1[i] + "  ");
		}
	}
}
