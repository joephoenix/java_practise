package phoenix.DataStruct.Search;

public class BinarySearchTree<T1 extends Comparable<T1>, T2 extends Comparable<T2>> {
	// 声明根节点
	private Node root;

	// 节点类
	class Node {
		Node left;
		Node right;
		public T1 key;
		public T2 value;

		public T1 getKey() {
			return key;
		}

		public void setKey(T1 key) {
			this.key = key;
		}

		public T2 getValue() {
			return value;
		}

		public void setValue(T2 value) {
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node(T1 key, T2 value) {
			this.key = key;
			this.value = value;
		}
	}

	// 查找的递归实现
	public T2 getValue(T1 key) {
		T2 result = null;

		Node node = root;
		while (node != null) {
			if (key.compareTo(node.key) > 0) {
				node = node.right;
			} else if (key.compareTo(node.key) < 0) {
				node = node.left;
			} else {
				result = node.value;
				break;
			}
		}
		return result;
	}

	// 查找的迭代实现
	public T2 get(T1 key) {
		return getValue(root, key);
	}

	public T2 getValue(Node root, T1 key) {
		if (root == null) {
			return null;
		}
		int cmp = key.compareTo(root.key);
		if (cmp > 0) {
			return getValue(root.right, key);
		} else if (cmp < 0) {
			return getValue(root.left, key);
		} else {
			return root.value;
		}
	}

	// 插入，使用迭代的方式
	public void put(T1 key, T2 value) {
		root = put(root, key, value);
	}

	private Node put(Node x, T1 key, T2 value) {
		// 如果节点为空，则创建新的节点，并返回
		// 否则比较根据大小判断是左节点还是右节点，然后继续查找左子树还是右子树
		if (x == null) {
			return new Node(key, value);
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = put(x.left, key, value);
		} else if (cmp > 0) {
			x.right = put(x.right, key, value);
		} else {
			x.value = value;
		}
		return x;
	}

	// 取最大节点
	public T2 getMax() {
		T2 maxItem = null;
		Node s = root;
		while (s.right != null) {
			s = s.right;
		}
		maxItem = s.value;
		return maxItem;
	}

	// 取最小的节点
	public T2 getMin() {
		T2 minItem = null;
		Node s = root;
		while (s.left != null) {
			s = s.left;
		}
		minItem = s.value;
		return minItem;
	}

	// 查找小于等于的节点
	public T1 Floor(T1 key) {
		Node x = Floor(root, key);
		if (x != null) {
			return x.key;
		} else {
			return null;
		}
	}

	private Node Floor(Node x, T1 key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp == 0) {
			return x;
		}
		if (cmp < 0) {
			return Floor(x.left, key);
		} else {
			Node right = Floor(x.right, key);
			if (right == null) {
				return x;
			} else {
				return right;
			}
		}
	}

	// 删除最小值
	public void delMin() {
		root = delMin(root);
	}

	private Node delMin(Node node) {
		if (node.left == null) {
			return node.right;
		}
		node.left = delMin(node.left);
		return node;
	}

	// 删除最大值
	public void delMax() {
		root = delMax(root);
	}

	private Node delMax(Node node) {
		if (node.right == null) {
			return node.right;
		}
		node.right = delMax(node.right);
		return node;
	}

	// 删除指定节点
	public void delete(T1 key) {
		root = delete(root, key);
	}

	private Node delete(Node d, T1 key) {
		int cmp = key.compareTo(d.key);
		if (cmp > 0) {
			d.right = delete(d.right, key);
		} else if (cmp < 0) {
			d.left = delete(d.left, key);
		} else {
			if (d.left == null) {
				return d.right;
			} else if (d.right == null) {
				return d.left;
			} else {
				Node t = d;
				d = getMinNode(t.right);
				d.right = delMin(t.right);
				d.left = t.left;
			}
		}
		return d;
	}

	private Node getMinNode(Node m) {
		if (m.left == null) {
			return m;
		} else {
			return getMinNode(m.left);
		}
	}
}
