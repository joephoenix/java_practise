package phoenix.practise.forth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class D09BufferedWriter {

	public static void main(String[] args) {
		long num = 0;
		int b = 0;
		FileReader freader = null;
		FileWriter fwriter = null;
		BufferedReader breader = null;
		BufferedWriter bwriter = null;
		try {
			String path = D09BufferedWriter.class.getResource("").getPath();
			path = path.replace("/bin/", "/src/");
			freader = new FileReader(path + "D09BufferedWriter.java");
			breader = new BufferedReader(freader);
		} catch (FileNotFoundException e) {
			System.out.println("文件读取失败！");
			System.exit(-1);
		}

		try {
			String path = D09BufferedWriter.class.getResource("").getPath();
			path = path.replace("/bin/", "/src/");
			fwriter = new FileWriter(path + "D09Clone.txt");
			bwriter = new BufferedWriter(fwriter);
		} catch (IOException e) {
			// FileWriter的异常为IOException
			System.out.println("文件写出错误！");
			System.exit(-1);
		}

		try {
			while ((b = breader.read()) != -1) {
				System.out.print((char) b);
				bwriter.write(b);
				num++;
			}
			System.out.println();
			System.out.println("The number char of this file is " + num);
			fwriter.flush();
			bwriter.flush();
			freader.close();
			breader.close();
			fwriter.close();
			bwriter.close();
		} catch (IOException e) {
			System.out.println("文件操作失败！");
			System.exit(-1);
		}
		System.exit(0);

	}

}
