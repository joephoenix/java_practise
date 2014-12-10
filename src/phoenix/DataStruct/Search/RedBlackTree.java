package phoenix.DataStruct.Search;

public class RedBlackTree<T1 extends Comparable<T1>, T2> {
	private final boolean RED = true;
	private final boolean BLACK = false;

	private Node root;

	public class Node {
		public Node left;
		public Node right;
		public T1 key;
		public T2 value;
		public int number;
		public boolean color;

		public Node(T1 key, T2 value, int number, boolean color) {
			this.key = key;
			this.value = value;
			this.number = number;
			this.color = color;
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
	}

	private boolean IsRed(Node node) {
		if (node == null) {
			return false;
		}
		return node.color == RED;
	}

	public Node getRoot() {
		return root;
	}

	public Node getNode(T1 key) {
		return getNode(root, key);
	}

	private Node getNode(Node node, T1 key) {
		if (node == null) {
			return null;
		}
		int cmp = key.compareTo(node.key);
		if (cmp == 0) {
			return node;
		} else if (cmp > 0) {
			return getNode(node.right, key);
		} else {
			return getNode(node.left, key);
		}
	}

	public T2 get(T1 key) {
		return getValue(root, key);
	}

	private T2 getValue(Node node, T1 key) {
		if (node == null) {
			return null;
		}
		int cmp = key.compareTo(node.key);
		if (cmp == 0) {
			return node.value;
		} else if (cmp > 0) {
			return getValue(node.right, key);
		} else {
			return getValue(node.left, key);
		}
	}

	// 左旋转
	private Node rotateLeft(Node h) {
		Node x = h.right;
		// 将x的左节点复制给h的右节点
		h.right = x.left;
		// 将h复制给x的右节点
		x.left = h;
		// 把h的颜色属性转移给x
		x.color = h.color;
		// 把h设置成红树
		h.color = RED;
		// 返回x
		return x;
	}

	// 右旋转
	private Node rotateRight(Node h) {
		Node x = h.left;
		// 将x的右节点复制给h的左节点
		h.left = x.right;
		// 将h复制给x的右节点
		x.right = h;

		// 把h的颜色转移给x
		x.color = h.color;
		// 设置h的颜色为红色
		h.color = RED;
		// 返回x
		return x;
	}

	// 初始化一颗红黑树
	public void put(T1 key, T2 value) {
		root = put(root, key, value);
		root.color = BLACK;
	}

	private Node put(Node h, T1 key, T2 value) {
		if (h == null) {
			return new Node(key, value, 1, RED);
		}
		int cmp = key.compareTo(h.key);
		if (cmp < 0) {
			h.left = put(h.left, key, value);
		} else if (cmp > 0) {
			h.right = put(h.right, key, value);
		} else {
			h.value = value;
		}

		// 平衡化操作
		if (IsRed(h.right) && !IsRed(h.left)) {
			h = rotateLeft(h);
		}
		if (IsRed(h.right) && IsRed(h.left.left)) {
			h = rotateRight(h);
		}
		if (IsRed(h.left) && IsRed(h.right)) {
			h = flipColor(h);
		}

		h.number = size(h.left) + size(h.right) + 1;
		return h;
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		} else {
			return node.number;
		}
	}

	private Node flipColor(Node h) {
		Node x = h;
		h.color = RED;

		// 左节点是黑树
		h.left.color = BLACK;
		// 右节点是黑树
		h.right.color = BLACK;
		// 返回节点
		return x;
	}

	public Node getMin() {
		return getMin(root);
	}

	public Node getMax() {
		return getMax(root);
	}

	private Node getMax(Node node) {
		if (node == null) {
			return null;
		} else {
			if (node.right == null) {
				return node;
			} else {
				return getMax(node.right);
			}
		}
	}

	private Node getMin(Node node) {
		if (node == null) {
			return null;
		} else {
			if (node.left == null) {
				return node;
			} else {
				return getMin(node.left);
			}
		}
	}
}
