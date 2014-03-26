package phoenix.practise.first;

public class NarcissusNumers {

	static int b, bb, bbb;

	public void findNumber(int m) {
		bbb = m / 100;
		bb = (m % 100) / 10;
		b = ((m % 100) % 10);
		if ((bbb * bbb * bbb + bb * bb * bb + b * b * b) == m) {
			System.out.println("The NarcissusNumber is " + m);
		}
	}

	public static void main(String[] args) {
		for (int i = 101; i < 1000; i++) {
			NarcissusNumers nn = new NarcissusNumers();
			nn.findNumber(i);
		}
	}

}
