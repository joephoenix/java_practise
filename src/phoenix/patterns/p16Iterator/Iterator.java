package phoenix.patterns.p16Iterator;

public interface Iterator<T> {
	boolean moveNext();

	T getCurrent();

	void next();

	void reset();
}
