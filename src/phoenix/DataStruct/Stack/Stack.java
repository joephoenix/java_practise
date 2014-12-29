package phoenix.DataStruct.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {

	private class Node<T> {
		private T item;
		private Node<T> next;

		public T getItem() {
			return item;
		}

		public void setItem(T item) {
			this.item = item;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}
	}

	private Node<T> first = null;
	private int number = 0;

	/**
	 * 压入栈
	 * 
	 * @param value
	 */
	public void push(T value) {
		Node<T> oldFirst = first;
		first = new Node<T>();
		first.setItem(value);
		first.setNext(oldFirst);
		number++;
	}

	/**
	 * 弹出栈
	 * 
	 * @return
	 */
	public T pop() {
		T item = first.getItem();
		first = first.getNext();
		number--;
		return item;
	}

	@Override
	public Iterator<T> iterator() {
		return new ListIterator<T>(first);
	}

	private class ListIterator<T> implements Iterator<T> {
		private Node<T> current;

		public ListIterator(Node<T> first) {
			current = first;
		}

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T t = current.item;
			current = current.next;
			return t;
		}
	}
}
