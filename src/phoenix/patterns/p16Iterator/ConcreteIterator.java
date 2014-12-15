package phoenix.patterns.p16Iterator;

import phoenix.patterns.p16Iterator.Iterator;

public class ConcreteIterator<T> implements Iterator<T> {

	private ConcreteList<T> _list;
	private int _index;

	public ConcreteIterator(ConcreteList<T> list) {
		_list = list;
		_index = 0;
	}

	@Override
	public boolean moveNext() {
		if (_index < _list.getLength()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public T getCurrent() {
		return _list.getElement(_index);
	}

	@Override
	public void next() {
		if (_index < _list.getLength()) {
			_index++;
		}
	}

	@Override
	public void reset() {
		_index = 0;
	}

}
