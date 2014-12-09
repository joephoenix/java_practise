package phoenix.patterns.visitor;

import java.util.ArrayList;
import java.util.Random;

public class ObjectStructure {

	private ArrayList<Element> elements = new ArrayList<Element>();

	public ArrayList<Element> getElements() {
		return elements;
	}

	public ObjectStructure() {
		Random ran = new Random();
		for (int i = 0; i < 6; i++) {
			int rannum = ran.nextInt(10);
			if (rannum < 5) {
				elements.add(new ElementA());
			} else {
				elements.add(new ElementB());
			}
		}
	}
}
