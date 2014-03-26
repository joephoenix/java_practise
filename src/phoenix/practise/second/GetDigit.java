package phoenix.practise.second;

import java.util.Scanner;

public class GetDigit {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please input a number big than 1000000");
		Long numberInput = s.nextLong();
		String strNum = Long.toString(numberInput);
		String getNum = "";
		if (strNum.length() > 7) {
			int end = strNum.length();
			int start = end - 7;
			getNum = strNum.substring(start).substring(0, 4);
		} else {
			getNum = strNum;
			if (getNum.length() > 4) {
				getNum = strNum.substring(0, 4);
			}
		}
		System.out.println("the last seven digit is " + getNum);
	}
}
