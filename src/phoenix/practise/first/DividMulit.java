package phoenix.practise.first;

import java.util.Scanner;

public class DividMulit {

	/**
	 * 求最大公约数
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int division(int x, int y) {
		int t;
		if (x < y) {
			t = x;
			x = y;
			y = t;
		}
		while (y != 0) {
			if (x == y) {
				return 1;
			} else {
				int k = x % y;
				x = y;
				y = k;
			}
		}
		return x;
	}

	public static void main(String[] args) {
		int a, b;
		Scanner s1 = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		a = s1.nextInt();
		b = s2.nextInt();
		DividMulit dm = new DividMulit();
		int m = dm.division(a, b);
		int n = a * b / m;
		System.out.println("The highest common divissor is : " + m);
		System.out.println("The least common multiple is : " + n);
	}

}
