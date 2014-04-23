package phoenix.practise.forth;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class D05FileWriter {

	public static void main(String[] args) {
		long num = 0;
		int b = 0;
		FileReader freader = null;
		FileWriter fwriter = null;
		try {
			freader = new FileReader("C:/ProjectFolder/"
					+ "Eclipse_projects/java_practise"
					+ "/src/phoenix/practise/forth/D05FileWriter.java");
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件 D05FileWriter.java！");
			System.exit(-1);
		}

		try {
			fwriter = new FileWriter("C:/TDDOWNLOAD/CopyFileWrite.java");
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件 CopyFileWrite.java！");
			System.exit(-1);
		} catch (IOException e) {
			System.out.println("文件操作失败！");
			System.exit(0);
		}

		try {
			while ((b = freader.read()) != -1) {
				// 如果不加char则输出的是十六进制字节
				System.out.print((char) b);
				fwriter.write(b);
				num++;
			}
			System.out.println();
			System.out.println("The number char of this file is  " + num);
			freader.close();
			fwriter.flush();
			fwriter.close();
		} catch (IOException e) {
			System.out.println("文件操作失败！");
			System.exit(0);
		}
		System.exit(0);
	}

}
