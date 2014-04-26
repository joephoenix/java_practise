package phoenix.practise.forth;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class D03FileOutputStream {

	public static void main(String[] args) {
		int b = 0;
		long num = 0;
		FileInputStream finput = null;
		FileOutputStream foutput = null;
		try {
			String path = D03FileOutputStream.class.getResource("").getPath();
			path = path.replace("/bin/", "/src/");
			finput = new FileInputStream(path + "D03FileOutputStream.java");
		} catch (FileNotFoundException e) {
			System.out.println("File TFileOutputStream.java is not found!");
			System.exit(-1);
		}
		try {
			String path = D03FileOutputStream.class.getResource("").getPath();
			path = path.replace("/bin/", "/src/");
			foutput = new FileOutputStream(path + "D03Clone.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File D03Clone is not found!");
			System.exit(-1);
		}
		try {
			while ((b = finput.read()) != -1) {
				System.out.print((char) b);
				foutput.write(b);
				num++;
			}
			System.out.println();
			System.out.println("The number char of this file is  " + num);
			finput.close();
			foutput.flush();
			foutput.close();
		} catch (IOException ioex2) {
			System.out.println("file read or write failed!");
			System.exit(-1);
		}
		System.exit(0);
	}
}
