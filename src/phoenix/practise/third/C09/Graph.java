package phoenix.practise.third.C09;

import java.util.Vector;

public class Graph {
	int vertextNum;
	Vector[] vector;
	int[] visited;
	Stack stack;
	Stack result;
	Queue queue;

	/**
	 * 构造一个图,图的顶点数
	 * 
	 * @param num
	 */
	public Graph(int num) {
		vertextNum = num;
		vector = new Vector[vertextNum];
		visited = new int[vertextNum];
		for (int i = 0; i < num; i++) {
			visited[i] = 0;
		}
		stack = new Stack(num);
		result = new Stack(num);
		queue = new Queue(num);
	}

	/**
	 * 向图中添加无向边
	 * 
	 * @param I
	 *            边的一个顶点
	 * @param J
	 *            边的另一个顶点
	 * @return 是否添加成功
	 */

	public boolean addEdge(int I, int J) {
		/**
		 * 判断用户输入的是否是一个顶点，如果是，则返回flase,添加不成功
		 */
		if (J == I) {
			return false;
		}
		/**
		 * 判断所输入的顶点值是否在图所顶点范围值内，如果不在，则提示顶点不存在
		 * 
		 */
		if (I < vertextNum && J < vertextNum && I >= 0 && J >= 0) {
			int k;

			/**
			 * 如果i比j大，则将i与j交换
			 */
			if (I > J) {
				k = I;
				I = J;
				J = k;
			}
			/**
			 * 
			 * 判断边是否存在
			 */
			if (isEdgeExists(I, J)) {
				return false;
			}

			/**
			 * 添加边
			 */
			vector[I].add(J);
			return true;
		}
		return false;
	}

	/**
	 * 判断无向边是否存在
	 * 
	 * @param i
	 *            要查询的无向边的一个顶点
	 * @param j
	 *            要查询的无向边的另一个顶点
	 * @return 边是否存在，false:不存在，true:存在
	 */
	public boolean isEdgeExists(int i, int j) {
		/**
		 * 判断所输入的顶点值是否在图所顶点范围值内，如果不在，则提示顶点不存在
		 * 
		 */
		if (i < vertextNum && j < vertextNum && i >= 0 && j >= 0) {
			if (i == j) {
				return false;
			}

			int k;
			/**
			 * 如果i比j大的话，i与j进行交换
			 */
			if (i > j) {
				k = i;
				i = j;
				j = k;
			}
			/**
			 * 判断i的邻接结点集是否为空
			 */
			if (vector[i] == null) {
				vector[i] = new Vector(8);
			}
			/**
			 * 判断这条边是否存在，如果存在，则提示边已经存在
			 */
			for (int q = 0; q < vector[i].size(); q++) {
				if (((Integer) vector[i].get(q)).intValue() == j) {
					System.out.println("顶点" + i + "和" + "顶点" + j + "这两点之间存在边");
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 进行深度优先遍历
	 */
	public void dfs() {
		/**
		 * 从顶点0开始遍历
		 */
		visited[0] = 1;
		stack.push(0);
		/**
		 * 如果栈不为空的话，进行循环查询
		 */
		while (!stack.isEmpty()) {
			int v = getAdjUnvisitedVertex(stack.peek());
			/**
			 * 没找到未被访问的邻接点，元素出栈，如果找到的话，将这个结点标记为访问过，将其未被访问的邻接点入栈
			 */
			if (v == -1) {
				result.push(stack.peek());
				stack.pop();
			} else {
				visited[v] = 1;
				stack.push(v);
			}
		}
		System.out.println("进行深度优先的遍历顺序为：");
		result.list();
	}

	/**
	 * 进行广度优先遍历
	 */
	public void bsf() {
		/**
		 * 从顶点0开始遍历
		 */
		visited[0] = 1;
		queue.push(0);
		while (!queue.isEmpty()) {
			int v = queue.pop();
			result.push(v);
			int i;
			while ((i = getAdjUnvisitedVertex(v)) != -1) {
				visited[i] = 1;
				queue.push(i);
			}
		}
		System.out.println("广度优先的遍历顺序为：");
		result.list();
	}

	/**
	 * 得到指定结点的一个未被访问的邻接点位置
	 * 
	 * @param v
	 *            要查询的顶点
	 * @return 顶点的下一个未被访问的邻接结点
	 */
	public int getAdjUnvisitedVertex(int v) {
		int temp;
		/**
		 * 判断邻接结点是否为空
		 */
		if (vector[v] != null) {
			/**
			 * 遍历所有的邻接结点
			 */
			for (int j = 0; j < vector[v].size(); j++) {
				temp = ((Integer) vector[v].get(j)).intValue();
				/**
				 * 判断邻接结点是否被访问过
				 */
				if (visited[temp] == 0)
					return ((Integer) vector[v].get(j)).intValue();
			}
		}
		return -1;
	}

	/**
	 * 得到图的遍历顺序
	 * 
	 * @return 图的遍历顺序
	 */
	public Stack getResult() {
		return result;
	}

	/**
	 * 队列类的声明
	 * 
	 * @author joephoenix
	 * 
	 */
	public class Queue {
		private int[] values;
		private int begin = -1;
		private int end = -1;

		Queue(int size) {
			values = new int[size];
		}

		void push(int value) {
			values[++begin] = value;
		}

		int pop() {
			return values[++end];
		}

		boolean isEmpty() {
			return begin == end;
		}
	}

	/**
	 * 栈类的声明
	 * 
	 * @author joephoenix
	 * 
	 */
	public class Stack {
		private int[] st;
		private int top;
		private int count;

		/**
		 * 构造一个栈
		 * 
		 * @param size
		 *            栈的大小
		 */
		public Stack(int size) {
			st = new int[size];
			top = -1;
			count = 0;
		}

		/**
		 * 元素进栈
		 * 
		 * @param j
		 *            要进栈的元素
		 */
		public void push(int j) {
			count++;
			st[++top] = j;
		}

		/**
		 * 元素出栈
		 * 
		 * @return 出栈的元素
		 */
		public int pop() {
			return st[top--];
		}

		/**
		 * 查询栈顶元素
		 * 
		 * @return 栈顶元素
		 */
		public int peek() {
			return st[top];
		}

		/**
		 * 查询栈是否为空
		 * 
		 * @return 栈是否为空
		 */
		public boolean isEmpty() {
			count--;
			return (top == -1);
		}

		/**
		 * 查看栈里的所有元素
		 */
		public void list() {
			for (int i = 0; i < count; i++) {
				System.out.print(st[i] + "   ");
			}
			System.out.println();
		}

		/**
		 * 得到栈里一共有多少元素
		 * 
		 * @return 栈里的元素个数
		 */
		public int getCount() {
			return count;
		}

		/**
		 * 查看栈里是否包含某个元素
		 * 
		 * @param i
		 *            要查询的元素
		 * @return 是否包含了要查询的元素
		 */
		public boolean isContains(int i) {
			for (int k = 0; k < st.length; k++) {
				System.out.print("开始比较" + i + "此时的result:");
				list();
				System.out.println();
				if (st[k] == i) {
					return true;
				}
			}
			return false;
		}

		/**
		 * 得到栈里的元素集
		 * 
		 * @return 栈里的元素集合
		 */
		public int[] getSt() {
			return st;
		}
	}
}
