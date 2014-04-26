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
			String path = D07BufferedOutputStream.class.getResource("")
					.getPath();
			path = path.replace("/bin/", "/src/");
			finput = new FileInputStream(path + "D07BufferedOutputStream.java");
			binput = new BufferedInputStream(finput);
		} catch (FileNotFoundException e) {
			System.out.println("文件输入错误！");
			System.exit(-1);
		}

		try {
			String path = D07BufferedOutputStream.class.getResource("")
					.getPath();
			path = path.replace("/bin/", "/src/");
			foutput = new FileOutputStream(path + "D07Clone.txt");
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
			boutput.flush();
			foutput.flush();
			finput.close();
			binput.close();
			foutput.close();
		} catch (IOException e) {
			System.out.println("文件操作失败！");
			System.exit(-1);
		}
		System.exit(0);
	}

}
