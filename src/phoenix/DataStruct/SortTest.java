package phoenix.DataStruct;

import phoenix.DataStruct.Sort.HeapSort;
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
		String[] array6 = { "U", "N", "I", "T", "S", "T", "A", "T", "E", "O",
				"F", "A", "M", "E", "R", "I", "C", "A", "N" };
		Sort<Integer> ss = new Sort<Integer>();
		// 选择排序测试
		System.out.println("Before SelectionSort:");
		ss.printArray(array1);
		ss.selectSort(array1);
		System.out.println("After SelectionSort:");
		ss.printArray(array1);
		// 插入排序测试
		System.out.println("Before InsertionSort");
		ss.printArray(array2);
		ss.insertSort(array2);
		System.out.println("After InsertionSort:");
		ss.printArray(array2);
		// 希尔排序测试
		System.out.println("Before ShellSort");
		ss.printArray(array3);
		ss.shellSort(array3);
		System.out.println("After ShellSort:");
		ss.printArray(array3);
		// 合并排序测试
		MergeSort<Integer> ms = new MergeSort<Integer>();
		System.out.println("Before mergeSort");
		ms.printArray(array4);
		ms.Sort(array4);
		System.out.println("After mergeSort:");
		ms.printArray(array4);
		// 快速排序测试
		QuickSort<Integer> qs = new QuickSort<Integer>();
		System.out.println("Before quickSort");
		qs.printArray(array5);
		qs.Sort(array5, 4);
		System.out.println("After quickSort:");
		qs.printArray(array5);
		// 堆排序测试
		HeapSort<String> hs = new HeapSort<String>();
		System.out.println("Before quickSort");
		hs.printArray(array6);
		hs.Sort(array6);
		System.out.println("After quickSort:");
		hs.printArray(array6);
	}
}
