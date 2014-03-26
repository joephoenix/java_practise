package phoenix.practise.second;

public class StringSort {

	public static void main(String[] args) {
		String temp = null;
		String[] s = new String[5];
		s[0] = "china".toLowerCase();
		s[1] = "apple".toLowerCase();
		s[2] = "MONEY".toLowerCase();
		s[3] = "BOOk".toLowerCase();
		s[4] = "yeah".toLowerCase();

		for (int i = 0; i < s.length; i++) {
			for (int j = i + 1; j < s.length; j++) {
				if (compare(s[i], s[j]) == false) {
					temp = s[i];
					s[i] = s[j];
					s[j] = temp;
				}
			}
		}

		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}

	}

	static boolean compare(String s1, String s2) {
		boolean result = true;
		for (int i = 0; i < s1.length() && i < s2.length(); i++) {
			if (s1.charAt(i) > s2.charAt(i)) {
				result = false;
				break;
			} else if (s1.charAt(i) < s2.charAt(i)) {
				result = true;
				break;
			} else {
				if (s1.length() < s2.length()) {
					result = true;
				} else {
					result = false;
				}
			}
		}
		return result;
	}
}
