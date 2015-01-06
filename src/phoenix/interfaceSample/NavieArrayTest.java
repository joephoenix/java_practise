package phoenix.interfaceSample;

public class NavieArrayTest {

	NaiveArray array = new NaiveArray(1000000);

	public static void main(String[] args) {
		NavieArrayTest nat = new NavieArrayTest();
		// 第一种方法
		Long begin1 = System.currentTimeMillis();
		int sum1 = nat.compute1();
		Long end1 = System.currentTimeMillis();
		Long spend1 = (end1 - begin1);
		System.out.println("calculate had spend " + spend1.toString()
				+ "ms the sum is " + sum1);
		// 第二种方法
		Long begin2 = System.currentTimeMillis();
		int sum2 = nat.compute2();
		Long end2 = System.currentTimeMillis();
		Long spend2 = (end2 - begin2);
		System.out.println("calculate had spend " + spend2.toString()
				+ "ms the sum is " + sum2);
	}

	public int compute1() {
		for (int k = 0; k < array.size(); ++k) {
			array.set(k, k);
		}
		int sum = 0;
		for (int k = 0; k < array.size(); ++k) {
			sum += array.get(k);
		}
		return sum;
	}

	public int compute2() {
		if (array instanceof NaiveArray) {
			int[] back = ((NaiveArray) array).array;
			for (int k = 0; k < back.length; ++k) {
				back[k] = k;
			}
			int sum = 0;
			for (int k = 0; k < back.length; ++k) {
				sum += back[k];
			}
			return sum;
		} else {
			return 0;
		}
	}

}
