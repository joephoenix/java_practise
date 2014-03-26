package phoenix.practise.first;

public class Fibonacci {

	public static final int MONTH = 25;

	public static void main(String[] args) {
		long f1 = 1L, f2 = 1L;
		long f;
		for (int i = 3; i < MONTH; i++) {
			f = f2;
			f2 = f1 + f2;
			f1 = f;
			System.out.print("第" + i + "个月的兔子对数: ");
			System.out.println("  " + f2);
		}
	}

}
