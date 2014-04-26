package phoenix.practise.forth;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class D06BufferedInputStream {

	public static void main(String[] args) {
		FileInputStream finput = null;
		BufferedInputStream binput = null;
		int c = 0;
		try {
			String path = D06BufferedInputStream.class.getResource("")
					.getPath();
			path = path.replace("/bin/", "/src/");
			finput = new FileInputStream(path + "D06BufferedInputStream.java");
			binput = new BufferedInputStream(finput, 1024);// 可以指定缓冲区的大小，也可以不指定
		} catch (FileNotFoundException e) {
			System.out.println("File is not found!");
			System.exit(-1);// 强行退出
		}

		try {
			System.out.println(binput.read());
			System.out.println(binput.read());
			System.out.println(binput.read());
			System.out.println(binput.read());
			System.out.println(binput.skip(50));
			binput.mark(50);// 标志第100个字节位置
			for (int i = 0; i < 10 && (c = binput.read()) != -1; i++) {
				System.out.print((char) c);
			}
			binput.reset();// 把当前位置又重置为刚才的100处
			System.out.println();
			for (int i = 0; i < 10 && (c = binput.read()) != -1; i++) {
				System.out.print((char) c);
			}
		} catch (IOException e) {
			System.out.println("文件操作失败！");
			System.exit(-1);
		}
		System.exit(0);

	}

}
