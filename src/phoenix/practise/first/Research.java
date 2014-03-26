package phoenix.practise.first;

import java.util.Scanner;

public class Research {

	static int grade;

	public static void main(String[] args) {
		Scanner str = new Scanner(System.in);
		int s = str.nextInt();
		Research rs = new Research();
		grade = rs.compare(s);
		if (grade == 1) {
			System.out.println("A");
		} else if (grade == 2) {
			System.out.println("B");
		} else {
			System.out.println("C");
		}
	}

	public int compare(int s) {
		return s > 90 ? 1 : s > 60 ? 2 : 3;
	}

}
