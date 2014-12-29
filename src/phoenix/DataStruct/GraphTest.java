package phoenix.DataStruct;

import phoenix.DataStruct.Graph.Graph;

public class GraphTest {

	public static void main(String[] args) {
		Graph g = new Graph(10);
		g.setE(5);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(4, 8);
		g.addEdge(5, 6);
		g.addEdge(6, 8);
		System.out.println(g.toString());
	}
}
