package phoenix.DataStruct.Sort;

public class MergeSort<T extends Comparable<T>> {

	private T[] aux;

	private void Merge(T[] array, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			aux[k] = array[k];
		}
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				array[k] = aux[j++];
			} else if (j > hi) {
				array[k] = aux[i++];
			} else if (aux[i].compareTo(aux[j]) < 0) {
				array[k] = aux[i++];
			} else {
				array[k] = aux[j++];
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void Sort(T[] array) {
		aux = (T[]) new Object[array.length];
		Sort(array, 0, array.length - 1);
	}

	private void Sort(T[] array, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		Sort(array, lo, mid);
		Sort(array, mid + 1, hi);
		Merge(array, lo, mid, hi);
	}
}
