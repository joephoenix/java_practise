package phoenix.DataStruct;

import phoenix.DataStruct.Sort.Sort;

public class SortTest {

	public static void main(String[] args) {
		Integer[] array = { 1, 3, 1, 4, 2, 4, 2, 3, 2, 4, 7, 6, 6, 7, 5, 5, 7,
				7 };
		System.out.println("Before SelectionSort:");
		printArray(array);
		Sort<Integer> sortarray = new Sort<Integer>();
		sortarray.selectSort(array);
		System.out.println("After SelectionSort:");
		printArray(array);
	}

	protected static void printArray(Integer[] array) {
		for (int i : array) {
			System.out.print(" " + i + " ");
		}
		System.out.println();
	}
}
