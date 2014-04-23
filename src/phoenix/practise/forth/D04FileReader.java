package phoenix.practise.forth;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class D04FileReader {

	/**
	 * FileInputStream和FileReader二者主要区别
	 * 
	 * 就在于FileInputStream类一次只可以读入一个字节，
	 * 
	 * 而FileReader类一次可以读入两个字节，即一个字。
	 * 
	 */

	public static void main(String[] args) {
		long num = 0;
		int b = 0;
		FileReader reader = null;
		try {
			reader = new FileReader("C:/ProjectFolder/"
					+ "Eclipse_projects/java_practise"
					+ "/src/phoenix/practise/forth/D04TestFileReader.java");
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在");
			System.exit(-1);
		}
		try {
			while ((b = reader.read()) != -1) {
				System.out.print((char) b);
				num++;
			}
			System.out.println();
			System.out.println("The number char of this file is " + num);
			reader.close();
		} catch (IOException e) {
			System.out.println("读取文件时错误 ");
			System.exit(-1);
		}
		System.exit(0);
	}
}
