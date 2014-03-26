package phoenix.practise.first;

public class Prime {

	public static int count = 0;

	public static void main(String[] args) {
		Prime prime = new Prime();
		// prime.getPrime(1000);
		prime.getMaxPrime(100L);
		System.out.println("\n素数的个数：" + count);
	}

	/**
	 * 一个递归函数，找寻最大的素数
	 * 
	 * @param i
	 *            输入的数字
	 */
	public void getMaxPrime(long i) {
		if (isPrime(i)) {
			System.out.println("这个数字" + i + "是素数！");
		}
		i++;
		System.out.println("the number is " + i);
		getMaxPrime(i);
	}

	/**
	 * 判断一个数是否是素数
	 * 
	 * @param number
	 *            输入的数字
	 * @return
	 */
	public boolean isPrime(long number) {
		boolean isprime = true;
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				isprime = false;
			}
		}
		return isprime;
	}

	/***
	 * 判断一定范围内有多少个素数！
	 * 
	 * @param rang
	 *            最大的数字范围
	 */
	public void getPrime(int rang) {
		for (int i = 101; i < rang; i++) {
			boolean b = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					b = false;
					break;
				}
			}
			if (b) {
				count++;
				if (count % 7 == 0) {
					System.out.println(i + "  ");
				} else {
					System.out.print(i + "  ");
				}
			}
		}
	}

}
