package phoenix.DataStruct.Sort;

public class HeapSort<T extends Comparable<T>> {

	private T[] pq;
	private int N;

	public void createHeap() {
		for (int k = N / 2; k >= 1; k--) {
			sink(pq, k, N);
		}
		while (N > 1) {
			Swap(pq, 1, N--);
			sink(pq, 1, N);
		}
	}

	/**
	 * 在末尾插入一个元素
	 * 
	 * @param s
	 */
	public void Insert(T s) {
		pq[++N] = s;
		swin(N);
	}

	/**
	 * 删除一个最大的元素
	 * 
	 * @return
	 */
	public T delMax() {
		// 根元素从1开始，0不存放内容
		T max = pq[1];
		// 交换最后一个元素和根节点的元素
		Swap(pq, 1, N--);
		// 对根节点自上而下重新创建二叉堆
		sink(1);
		// 最后一个元素置为空
		pq[N + 1] = null;
		return max;
	}

	/**
	 * 自下而上的二叉堆排序
	 * 
	 * 在二叉堆中添加一个新元素，然后与父节点比较，如果大于父节点，则上游
	 * 
	 * @param k
	 */
	private void swin(int k) {
		while (k > 1 && pq[k].compareTo(pq[k / 2]) > 0) {
			Swap(pq, k, k / 2);
		}
	}

	/**
	 * 自上而下的二叉堆排序
	 * 
	 * @param k
	 */
	private void sink(int k) {
		while (2 * k < N) {
			int j = 2 * k;
			// 比较左右子节点，取得较大那个作为比较的元素
			if (pq[j].compareTo(pq[j + 1]) < 0) {
				j++;
			}
			// 如果父节点比这个较大的元素还要大，则表示满足要求，跳出循环
			if (pq[k].compareTo(pq[j]) > 0) {
				break;
			}
			// 否则，则把父节点和这个较大的子节点交换
			Swap(pq, k, j);
			k = j;
		}
	}

	/**
	 * 
	 * @param pq
	 * @param k
	 * @param N
	 */
	private void sink(T[] pq, int k, int N) {
		while (2 * k < N) {
			int j = 2 * k;
			if (pq[j].compareTo(pq[j + 1]) < 0) {
				j++;
			}
			if (pq[k].compareTo(pq[j]) > 0) {
				break;
			}
			Swap(pq, k, j);
			k = j;
		}
	}

	/**
	 * 交换数组中两个数字的位置
	 * 
	 * @param array
	 * @param i
	 * @param min
	 */
	private void Swap(T[] array, int i, int min) {
		T temp = array[i];
		array[i] = array[min];
		array[min] = temp;
	}
}
