package phoenix.practise.third.C09;

public class GraphTest {

	public void testAddEdge() {
		/**
		 * 测试一个简单的连通图
		 */
		Graph graph = new Graph(7);
		graph.addEdge(0, 1);
		graph.addEdge(0, 5);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 4);
		graph.addEdge(5, 6);
		graph.addEdge(6, 0);
		graph.bsf();
		graph.dfs();
	}

	public static void main(String[] args) {
		GraphTest graphTest = new GraphTest();
		graphTest.testAddEdge();
	}

}
