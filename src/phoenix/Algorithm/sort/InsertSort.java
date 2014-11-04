package phoenix.Algorithm.sort;

public class InsertSort implements Sort {

	@Override
	public void sort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = i; (j > 0) && data[j] < data[j - 1]; j--) {
				SortUtil.swap(data, j, j - 1);
			}
		}
	}

}
