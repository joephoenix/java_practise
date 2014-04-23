package phoenix.practise.forth;

import java.io.FileInputStream;
import java.io.IOException;

public class D02FileInputStream {

	public static void main(String[] args) {
		long num = 0;
		int b = 0;
		FileInputStream finput = null;
		try {
			finput = new FileInputStream(
					"C:/ProjectFolder/Eclipse_projects/java_practise"
							+ "/src/phoenix/practise/forth/D02TestFileInputStream.java");
		} catch (IOException ioex) {
			System.out.println("File is not found!");
			System.exit(-1);
		}
		try {
			while ((b = finput.read()) != -1) {
				System.out.print((char) b);
				num++;
			}
			System.out.println();
			System.out.println("The number char of this file is " + num);
			finput.close();
		} catch (IOException ioex2) {
			System.out.println("文件读取错误！");
			System.exit(-1);
		}
	}
}
