package phoenix.practise.second;

import java.util.Scanner;

public class InsertSort {

	public static void main(String[] args) {
		int[] a = new int[] { 1, 5, 9, 17, 23, 29, 33, 41, 65, 73, 89, 101 };
		int[] b = new int[a.length + 1];
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int x = 0;
		for (int i : a) {
			if (i > num) {
				break;
			}
			x++;
		}
		for (int j = 0; j < x; j++) {
			b[j] = a[j];
		}
		b[x] = num;
		for (int k = x; k < a.length; k++) {
			b[k + 1] = a[k];
		}
		for (int l : b) {
			System.out.print(l + " ");
		}
	}
}
