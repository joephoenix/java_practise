package phoenix.practise.first;

import java.util.Scanner;

public class PrimeOragenize {
	static int n, k = 2;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		System.out.print(n + "==");
		PrimeOragenize po = new PrimeOragenize();
		po.divide(n);
	}

	public void divide(int n) {
		while (k <= n) {
			if (k == n) {
				System.out.println(n);
				break;
			} else if (n > k && n % k == 0) {
				System.out.print(k + "*");
				n = n / k;
				divide(n);
				break;
			} else if (n > k && n % k != 0) {
				k++;
				divide(n);
				break;
			}
		}
	}

}
