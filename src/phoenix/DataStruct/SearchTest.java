package phoenix.DataStruct;

import phoenix.DataStruct.Search.BinarySearchTree;
import phoenix.DataStruct.Search.RedBlackTree;

public class SearchTest {
	public static void main(String[] args) {
		SearchTest st = new SearchTest();
		// st.bstTest();
		st.rbtTest();
	}

	// 二叉查找树的测试
	public void bstTest() {
		BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
		Integer[] keys = { 2, 4, 6, 8, 5, 3, 1, 7, 9 };
		String[] vals = { "blue", "jan", "july", "sixtytwo", "sample", "proof",
				"fool", "sep", "cancer" };
		for (int i = 0; i < keys.length; i++) {
			bst.put(keys[i], vals[i]);
		}
		bst.put(20, "green");
		bst.delete(7);
		System.out.println(bst.get(2));
	}

	// 红黑树的测试
	public void rbtTest() {
		RedBlackTree<Integer, String> rbt = new RedBlackTree<Integer, String>();
		Integer[] keys = { 7, 44, 16, 88, 55, 4, 16, 27, 39, 2, 40, 33, 22,
				56, 14 };
		String[] vals = { "blue", "jan", "july", "sixtytwo", "sample", "proof",
				"fool", "sep", "cancer", "slimy", "fliter", "solar", "scorpio",
				"antares", "december" };
		for (int j = 0; j < keys.length; j++) {
			rbt.put(keys[j], vals[j]);
		}
		rbt.put(10, "Gemini");
		System.out.println(rbt.getRoot().getKey() + ":"
				+ rbt.getRoot().getValue() + ":" + rbt.getRoot().number);
		System.out.println(rbt.getMin().getKey() + ":"
				+ rbt.getMin().getValue() + ":" + rbt.getMin().number);
		System.out.println(rbt.getMax().getKey() + ":"
				+ rbt.getMax().getValue() + ":" + rbt.getMax().number);
	}
}
