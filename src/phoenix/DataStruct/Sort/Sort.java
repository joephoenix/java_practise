package phoenix.DataStruct.Sort;

public class Sort<T extends Comparable<T>> {

	public void selectSort(T[] array) {
		int n = array.length;

		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (array[min].compareTo(array[j]) > 0) {
					min = j;
				}
			}
			swap(array, i, min);
		}

	}

	private void swap(T[] array, int i, int min) {
		T temp = array[i];
		array[i] = array[min];
		array[min] = temp;
	}
}
