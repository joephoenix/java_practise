package phoenix.DataStruct.Sort;

public class Sort<T extends Comparable<T>> {

	/**
	 * 
	 * 选择排序很简单，他的步骤如下： 从左至右遍历，找到最小(大)的元素，然后与第一个元素交换。
	 * 从剩余未排序元素中继续寻找最小（大）元素，然后与第二个元素进行交换。 以此类推，直到所有元素均排序完毕。
	 * 之所以称之为选择排序，是因为每一次遍历未排序的序列我们总是从中选择出最小的元素。
	 * 
	 * 最好的复杂度是N， 平均复杂度是N的2次幂，最坏的复杂度是N的2次幂
	 * 
	 * @param array
	 */
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

	public void selectSort(T[] array, int i, int j) {
		for (int x = i; x < j; x++) {
			int min = x;
			for (int y = x + 1; y < j; y++) {
				if (array[min].compareTo(array[y]) > 0) {
					min = y;
				}
			}
			swap(array, x, min);
		}
	}

	/**
	 * 插入排序也是一种比较直观的排序方式。可以以我们平常打扑克牌为例来说明，
	 * 假设我们那在手上的牌都是排好序的，那么插入排序可以理解为我们每一次将摸到的牌 ，和手中的牌从左到右依次进行对比，如果找到合适的位置则直接插入。
	 * 具体的步骤为： 从第一个元素开始，该元素可以认为已经被排序 取出下一个元素，在已经排序的元素序列中从后向前扫描
	 * 如果该元素小于前面的元素（已排序），则依次与前面元素进行比较如果小于则交换，直到找到大于该元素的就则停止；
	 * 如果该元素大于前面的元素（已排序），则重复步骤2 重复步骤2~4 直到所有元素都排好序 。
	 * 
	 * 复杂度是N的2次幂
	 * 
	 * @param array
	 */
	public void insertSort(T[] array) {
		int n = array.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j].compareTo(array[j - 1]) < 0) {
					swap(array, j, j - 1);
				} else {
					break;
				}
			}
		}
	}

	public void insertSort(T[] array, int x, int y) {
		for (int i = x; i < y; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j].compareTo(array[j - 1]) < 0) {
					swap(array, j, j - 1);
				} else {
					break;
				}
			}
		}
	}

	/**
	 * 希尔排序也称之为递减增量排序，他是对插入排序的改进。
	 * 
	 * 希尔排序通过将待比较的元素划分为几个区域来提升插入排序的效率。
	 * 这样可以让元素可以一次性的朝最终位置迈进一大步，然后算法再取越来越小的步长进行排序，
	 * 最后一步就是步长为1的普通的插入排序的，但是这个时候，整个序列已经是近似排好序的，所以效率高。
	 * 
	 * Shell's 序列: N/2 , N/4 , ..., 1 (重复除以2);
	 * 
	 * Hibbard's 序列: 1, 3, 7, ..., 2k - 1 ;
	 * 
	 * Knuth's 序列: 1, 4, 13, ..., (3k - 1) / 2 ;该序列是本文代码中使用的序列。
	 * 
	 * 已知最好的序列是 Sedgewick's (Knuth的学生，Algorithems的作者)的序列: 1, 5, 19, 41, 109,
	 * .... 该序列由下面两个表达式交互获得: * 1, 19, 109, 505, 2161,….., 9(4k – 2k) + 1, k = 0,
	 * 1, 2, 3,… 5, 41, 209, 929, 3905,…..2k+2 (2k+2 – 3 ) + 1, k = 0, 1, 2, 3,
	 * …
	 * 
	 * 
	 * “比较在希尔排序中是最主要的操作，而不是交换。”
	 * 
	 * 用这样步长的希尔排序比插入排序和堆排序都要快，甚至在小数组中比快速排序还快，但是在涉及大量数据时希尔排序还是比快速排序慢。
	 * 
	 * 2. 希尔排序的分析比较复杂，使用Hibbard’s 递减步长序列的时间复杂度为O(N3/2)，
	 * 
	 * 平均时间复杂度大约为O(N5/4) ,具体的复杂度目前仍存在争议。
	 * 
	 * 3. 实验表明，对于中型的序列( 万)，希尔排序的时间复杂度接近最快的排序算法的时间复杂度nlogn。
	 * 
	 * 最好的复杂度是N，平均的复杂度是nlog2n 或 N的3/2次幂， 最坏的复杂度（依赖于增量递减序列），目前最好的是 nlog2n
	 * 
	 * @param array
	 */
	public void shellSort(T[] array) {
		int n = array.length;
		int h = 1;
		// 初始化步长
		while (h < n / 3) {
			h = h * 3 + 1;
		}
		//
		while (h >= 1) {
			for (int i = 1; i < n; i++) {
				for (int j = i; j >= h; j = j - h) {
					if (array[j].compareTo(array[j - h]) < 0) {
						swap(array, j, j - h);
					} else {
						break;
					}
				}
			}
			// 步长除3递减
			h = h / 3;
		}

	}

	private void swap(T[] array, int i, int min) {
		T temp = array[i];
		array[i] = array[min];
		array[min] = temp;
	}
}
