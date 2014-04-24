package phoenix.practise.forth;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class D07BufferedOutputStream {

	public static void main(String[] args) {
		FileOutputStream foutput = null;
		FileInputStream finput = null;
		BufferedOutputStream boutput = null;
		BufferedInputStream binput = null;
		long num = 0;
		int b = 0;
		try {
			finput = new FileInputStream(
					"/Users/joephoenix/Projects/javaProject/"
							+ "java_practise/src/phoenix/practise/"
							+ "forth/D07BufferedOutputStream.java");
			binput = new BufferedInputStream(finput);
		} catch (FileNotFoundException e) {
			System.out.println("文件输入错误！");
			System.exit(-1);
		}

		try {
			foutput = new FileOutputStream("/Users/joephoenix/Downloads/"
					+ "D07BufferedOutputStreamClone.txt");
			boutput = new BufferedOutputStream(foutput);
		} catch (FileNotFoundException e) {
			System.out.println("文件输出错误！");
			System.exit(-1);
		}

		try {
			while ((b = binput.read()) != -1) {
				// System.out.print((char) b);
				boutput.write(b);
				num++;
			}
			System.out.println();
			System.out.println("The number char of this file is " + num);
			finput.close();
			binput.close();
			foutput.flush();
			foutput.close();
			// 该句一定会抛出IOException异常，所以如果运行这一句，System.out.println("文件操作失败！");
			// 就一定会运行
			// output.flush();
			// boutput.close();
		} catch (IOException e) {
			System.out.println("文件操作失败！");
			System.exit(-1);
		}
		System.exit(0);
	}

}
