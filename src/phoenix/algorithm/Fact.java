package phoenix.algorithm;

/**
 * 通过二分查找法查找指定数字的位置
 * 
 * @author joephoenix
 * 
 */
public class Fact {

	public static int binarySearch(int[] dataset, int data) {
		int beginIndex = 0;
		int endIndex = dataset.length - 1;
		int midIndex = -1;
		if (data < dataset[beginIndex] || data > dataset[endIndex]
				|| beginIndex > endIndex) {
			return -1;
		}
		while (beginIndex <= endIndex) {
			midIndex = (beginIndex + endIndex) / 2;
			if (data < dataset[midIndex]) {
				endIndex = midIndex - 1;
			} else if (data > dataset[midIndex]) {
				beginIndex = midIndex + 1;
			} else {
				return midIndex;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] test1 = { 38, 48, 59, 61, 72, 99, 101, 300 };
		System.out.println("the position of the "
				+ "number which you search is " + binarySearch(test1, 72));
	}

}
