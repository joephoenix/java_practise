package phoenix.practise.second;

import java.util.Scanner;

public class B36Quetation2linear {

	public static void main(String[] args) {
		double a, b, c, disc, x1, x2, realpart, imagpart;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("输入a的值");
		a = input.nextDouble();
		System.out.println("输入b的值");
		b = input.nextDouble();
		System.out.println("输入c的值");
		c = input.nextDouble();
		System.out.println("这个方程:");
		if (Math.abs(a) <= Math.pow(10, -6)) {
			System.out.println("不是一元二次方程");
		} else {
			disc = b * b - 4 * a * c;
			if (Math.abs(disc) <= Math.pow(10, -6)) {
				System.out.println("有两个相等实数根：" + -b / (2 * a));
			} else if (disc > Math.pow(10, -6)) {
				x1 = (-b + Math.sqrt(disc)) / (2 * a);
				x2 = (-b - Math.sqrt(disc)) / (2 * a);
				System.out.println("有两个实数根,分别是：" + x1 + "和" + x2);
			} else {
				realpart = -b / (2 * a);
				imagpart = Math.sqrt(-disc) / (2 * a);
				System.out.println("有两个共轭复根：");
				System.out.println(realpart + "+" + imagpart + "i");
				System.out.println(realpart + "-" + imagpart + "i");
			}
		}
	}

}
