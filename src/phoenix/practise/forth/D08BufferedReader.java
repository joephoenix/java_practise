package phoenix.practise.forth;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class D08BufferedReader {

	public static void main(String[] args) {
		long num = 0;
		int b = 0;
		FileReader freader = null;
		BufferedReader breader = null;
		try {
			String path = D08BufferedReader.class.getResource("").getPath();
			path = path.replace("/bin/", "/src/");
			freader = new FileReader(path + "D08BufferedReader.java");
			breader = new BufferedReader(freader);
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件！");
			System.exit(-1);
		}

		try {
			while ((b = breader.read()) != -1) {
				System.out.print((char) b);
				num++;
			}
			System.out.println();
			System.out.println("The number char of this file is " + num);
			freader.close();
			breader.close();
		} catch (IOException e) {
			System.out.println("文件操作失败！");
			System.exit(-1);
		}
		System.exit(0);
	}

}
