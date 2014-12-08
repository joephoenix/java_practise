package phoenix.DataStruct.Sort;

/**
 * 快速排序
 * 
 * 是一种采用分治法解决问题的一个典型应用。在很多编程语言中，对数组，列表进行的非稳定排序在内部实现中都使用的是快速排序。
 * 
 * 基本思想如下：
 * 
 * 1.对数组进行随机化。
 * 
 * 2.从数列中取出一个数作为中轴数(pivot)。
 * 
 * 3.将比这个数大的数放到它的右边，小于或等于它的数放到它的左边。
 * 
 * 4.再对左右区间重复第三步，直到各区间只有一个数。
 * 
 * @author chenxianxun
 *
 * @param <T>
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

	private final static int CUTOFF = 10;

	public void Sort(T[] array, int type) {
		switch (type) {
		case 1:
			Sort(array, 0, array.length - 1);
			break;
		case 2:
			SortWithThree(array, 0, array.length - 1);
			break;
		case 3:
			SortThreePartition(array, 0, array.length - 1);
			break;
		case 4:
			SortByBentley(array, 0, array.length - 1);
			break;
		default:
			Sort(array, 0, array.length - 1);
			break;
		}
	}

	/**
	 * Bentley&D. McIlroy 三分区快速排序的算法改进
	 * 
	 * @param array
	 * @param lo
	 * @param hi
	 */
	private void SortByBentley(T[] array, int lo, int hi) {
		// 如果子序列为1，则直接返回
		if (lo >= hi) {
			return;
		}
		// 对于小序列，直接采用插入排序替代
		if (hi - lo <= CUTOFF - 1) {
			insertSort(array, lo, hi);
			return;
		}
		// Bentley-McIlroy 3-way partitioning
		int i = lo, j = hi + 1;
		int p = lo, q = hi + 1;
		T v = array[lo];
		while (true) {
			while (Less(array[++i], v)) {
				if (i == hi) {
					break;
				}
			}
			while (Less(v, array[--j])) {
				if (j == lo) {
					break;
				}
			}

			// 交叉分区
			if (i == j && array[i].equals(v)) {
				swap(array, ++p, i);
			}
			if (i >= j) {
				break;
			}
			// 交换顺序
			swap(array, i, j);

			// 左右分区的比较
			if (array[i].equals(v)) {
				swap(array, ++p, i);
			}
			if (array[j].equals(v)) {
				swap(array, --q, j);
			}
		}
		// 把相等的元素交换到中间
		i = j + 1;
		for (int k = lo; k <= p; k++) {
			swap(array, k, j--);
		}
		for (int k = hi; k >= q; k--) {
			swap(array, k, i++);
		}
		// 左边的排序，使用递归
		SortByBentley(array, lo, j);
		// 邮编的排序，使用递归
		SortByBentley(array, i, hi);
	}

	/**
	 * 三分区快速排序
	 * 
	 * @param array
	 * @param lo
	 * @param hi
	 */
	private void SortThreePartition(T[] array, int lo, int hi) {
		// 如果子序列为1，则直接返回
		if (lo >= hi) {
			return;
		}
		// 对于小序列，直接采用插入排序替代
		if (hi - lo <= CUTOFF - 1) {
			insertSort(array, lo, hi);
			return;
		}
		// 三分区排序
		int lt = lo, i = lo + 1, gt = hi;
		T v = array[lo];
		while (i <= gt) {
			int cmp = array[i].compareTo(v);
			if (cmp < 0) {
				swap(array, lt++, i++);
			} else if (cmp > 0) {
				swap(array, i, gt--);
			} else {
				i++;
			}
		}
		// 左边序列排序
		SortThreePartition(array, lo, lt - 1);
		// 右边序列排序
		SortThreePartition(array, gt + 1, hi);
	}

	/**
	 * 普通的二分区快速排序，如果是小序列，则直接使用插入排序
	 * 
	 * @param array
	 * @param lo
	 * @param hi
	 */
	private void Sort(T[] array, int lo, int hi) {
		// 如果子序列为1，则直接返回
		if (lo >= hi) {
			return;
		}
		// 对于小序列，直接采用插入排序替代
		if (hi - lo <= CUTOFF - 1) {
			insertSort(array, lo, hi);
			return;
		}
		// 划分，划分完成之后，分为左右序列，
		// 左边所有元素小于array[index]，右边所有元素大于array[index]
		int index = Partition(array, lo, hi);

		// 对左边数组序列进行递归排序
		Sort(array, lo, index - 1);
		// 对右边数组序列进行递归排序
		Sort(array, index + 1, hi);
	}

	/**
	 * 三平均分区快速排序
	 * 
	 * @param array
	 * @param lo
	 * @param hi
	 */
	private void SortWithThree(T[] array, int lo, int hi) {
		// 如果子序列为1，则直接返回
		if (lo >= hi) {
			return;
		}
		// 采用三平均分区法查找中轴
		int m = medianOfThree(array, lo, lo + (hi - lo) / 2, hi);
		swap(array, lo, m);
		// 划分，划分完成之后，分为左右序列，左边所有元素小于array[index]，右边所有元素大于array[index]
		int index = Partition(array, lo, hi);

		// 左边序列递归排序
		SortWithThree(array, lo, index - 1);
		// 右边序列递归排序
		SortWithThree(array, index + 1, hi);

	}

	private int medianOfThree(T[] array, int lo, int ce, int hi) {
		return (Less(array[lo], array[ce]) ? (Less(array[ce], array[hi]) ? ce
				: Less(array[lo], array[hi]) ? hi : lo) : (Less(array[hi],
				array[ce]) ? ce : Less(array[hi], array[lo]) ? hi : lo));
	}

	private boolean Less(T t1, T t2) {
		return t1.compareTo(t2) < 0;
	}

	private int Partition(T[] array, int lo, int hi) {
		int i = lo, j = hi + 1;
		while (true) {
			// 从左至右扫描，如果碰到比基准元素array[lo]小，
			// 则该元素已经位于正确的分区，i自增，继续比较i+1；
			// 否则，退出循环，准备交换
			while (array[++i].compareTo(array[lo]) < 0) {
				if (i == hi) {
					break;
				}
			}

			// 从右自左扫描，如果碰到比基准元素array[lo]大，
			// 则该元素已经位于正确的分区，j自减，继续比较j-1
			// 否则，退出循环，准备交换
			while (array[--j].compareTo(array[lo]) > 0) {
				if (j == lo) {
					break;
				}
			}

			// 如果相遇，推出循环
			if (i >= j) {
				break;
			}
			swap(array, i, j);
		}

		// 交换左a[i],a[j]右两个元素，交换完后他们都位于正确的分区
		swap(array, lo, j);
		// 返回扫描相遇的位置点
		return j;
	}

	/**
	 * 交换数组中两个数字的位置
	 * 
	 * @param array
	 * @param i
	 * @param min
	 */
	private void swap(T[] array, int i, int min) {
		T temp = array[i];
		array[i] = array[min];
		array[min] = temp;
	}

}
