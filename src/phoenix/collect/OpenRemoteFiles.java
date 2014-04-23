package phoenix.collect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class OpenRemoteFiles {

	/**
	 * 读取远程文件主方法
	 * 
	 * @param romatefilename
	 */
	public void readRomateFile(String romatefilename) {
		URL urlfile;
		BufferedReader in;
		PrintWriter out;
		String content = "";
		String inputLine;
		try {
			urlfile = new URL(romatefilename);
			in = new BufferedReader(new InputStreamReader(urlfile.openStream()));
			inputLine = in.readLine();
			while (inputLine != null) {
				content += inputLine;
				inputLine = in.readLine();
			}
			System.out.println(content);
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		OpenRemoteFiles of = new OpenRemoteFiles();
		// 替换正式的远程文件路径字符串
		String romatefilename = "file:////IPADDRESS/share/test.txt";
		of.readRomateFile(romatefilename);
	}

}
