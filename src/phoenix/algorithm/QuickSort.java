package phoenix.algorithm;

public class QuickSort {

	private static void QuickSortMethod(int[] a, int low, int high) {
		int i, j, temp;
		if (low < high) {
			i = low;
			j = high;
			temp = a[i];
			while (i < j) {
				// 如果a[j]大于temp及a[i]，则从数组后端往前端比
				while (i < j && a[j] > temp) {
					j--;
					if (i < j) {
						a[i] = a[j];
						i++;
					}
				}
				// 如果a[i]小于temp即a[i]，则从数组前端往后端比
				while (i < j && a[i] < temp) {
					i++;
					if (i < j) {
						a[j] = a[i];
						j--;
						a[i] = a[j];
					}
				}
			}
			a[i] = temp;
			QuickSortMethod(a, low, i - 1);
			QuickSortMethod(a, i + 1, high);
		}
	}

	public static void main(String[] args) {
		int[] test1 = { 2, 300, 5, 110, 7, 9, 8, 10, 256, 246, 14, 110 };
		QuickSortMethod(test1, 0, 11);

		for (int i = 0; i < test1.length; i++) {
			System.out.print(test1[i] + "  ");
		}
	}
}
