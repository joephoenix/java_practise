package phoenix.collect;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

//还需要再优化,计算1000的阶乘
public class Factorial10000 {

	public static void main(String[] args) {
		// method one
		BigInteger bi = BigInteger.ONE;
		for (int i = 2; i <= 1100; i++) {
			bi = bi.multiply(BigInteger.valueOf(i));
		}
		System.out.println("The Factorial of 10000 is : " + bi.toString());

		// method two
		String result = "1";
		for (int i = 2; i <= 1100; i++) {
			result = multiple(result, String.valueOf(i));
		}
		System.out.println("The Factorial of 10000 is : " + result);
	}

	private static String multiple(String a, String b) {
		if (a.length() > 1 && b.length() > 1) {
			// if (b.length() > 2) {
			// System.out.println("now in the hundrund ! " + b);
			// }
			List<String> rltInRows = new ArrayList<String>();
			for (int i = b.length() - 1; i >= 0; i--) {
				StringBuilder sbRow = new StringBuilder();
				for (int j = 0; j < b.length() - 1 - i; j++) {
					sbRow.append("0");
				}
				int mNumber = Integer
						.valueOf(String.valueOf(b.toCharArray()[i]));
				int rlttoup = 0;
				int alength = a.length();
				for (int x = alength - 1; x >= 0; x--) {
					int nNumber = Integer.valueOf(String.valueOf(a
							.toCharArray()[x]));
					String rltInEC = String.valueOf((nNumber * mNumber)
							+ rlttoup);
					int rtplength = rltInEC.length();
					if (rtplength > 1) {
						rlttoup = Integer.valueOf(String.valueOf(rltInEC
								.toCharArray()[0]));
						sbRow.append(String.valueOf(rltInEC.toCharArray()[1]));
					} else {
						rlttoup = 0;
						sbRow.append(rltInEC);
					}
				}
				if (rlttoup != 0) {
					sbRow.append(rlttoup);
				}
				rltInRows.add(sbRow.toString());
			}

			Integer maxPosition = 1;
			// 取得最大的位数
			for (String k : rltInRows) {
				if (Integer.valueOf(k.length()).compareTo(maxPosition) > 0) {
					maxPosition = Integer.valueOf(k.length());
				}
			}

			// 使用加法计算总和
			String resultString = "";
			for (String k : rltInRows) {
				resultString = additive(resultString, k, maxPosition);
			}
			return new StringBuffer(resultString).reverse().toString();
		} else {
			Long result = (Long.valueOf(a)) * (Long.valueOf(b));
			return result.toString();
		}
	}

	private static String additive(String a, String b, Integer max) {
		if (a == "" || b == "") {
			return a + b;
		} else {
			StringBuilder sbRow = new StringBuilder();
			// 给数字比较小的值补位，即前面加0
			String zerosofa = "";
			for (int j = 0; j < max - a.length(); j++) {
				zerosofa = zerosofa + "0";
			}
			a = a + zerosofa;

			String zerosofb = "";
			for (int j = 0; j < max - b.length(); j++) {
				zerosofb += "0";
			}
			b = b + zerosofb;

			// 开始计算总和
			int rlttoup = 0;
			for (int i = 0; i < max; i++) {
				int rltInEC = Integer
						.valueOf(String.valueOf((a.toCharArray()[i])))
						+ Integer.valueOf(String.valueOf(b.toCharArray()[i]))
						+ rlttoup;
				if (rltInEC > 9) {
					rlttoup = 1;
					sbRow.append(String.valueOf(String.valueOf(rltInEC)
							.toCharArray()[1]));
				} else {
					rlttoup = 0;
					sbRow.append(String.valueOf(rltInEC));
				}
			}
			if (rlttoup != 0) {
				sbRow.append(rlttoup);
			}
			return sbRow.toString();
		}
	}
}
