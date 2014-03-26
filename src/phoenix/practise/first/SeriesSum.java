package phoenix.practise.first;

import java.util.Scanner;

public class SeriesSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long number = sc.nextLong();
		int digit = sc.nextInt();
		long sum = 0L;
		long btem = 0L;
		StringBuilder sb = new StringBuilder();

		if (digit > 11) {
			System.out.println("Over the max number!");
		}

		sb.append("The sum of ");
		int i = 0;
		while (i < digit) {
			btem = btem + number;
			sum = sum + btem;
			number = number * 10;
			++i;
			System.out.println("The " + i + " degree number is : " + btem);
		}
		sc.close();
		String out = sb.toString();
		out = out.substring(0, out.length() - 1);
		System.out.println(out + " is : " + sum);
	}

}
