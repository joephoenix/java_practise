package phoenix.practise.forth;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class D03TestFileOutputStream {

	public static void main(String[] args) {
		int b = 0;
		long num = 0;
		FileInputStream finput = null;
		FileOutputStream foutput = null;
		try {
			finput = new FileInputStream(
					"C:/ProjectFolder/Eclipse_projects/java_practise"
							+ "/src/phoenix/practise/forth/D03TestFileOutputStream.java");
		} catch (FileNotFoundException e) {
			System.out.println("File TFileOutputStream.java is not found!");
			System.exit(-1);
		}
		try {
			foutput = new FileOutputStream("C:/TDDOWNLOAD/CopyFile.java");
		} catch (FileNotFoundException e) {
			System.out.println("File TFileOutputStreamcopy is not found!");
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
