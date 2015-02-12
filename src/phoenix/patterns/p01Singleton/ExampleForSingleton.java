package phoenix.patterns.p01Singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExampleForSingleton {

	public static void main(String[] args) throws IOException {
		Process p = Runtime.getRuntime().exec(
				"C:/windows/system32/ping.exe " + "www.baidu.com");

		// get process input stream and put it into buffered
		BufferedReader input = new BufferedReader(new InputStreamReader(
				p.getInputStream()));

		// print the command result
		String line;
		while ((line = input.readLine()) != null) {
			System.out.println(line);
		}

		// close the stream
		input.close();
	}

}
