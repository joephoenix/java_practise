package phoenix.patterns.p05Builder;

import java.util.ArrayList;
import java.util.List;

public class Computer {

	private List<String> parts = new ArrayList<String>();

	public void add(String part) {
		parts.add(part);
	}

	public void show() {
		System.out.println("-----computer begin building");
		for (String part : parts) {
			System.out.println("**Composite the " + part + " depart");
		}
		System.out.println("-----computer composite completely");
	}

}
