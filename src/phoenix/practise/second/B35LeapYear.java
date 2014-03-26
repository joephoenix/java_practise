package phoenix.practise.second;

import java.util.Scanner;

public class B35LeapYear {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("输入年份：");
		int year = input.nextInt();
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			// if a year can divide by 4 but not divide by 100 , this year is
			// leap year
			// if a year can divide by 400 , this year is leap year
			System.out.println(year + " is leap year");
		} else {
			System.out.println(year + " is normal year!");
		}
	}

}
