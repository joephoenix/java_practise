package phoenix.practise.third;

public class C07BinarySearch {

	public static int C07BinarySearch(int[] dataset, int data) {
		// 定义起始位置
		int beginIndex = 0;
		// 定义结束位置
		int endIndex = dataset.length - 1;
		// 定义中点
		int midIndex = -1;

		// 用二分法查找的数据必须是排好序的，
		// 因此只要比较第一个元素和最后一个元素就可以确定所查找的数据是否在数组中
		if (data < dataset[beginIndex] || data > dataset[endIndex]
				|| beginIndex > endIndex) {
			return -1;
		}
		// 开始查找
		while (beginIndex <= endIndex) {
			// 初始化中点
			midIndex = (beginIndex + endIndex) / 2;
			if (data < dataset[midIndex]) {
				// 如果查找的数据小于中点位置的数据，
				// 则把查找的结束位置定义在中点
				endIndex = midIndex - 1;
			} else if (data > dataset[midIndex]) {
				// 如果查找的数据小于中点位置的数据，
				// 则把查找的起始位置定义在中点
				beginIndex = midIndex + 1;
			} else {
				// 如果正好在中点，则返回中点
				// 返回查找到的数据的位置
				return midIndex;
			}
		}

		// 没找到，则返回-1
		return -1;
	}

	public static void main(String[] args) {
		// 测试数组
		int[] test1 = { 38, 48, 59, 61, 72, 99, 101 };
		System.out.print("你查找的数据位置在："
				+ C07BinarySearch.C07BinarySearch(test1, 59));

	}

}
