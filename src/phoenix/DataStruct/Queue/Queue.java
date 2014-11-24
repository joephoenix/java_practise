package phoenix.DataStruct.Queue;

public class Queue<T> {

	class Node {
		public T item;
		public Node next;

		public T getItem() {
			return item;
		}

		public void setItem(T item) {
			this.item = item;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

	private Node first = null;
	private Node last = null;
	private int number = 0;

	private boolean isEmpty() {
		if (first == null || last == null) {
			return true;
		} else {
			return false;
		}
	}

	public void Enqueue(T item) {
		if (isEmpty()) {
			last = new Node();
			last.item = item;
			first = last;
		} else {
			Node oldlast = last;
			last = new Node();
			last.item = item;
			oldlast.setNext(last);
		}
		number++;
	}

	public T dequeue() {
		if (isEmpty()) {
			System.out.println("the queue is empty, please add items!");
			return null;
		} else {
			T temp = first.item;
			first = first.getNext();
			number--;
			if (isEmpty()) {
				last = null;
				System.out.println("the queue is empty, please add items!");
			}
			return temp;
		}
	}

	public static void main(String[] args) {
		Queue<String> qe = new Queue<String>();
		qe.dequeue();
		qe.Enqueue("Jan");
		qe.Enqueue("Feb");
		qe.Enqueue("Mar");
		System.out.println(qe.dequeue());
		System.out.println(qe.dequeue());
		qe.Enqueue("Apr");
		qe.Enqueue("May");
		System.out.println(qe.dequeue());
		System.out.println(qe.dequeue());
		System.out.println(qe.dequeue());
		System.out.println(qe.dequeue());
		System.out.println("there is " + qe.number + " items in the queue");
		qe.Enqueue("Jun");
		qe.Enqueue("Jul");
		qe.Enqueue("Aug");
		qe.Enqueue("Sep");
		qe.Enqueue("Oct");
		qe.Enqueue("Nov");
		qe.Enqueue("Dec");
		System.out.println(qe.dequeue());
		System.out.println("there is " + qe.number + " items in the queue");
	}
}
