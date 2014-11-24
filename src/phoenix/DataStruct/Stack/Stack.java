package phoenix.DataStruct.Stack;

public class Stack<T> {

	private class Node {
		private T Item;
		private Node next;

		public T getItem() {
			return Item;
		}

		public void setItem(T item) {
			Item = item;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

	private Node first = null;
	private int number = 0;

	/**
	 * 压入栈
	 * 
	 * @param value
	 */
	public void push(T value) {
		Node oldFirst = first;
		first = new Node();
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

	public static void main(String[] args) {
		Stack<String> st = new Stack<String>();
		st.push("Jan");
		st.push("Feb");
		st.push("Mar");
		st.push("Apr");
		st.push("May");
		st.push("Jul");
		st.push("Jun");
		st.push("Aug");
		st.push("Sep");
		st.push("Oct");
		st.push("Nov");
		st.push("Dec");
		System.out.println("the number is " + st.number);
		Stack<String>.Node ft = st.first;
		while (ft != null) {
			System.out.println("value is " + ft.getItem());
			ft = ft.getNext();
		}
		System.out.println(st.pop() + ", the number is " + st.number);
	}
}
