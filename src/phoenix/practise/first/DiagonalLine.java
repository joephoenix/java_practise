package phoenix.practise.first;

import java.util.Scanner;

public class DiagonalLine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] a = new int[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		System.out.println("输入3*3的矩阵:");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}

		int sum = 0;
		// 计算对角线之和
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j) {
					sum += a[i][j];
				}
			}
		}
		System.out.println("The sum of Diagonal Line is : " + sum);

	}

}
