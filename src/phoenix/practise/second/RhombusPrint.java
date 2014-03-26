package phoenix.practise.second;

import java.util.Scanner;

public class RhombusPrint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input the height" + " of the rhombus");
		int halfRhombusHeight = sc.nextInt();
		for (int i = 1; i < halfRhombusHeight; i++) {
			double value = (halfRhombusHeight - i) / 2;
			int blanklength = (int) Math.floor(value);
			for (int k = blanklength; k > 0; k--) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int x = halfRhombusHeight - 1; x > 0; x--) {
			double value = (halfRhombusHeight - x) / 2;
			int blanklength = (int) Math.ceil(value);
			for (int z = 0; z < blanklength; z++) {
				System.out.print(" ");
			}
			for (int y = 0; y < x; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}
}
