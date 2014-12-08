package phoenix.DataStruct;

import phoenix.DataStruct.Search.BinarySearchTree;

public class SearchTest {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		Integer[] keys = { 2, 4, 6, 8, 5, 3, 1, 7, 9 };
		Integer[] vals = { 100, 300, 51, 62, 33, 36, 78, 57, 4251 };
		for (int i = 0; i < keys.length; i++) {
			bst.put(keys[i], vals[i]);
		}
		bst.put(20, 40);
		bst.delete(7);
		System.out.println(bst.getValue(7));
	}
}
