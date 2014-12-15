package phoenix.patterns;

import phoenix.patterns.p16Iterator.ConcreteList;
import phoenix.patterns.p16Iterator.IListCollection;
import phoenix.patterns.p16Iterator.Iterator;

public class IteratorTest {

	public static void main(String[] args) {
		Iterator<String> iterator;
		String[] testString = { "A", "B", "C", "D", "E" };
		IListCollection<String> list = new ConcreteList<String>(testString);
		iterator = list.GetIterator();

		while (iterator.moveNext()) {
			String i = iterator.getCurrent();
			System.out.println(i);
			iterator.next();
		}
	}

}
