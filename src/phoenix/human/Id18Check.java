package phoenix.human;

public class Id18Check {

	int[] weight = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
	char[] validate = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };

	public char getValidateCode(String idpre17) {
		int sum = 0;
		int mode = 0;
		for (int i = 0; i < idpre17.length(); i++) {
			sum = sum + Integer.parseInt(String.valueOf(idpre17.charAt(i))) * weight[i];
		}
		mode = sum % 11;
		return validate[mode];
	}

	public static void main(String[] args) {
		Id18Check ictest = new Id18Check();
		System.out.println("此身份证校验码为：" + ictest.getValidateCode("33052119801103001"));
	}

}
