package phoenix.DataStruct.Search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * B 树可以看作是对2-3查找树的一种扩展，即他允许每个节点有t-1个子节点。
 * 
 * 根节点至少有两个子节点 每个节点有t-1个key，并且以升序排列 位于t-1和t
 * 
 * key的子节点的值位于t-1 和t
 * 
 * key对应的Value之间
 * 
 * 其它节点至少有t/2个子节点
 * 
 * t决定树的深度，比如T=4，则是4阶树
 * 
 * B+树是对B树的一种变形树，它与B树的差异在于：
 * 
 * 有k个子结点的结点必然有k个关键码； 非叶结点仅具有索引作用，跟记录有关的信息均存放在叶结点中。
 * 树的所有叶结点构成一个有序链表，可以按照关键码排序的次序遍历全部记录。
 * 
 */
public class BTree<E extends Comparable<E>> {

	private BTNode root = null;
	private int t;
	private final int fullNum;

	public BTree(int t) {
		this.t = t;
		fullNum = 2 * t - 1;
	}

	private final BTNode nullBTNode = new BTNode();

	public class BTNode {
		private int number = 0;
		private List<E> values = new ArrayList<E>();
		private List<BTNode> children = new ArrayList<BTNode>();
		private boolean isLeaf = false;

		E getKey(int i) {
			return values.get(i);
		}

		BTNode getChildren(int i) {
			return children.get(i);
		}

		void addKey(int i, E element) {
			values.add(i, element);
		}

		void removeKey(int i) {
			values.remove(i);
		}

		void addChildren(int i, BTNode bt) {
			children.add(i, bt);
		}

		void removeChildren(int i) {
			children.remove(i);
		}

		boolean isFull() {
			if (number == fullNum) {
				return true;
			} else {
				return false;
			}
		}

		int getSize() {
			return values.size();
		}

		boolean isNull() {
			return (this == nullBTNode);
		}

		@Override
		public String toString() {
			if (number == 0) {
				return "nullNode";
			}

			StringBuilder sb = new StringBuilder();

			sb.append("[N:" + number + "]");

			for (E e : values) {
				sb.append(e + ",");
			}
			sb.append("] [ children: ");
			for (BTNode bn : children) {
				if (bn == nullBTNode) {
					sb.append(bn + ",");
				} else {
					sb.append("notNullNode" + ",");
				}
			}
			sb.append("][childrenSize:" + children.size());
			sb.append("][isLeaf:" + isLeaf);
			sb.append("]");
			return sb.toString();
		}
	}

	// 初始化根节点
	private void constructRoot(E element) {
		root = new BTNode();
		root.number = 1;
		root.addKey(0, element);
		root.isLeaf = false;
	}

	private void addElementToNode(BTNode node, E element, int i) {
		node.addKey(i, element);
		node.number++;
		node.addChildren(i, nullBTNode);
	}

	public void insertElement(E element) {
		if (root == null) {
			constructRoot(element);
			root.isLeaf = true;
			root.addChildren(0, nullBTNode);
			root.addChildren(1, nullBTNode);
			return;
		}

		BTNode currNode = root;
		if (root.isFull()) {
			// 扩展根节点
			constructRoot(currNode.getKey(t - 1));
			// 取得新节点
			BTNode newNode = getExtendedNode(currNode);
			// 处理原有的满节点
			processFullNode(currNode);

			// 处理根节点
			root.addChildren(0, currNode);
			root.addChildren(1, newNode);
			return;
		}

		int i = 0;
		BTNode childNode = null;
		// 找到要插入的节点
		while (true) {
			while ((i < currNode.getSize())
					&& (element.compareTo(currNode.getKey(i)) > 0)) {
				i++;
			}

			childNode = currNode.getChildren(i);
			if (childNode.isFull()) {
				// 分裂节点
				// 把中点元素加入到父节点中
				currNode.number++;
				currNode.addKey(i, childNode.getKey(t - 1));

				// 要扩展的新节点
				BTNode newNode = getExtendedNode(childNode);

				// 处理原有的满节点
				processFullNode(childNode);

				// 把新节点接入父节点的关系中
				currNode.addChildren(i + 1, newNode);

				// 降低到下一层
				if (element.compareTo(currNode.getKey(i)) < 0) {
					currNode = childNode;
				} else {
					currNode = newNode;
				}
				i = 0;
				continue;
			}

			// 降低到子节点
			if (!childNode.isNull()) {
				currNode = childNode;
				i = 0;
				continue;
			}

			// 插入新的元素到当前节点中
			addElementToNode(currNode, element, i);
			return;
		}
	}

	private BTNode getExtendedNode(BTNode fullNode) {
		BTNode newNode = new BTNode();
		newNode.number = t - 1;
		newNode.isLeaf = fullNode.isLeaf;
		for (int i = 0; i < t; i++) {
			if (i != t - 1) {
				newNode.addKey(i, fullNode.getKey(t + i));
			}
			newNode.addChildren(i, fullNode.getChildren(t + i));
		}
		return newNode;
	}

	// 应该在调用getExtendedNode（）方法之后调用
	private void processFullNode(BTNode fullNode) {
		fullNode.number = t - 1;
		for (int i = t - 1; i >= 0; i--) {
			fullNode.removeKey(t + i - 1);
			fullNode.removeChildren(t + i);
		}
	}

	@Override
	public String toString() {
		if (root == null) {
			return "NULL";
		}

		StringBuilder sb = new StringBuilder();

		LinkedList<BTNode> queue = new LinkedList<BTNode>();
		queue.push(root);

		BTNode tem = null;
		while ((tem = queue.poll()) != null) {
			for (BTNode bn : tem.children) {
				if (!bn.isNull()) {
					queue.offer(bn);
				}
			}
			sb.append(tem.toString() + "\n");
		}
		return sb.toString();
	}

}
