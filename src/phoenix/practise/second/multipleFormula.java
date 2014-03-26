package phoenix.practise.second;

public class multipleFormula {

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (j > i) {
					break;
				}
				int result = i * j;
				String rString = "";
				if (result < 10) {
					rString = "0" + result;
				} else {
					rString = String.valueOf(result);
				}
				System.out.print(i + "*" + j + "=" + rString + "  ");
			}
			System.out.println();
		}
	}

}
