package phoenix.DataStruct;

import phoenix.DataStruct.Sort.MergeSort;
import phoenix.DataStruct.Sort.QuickSort;
import phoenix.DataStruct.Sort.Sort;

public class SortTest {

	public static void main(String[] args) {
		Integer[] array1 = { 1, 3, 1, 4, 2, 4, 2, 3, 2, 4, 7, 6, 6, 7, 5, 5, 7,
				7, 9, -1, -2, 4, 8 };
		Integer[] array2 = { 1, 3, 1, 4, 2, 4, 2, 3, 2, 4, 7, 6, 6, 7, 5, 5, 7,
				7, 9, -1, -2, 4, 8 };
		Integer[] array3 = { 1, 3, 1, 4, 2, 4, 2, 3, 2, 4, 7, 6, 6, 7, 5, 5, 7,
				7, 9, -1, -2, 4, 8 };
		Integer[] array4 = { 1, 3, 1, 4, 2, 4, 2, 3, 2, 4, 7, 6, 6, 7, 5, 5, 7,
				7, 9, -1, -2, 4, 8 };
		Integer[] array5 = { 1, 3, 1, 4, 2, 4, 2, 3, 2, 4, 7, 6, 6, 7, 5, 5, 7,
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
		System.out.println("Before mergeSort");
		printArray(array4);
		MergeSort<Integer> ms = new MergeSort<Integer>();
		ms.Sort(array4);
		System.out.println("After mergeSort:");
		printArray(array4);
		System.out.println("Before quickSort");
		printArray(array5);
		QuickSort<Integer> qs = new QuickSort<Integer>();
		qs.Sort(array5, 4);
		System.out.println("After quickSort:");
		printArray(array5);
	}

	protected static void printArray(Integer[] array) {
		for (int i : array) {
			System.out.print(" " + i + " ");
		}
		System.out.println();
	}
}
