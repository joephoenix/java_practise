package phoenix.practise.second;

import javax.swing.JOptionPane;

public class B37DecryptCode {

	public static void main(String[] args) {
		String string;
		int numberOfString;
		char letter;
		string = JOptionPane.showInputDialog(null, "输入字符串:");
		numberOfString = string.length();
		for (int i = 0; i < numberOfString; i++) {
			letter = string.charAt(i);
			if ((letter >= 'a' && letter <= 'z')
					|| (letter >= 'A' && letter <= 'Z')) {
				letter = (char) (letter + 4);
				if ((letter > 'Z' && letter <= 'Z' + 4) || letter >= 'z') {
					letter = (char) (letter - 26);
				}
				System.out.print(letter);
			}
			System.out.print(letter);
		}

	}
}
