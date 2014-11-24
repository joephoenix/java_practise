package phoenix.DataStruct.Stack;

public class StackArray {
	String[] items;
	int number = 0;

	public StackArray(int capacity) {
		items = new String[capacity];
	}

	private void zoomon(int capacity) {
		String[] temp = new String[capacity];
		for (int i = 0; i < items.length; i++) {
			temp[i] = items[i];
		}
		items = temp;
	}

	private void zoomin(int capacity) {
		String[] temp = new String[capacity];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = items[i];
		}
		items = temp;
	}

	public void push(String _item) {
		if (number == items.length) {
			zoomon(2 * items.length);
		}
		items[number++] = _item;

	}

	public String pop() {
		String temp = items[--number];
		items[number] = "";
		if (number > 0 && number == items.length / 4) {
			zoomin(items.length / 2);
		}
		return temp;
	}

	public static void main(String[] args) {
		StackArray sa = new StackArray(10);
		sa.push("Jan");
		sa.push("Feb");
		sa.push("Mar");
		sa.push("Apr");
		sa.push("May");
		sa.push("Jul");
		sa.push("Jun");
		sa.push("Aug");
		sa.push("Sep");
		sa.push("Oct");
		sa.push("Nov");
		sa.push("Dec");
		System.out.println("the stack's length is " + sa.items.length);
		System.out.print(sa.pop());
		System.out.print(" " + sa.pop());
		System.out.print(" " + sa.pop());
		System.out.print(" " + sa.pop());
		System.out.print(" " + sa.pop());
		System.out.print(" " + sa.pop());
		System.out.print(" " + sa.pop());
		System.out.print(" " + sa.pop());
		System.out.print(" " + sa.pop());
		System.out.print(" " + sa.pop());
		System.out.print(" " + sa.pop());
		System.out.println();
		System.out.println("the stack's length is " + sa.items.length);
	}
}
