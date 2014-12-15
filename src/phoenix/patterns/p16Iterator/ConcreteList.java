package phoenix.patterns.p16Iterator;

public class ConcreteList<T> implements IListCollection<T> {

	T[] collection;
	public int length;

	public int getLength() {
		return collection.length;
	}

	public ConcreteList(T[] list) {
		collection = list;
	}

	@Override
	public Iterator<T> GetIterator() {
		return new ConcreteIterator<T>(this);
	}

	public T getElement(int index) {
		return collection[index];
	}

}
