package phoenix.practise.third;

public class C01Fact {

	public static int binarySearch(int[] dataset, int data) {
		int beginIndex = 0;
		int endIndex = dataset.length - 1;
		int midIndex = -1;
		if (data < dataset[beginIndex] || data > dataset[endIndex]
				|| beginIndex > endIndex) {
			// 用二分法查找的数据必须是排好序的，
			// 因此只要比较第一个元素和最后一个元素就可以确定所查找的数据是否在数组中
			return -1;
		}
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
				return midIndex;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// 测试数组
		int[] test1 = { 38, 48, 59, 61, 72, 99, 101, 105 };
		// 调用方法
		System.out.println("你查找的数据位于第" + (C01Fact.binarySearch(test1, 61) + 1)
				+ "个位置");
	}

}
