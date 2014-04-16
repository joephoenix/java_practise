package phoenix.practise.third;

public class C08Tree {

	/**
	 * 树的节点的定义
	 * 
	 * @author joephoenix
	 * 
	 */
	class Node {
		// 用作键值的变量
		int iData;
		// 存放数据的变量
		double dData;
		// 左子节点
		Node leftChild;
		// 右子节点
		Node rightChild;

		// 数据节点内容方法
		public void displayNode() {
			System.out.println("{" + iData + ", " + dData + "} ");
		}

	}

	/**
	 * 树的定义
	 * 
	 * @author joephoenix
	 * 
	 */

	// 定义树的顶点
	private Node root;

	// 搜索树节点，得到其中的数据
	public Node find(int key) {
		// 得到最高父节点
		Node current = root;
		while (current.iData != key) {
			// 如果节点数据小于要查找的值
			if (key < current.iData) {
				// 把节点设置成左子节点
				current = current.leftChild;
			} else {
				// 把节点设置成右子节点
				current = current.rightChild;
			}
			// 如果节点是空，则查询结束，跳出循环，结束遍历
			if (current == null) {
				return null;
			}
		}
		return current;
		// 该算法实现了递归算法的中序遍历
	}

	/**
	 * 返回树中最小值的结点，假设该树已经排序， 左孩子结点总比右孩子结点的值大
	 * 
	 * @return
	 */
	public Node minimun() {
		Node current, last = null;
		current = root;
		// 遍历到底
		while (current != null) {
			last = current;
			current = current.leftChild;
		}
		return last;
	}

	/**
	 * 在最下叶子上插入一个节点
	 * 
	 * @param id
	 * @param dd
	 */
	public void insert(int id, double dd) {
		// 新建结点
		Node newNode = new Node();
		// 给结点赋值
		newNode.iData = id;
		newNode.dData = dd;
		// 判断是否第一个结点
		if (root == null) {
			root = newNode;
		} else {
			// 从根节点开始
			Node current = root;
			// 父节点的定义
			Node parent;
			// 开始遍历查找父节点
			while (true) {
				parent = current;
				// 左孩子的结点必须比右孩子的节点小
				// 所以如果小于中间节点的值，则存放于左边
				if (id < current.iData) {
					current = current.leftChild;
					// 如果节点不存在，则把新节点，然后返回
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					// 如果节点不存在，则把新节点，然后返回
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}

	}

	/**
	 * 删除指定节点
	 * 
	 * @param key
	 */
	public void delete(int key) {
		// 父节点从根节点开始
		Node current = root;
		Node parent = root;
		// 默认 左子节点
		boolean isLeftChild = true;
		// 查找指定的节点
		while (current.iData != key) {
			// 指定父节点
			parent = current;
			// 左节点的值总比右结点的小，如果小于则遍历左边的叶子
			if (key < current.iData) {
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			}
			// 如果在树中找不到符合条件的值，
			// 结束遍历，返回false
			if (current == null) {
				// return false;
			}
			// 找到结点，对树的结点不同采取不同处理
			// 如果节点的左右子节点都是null，则返回父节点去删除父节点
			if (current.leftChild == null && current.rightChild == null) {
				// 如果树中只有唯一一个结点(root)，则删除
				if (current == root) {
					root = null;
				} else if (isLeftChild) {
					// 如果结点是左孩子，则删除该结点
					parent.leftChild = null;
				} else {
					// 如果结点是右孩子，则删除该结点
					parent.rightChild = null;
				}
			} else if (current.rightChild == null) {
				// 如果是右孩子，但是根结点的右孩子不存在，
				// 则该右孩子不是根节点的右孩子，而是左子树的某个右结点
				if (current == root) {
					root = current.leftChild;
				} else if (isLeftChild) {
					// 如果是左孩子，但是根结点的左孩子不存在，则该左孩子不是根节点的左孩子，而是右子树的某个左结点
					parent.leftChild = current.leftChild;
				} else {
					parent.rightChild = current.leftChild;
				}
			} else if (current.leftChild == null) {
				if (current == root) {
					root = current.rightChild;
				} else if (isLeftChild) {
					parent.leftChild = current.rightChild;
				} else {
					parent.rightChild = current.rightChild;
				}
			} else {
				// 其他情况，当需要删除的节点有孩子结点时的处理
				Node successor = getSuccessor(current);
				if (current == root) {
					root = successor;
				} else if (isLeftChild) {
					parent.leftChild = successor;
				} else {
					parent.rightChild = successor;
				}
				successor.leftChild = current.leftChild;
			}
		}
	}

	/**
	 * 执行左中右的二叉树遍历方式 有前序遍历、中序遍历和后序遍历
	 */
	public void printTree() {
		System.out.print("前序遍历：");
		preOrder(root);
		System.out.println();
		System.out.print("中序遍历：");
		inOrder(root);
		System.out.println();
		System.out.print("后序遍历：");
		postOrder(root);
		System.out.println();
	}

	/**
	 * 返回删除节点的下一个最高值节点 如果是有节点，则这个右节点降一位成为左节点
	 * 
	 * @param delNode
	 * @return
	 */
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		// 遍历到左节点
		Node current = delNode.rightChild;
		while (current != null) {
			// 右节点的情况
			successorParent = successor;
			successor = current;
			// 当前节点降成左节点
			current = current.leftChild;
		}
		// 如果不连续，则上一层父节点的左节点变成右节点，
		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			// 删除节点的左节点变成新节点的右节点
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}

	/**
	 * 前序遍历，使用递归算法
	 * 
	 * @param localRoot
	 */
	private void preOrder(Node localRoot) {
		if (localRoot != null) {
			// 遍历根结点
			localRoot.displayNode();
			// 遍历左子树
			preOrder(localRoot.leftChild);
			// 遍历右子树
			preOrder(localRoot.rightChild);
		}
	}

	/**
	 * 中序遍历
	 * 
	 * @param localRoot
	 */
	private void inOrder(Node localRoot) {
		if (localRoot != null) {
			// 遍历左子树
			inOrder(localRoot.leftChild);
			// 遍历根结点
			localRoot.displayNode();
			// 遍历右子树
			inOrder(localRoot.rightChild);
		}
	}

	/**
	 * 后序遍历
	 * 
	 * 即先左子节点、然后右子节点，左右中间节点
	 * 
	 * @param localRoot
	 */
	private void postOrder(Node localRoot) {
		if (localRoot != null) {
			// 遍历右子树
			postOrder(localRoot.leftChild);
			// 遍历左子树
			postOrder(localRoot.rightChild);
			// 遍历根结点
			localRoot.displayNode();
		}
	}

	public static void main(String[] args) {
		// 创建一棵树
		C08Tree myTree = new C08Tree();
		// 插入3个节点
		myTree.insert(50, 1.5);
		myTree.insert(25, 1.7);
		myTree.insert(75, 1.9);
		// 查找编号25的节点
		Node found = myTree.find(25);
		if (found != null) {
			System.out.println("Found the Node with key 25" + "the data  is "
					+ found.dData);
		} else {
			System.out.println("Could not find node with key 25");
		}

		myTree.printTree();
		System.out.println("删除后...");
		myTree.insert(10, 3.3);
		myTree.delete(25);
		myTree.printTree();
		myTree.insert(20, 4.3);
		myTree.insert(30, 5.3);
		myTree.insert(40, 6.3);
		System.out.println("插入3个新节点后...");
		myTree.printTree();
	}

}
