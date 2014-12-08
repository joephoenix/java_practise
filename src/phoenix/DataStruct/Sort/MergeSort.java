package phoenix.DataStruct.Sort;

/**
 * 合并排序：
 * 
 * 通过将两个有序的序列合并为一个大的有序的序列的方式来实现排序。合并排序是一种典型的分治算法：首先将序列分为两部分，
 * 然后对每一部分进行循环递归的排序，然后逐个将结果进行合并。
 * 
 * 合并操作步骤如下：
 * 
 * 1.申请空间，使其大小为两个已经排序序列之和，然后将待排序数组复制到该数组中。
 * 
 * 2.设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * 
 * 3.比较复制数组中两个指针所指向的元素，选择相对小的元素放入到原始待排序数组中，并移动指针到下一位置
 * 
 * 4.重复步骤3直到某一指针达到序列尾
 * 
 * 5.将另一序列剩下的所有元素直接复制到原始数组末尾
 * 
 * 合并排序和快速排序一样都是时间复杂度为nlgn的算法，但是和快速排序相比，合并排序是一种稳定性排序，也就是说排序关键字相等的两个元素在整个序列排序的前后，
 * 相对位置不会发生变化，这一特性使得合并排序是稳定性排序中效率最高的一个，他的唯一缺点是，需要利用额外的N的空间来进行排序。
 * 
 * @author chenxianxun
 *
 * @param <T>
 */
public class MergeSort<T extends Comparable<T>> extends Sort<T> {

	private T[] aux;
	private final int CUTOFF = 7;// 采用插入排序的阀值

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
		aux = (T[]) new Comparable[array.length];
		Sort(array, 0, array.length - 1);
	}

	private void Sort(T[] array, int lo, int hi) {
		// 如果下标大于上标，则返回
		if (lo >= hi) {
			return;
		}
		if (hi <= lo + CUTOFF - 1) {
			selectSort(array, lo, hi);
		}
		// 平分数组
		int mid = lo + (hi - lo) / 2;
		// 循环对左侧数组的值排序，递归调用
		Sort(array, lo, mid);
		// 循环对右侧数组的值排序，递归调用
		Sort(array, mid + 1, hi);
		// 当已排好序的左侧的序列的最大值<=右侧序列的最小值的时候，表示整个序列已经排好序了
		if (array[mid].compareTo(array[mid + 1]) <= 0) {
			return;
		}
		// 合并排好序的数组
		Merge(array, lo, mid, hi);
	}
}
