package phoenix.DataStruct;

import phoenix.DataStruct.Sort.Sort;

public class SortTest {

	public static void main(String[] args) {
		Integer[] array1 = { 1, 3, 1, 4, 2, 4, 2, 3, 2, 4, 7, 6, 6, 7, 5, 5, 7,
				7, 9, -1, -2, 4, 8 };
		Integer[] array2 = { 1, 3, 1, 4, 2, 4, 2, 3, 2, 4, 7, 6, 6, 7, 5, 5, 7,
				7, 9, -1, -2, 4, 8 };
		Integer[] array3 = { 1, 3, 1, 4, 2, 4, 2, 3, 2, 4, 7, 6, 6, 7, 5, 5, 7,
				7, 9, -1, -2, 4, 8 };
		System.out.println("Before SelectionSort:");
		printArray(array1);
		Sort<Integer> sortA = new Sort<Integer>();
		sortA.selectSort(array1);
		System.out.println("After SelectionSort:");
		printArray(array1);
		System.out.println("Before InsertionSort");
		printArray(array2);
		sortA.insertSort(array2);
		System.out.println("After InsertionSort:");
		printArray(array2);
		System.out.println("Before ShellSort");
		printArray(array3);
		sortA.shellSort(array3);
		System.out.println("After ShellSort:");
		printArray(array3);
	}

	protected static void printArray(Integer[] array) {
		for (int i : array) {
			System.out.print(" " + i + " ");
		}
		System.out.println();
	}
}
