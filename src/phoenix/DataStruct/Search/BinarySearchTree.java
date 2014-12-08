package phoenix.DataStruct.Search;

public class BinarySearchTree<T extends Comparable<T>> {

	// 声明根节点
	private Node root;

	// 节点类
	class Node {
		Node left;
		Node right;
		public T key;
		public T value;

		public T getKey() {
			return key;
		}

		public void setKey(T key) {
			this.key = key;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
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

		public Node(T key, T value) {
			this.key = key;
			this.value = value;
		}
	}

	// 查找的递归实现
	public T getValue(T key) {
		T result = null;

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
	public T get(T key) {
		return getValue(root, key);
	}

	public T getValue(Node root, T key) {
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
	public void put(T key, T value) {
		root = put(root, key, value);
	}

	private Node put(Node x, T key, T value) {
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
	public T getMax() {
		T maxItem = null;
		Node s = root;
		while (s.right != null) {
			s = s.right;
		}
		maxItem = s.value;
		return maxItem;
	}

	// 取最小的节点
	public T getMin() {
		T minItem = null;
		Node s = root;
		while (s.left != null) {
			s = s.left;
		}
		minItem = s.value;
		return minItem;
	}

	// 查找小于等于的节点
	public T Floor(T key) {
		Node x = Floor(root, key);
		if (x != null) {
			return x.key;
		} else {
			return null;
		}
	}

	private Node Floor(Node x, T key) {
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
	public void delete(T key) {
		root = delete(root, key);
	}

	private Node delete(Node d, T key) {
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
