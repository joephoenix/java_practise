package phoenix.practise.first;

import java.util.Scanner;

public class HighCalculate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		int time = sc.nextInt();
		if (height > 65532 || time > 65532) {
			System.out.println("the number input is illegal!");
		}
		float sumdistance = height;
		float halfHeight = height;
		System.out.println("The height of ball in" + " first time is :"
				+ halfHeight);
		for (int i = 1; i < time; i++) {
			halfHeight = halfHeight / 2;
			sumdistance = sumdistance + halfHeight;
			int t = i + 1;
			System.out.println("The height of ball in time " + t + " is :"
					+ halfHeight);
		}
		sc.close();
		System.out.println("The all distance of ball run is " + sumdistance);
	}
}
