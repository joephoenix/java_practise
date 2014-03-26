package phoenix.practise.first;

public class FullSquartNumber {
	public static void main(String[] args) {
		for (long l = 1L; 1 < 100000; l++) {
			if (Math.sqrt((long) (l + 100)) % 1 == 0) {
				if (Math.sqrt((long) (l + 168)) % 1 == 0) {
					System.out.println("求解的整数是：" + l);
				}
			}
		}
	}
}
