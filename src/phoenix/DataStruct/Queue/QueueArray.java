package phoenix.DataStruct.Queue;

public class QueueArray {
	String[] items;
	int head = 0;
	int tail = 0;

	public QueueArray(int capacity) {
		items = new String[capacity];
	}

	public void zoom(int capacity) {
		String[] temp = new String[capacity];
		int index = 0;
		for (int i = head; i < tail; i++) {
			temp[index] = items[i];
			index++;
		}
		items = temp;
	}

	public void Enqueue(String _item) {
		if ((tail - head + 1) == items.length) {
			zoom(items.length * 2);
			head = 0;
		}
		items[tail++] = _item;
	}

	public String Dequeue() {
		String temp = items[head];
		if (temp == null) {
			System.out.println("the queue is empty, please enter items!");
			return "empty";
		}
		items[head] = null;
		head++;
		if (head > 0 && (tail - head + 1) == items.length / 4) {
			zoom(items.length / 2);
			tail = tail - head;
			head = 0;
		}
		return temp;
	}

	public static void main(String[] args) {
		QueueArray qa = new QueueArray(10);
		qa.Enqueue("Jan");
		qa.Enqueue("Feb");
		qa.Enqueue("Mar");
		qa.Enqueue("Apr");
		qa.Enqueue("May");
		qa.Enqueue("Jun");
		qa.Enqueue("Jul");
		qa.Enqueue("Aug");
		qa.Enqueue("Sep");
		qa.Enqueue("Oct");
		qa.Enqueue("Nov");
		System.out.println(qa.Dequeue() + "   " + qa.items.length);
		qa.Enqueue("Dec");
		System.out.println(qa.Dequeue() + "   " + qa.items.length);
		System.out.println(qa.Dequeue() + "   " + qa.items.length);
		System.out.println(qa.Dequeue() + "   " + qa.items.length);
		System.out.println(qa.Dequeue() + "   " + qa.items.length);
		System.out.println(qa.Dequeue() + "   " + qa.items.length);
		System.out.println(qa.Dequeue() + "   " + qa.items.length);
		System.out.println(qa.Dequeue() + "   " + qa.items.length);
		System.out.println(qa.Dequeue() + "   " + qa.items.length);
		System.out.println(qa.Dequeue() + "   " + qa.items.length);
		qa.Enqueue("spr");
		qa.Enqueue("sum");
		qa.Enqueue("Aut");
		qa.Enqueue("Win");
		System.out.println(qa.Dequeue() + "   " + qa.items.length);
		System.out.println(qa.Dequeue() + "   " + qa.items.length);
		System.out.println(qa.Dequeue() + "   " + qa.items.length);
		System.out.println(qa.Dequeue() + "   " + qa.items.length);
		System.out.println(qa.Dequeue() + "   " + qa.items.length);
		System.out.println(qa.Dequeue() + "   " + qa.items.length);
		System.out.println(qa.Dequeue() + "   " + qa.items.length);
		qa.Enqueue("Jan");
		qa.Enqueue("Feb");
		qa.Enqueue("Mar");
		qa.Enqueue("Apr");
		qa.Enqueue("May");
		qa.Enqueue("Jun");
		qa.Enqueue("Jul");
		qa.Enqueue("Aug");
		qa.Enqueue("Sep");
		for (int i = qa.head; i < qa.tail; i++) {
			System.out.print(" " + qa.items[i] + " ");
		}
	}

}
