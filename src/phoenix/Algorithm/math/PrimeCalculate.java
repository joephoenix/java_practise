package phoenix.Algorithm.math;

public class PrimeCalculate {

	private byte[] bits;

	public PrimeCalculate(int N) {
		bits = new byte[(N - 1) / 16 + 1];
	}

	public boolean get(int n) {
		if ((n & 1) != 0) {
			return (bits[n >> 4] & 1 << (n - 1 >> 1 & 7)) != 0;
		} else {
			return false;
		}
	}

	public void set(int n) {
		if ((n & 1) != 0) {
			bits[n >> 4] |= 1 << (n - 1 >> 1 & 7);
		}
	}

	public void clean(int n) {
		if ((n & 1) != 0) {
			bits[n >> 4] &= ~(1 << (n - 1 >> 1 & 7));
		}
	}

	public static void main(String[] args) {
		long starttime = System.nanoTime();
		PrimeCalculate pcSet = new PrimeCalculate(0x7fffffff);
		int count = 1;
		for (int i = 3; i > 0; i += 2) {
			pcSet.set(i);
		}
		for (int i = 3; i * i > 0; i += 2) {
			if (pcSet.get(i)) {
				for (int k = i * i; k > 0; k = k + i + i) {
					pcSet.clean(k);
				}
			}
		}
		long endtime = System.nanoTime();
		long temp = 0;
		for (int i = 3; i > 0; i += 2) {
			if (pcSet.get(i)) {
				count++;
				temp = i;
			}
		}
		long seconds = (long) (endtime - starttime) / 1000000000;
		System.out.println("find " + count
				+ " Prime numbers, the time for search is " + seconds
				+ "s, the bigest Prime number can find now is " + temp);
	}

}
