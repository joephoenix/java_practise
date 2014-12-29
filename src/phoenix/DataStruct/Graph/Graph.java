package phoenix.DataStruct.Graph;

import java.io.InputStream;

import phoenix.DataStruct.Fundamentals.Bag;
import phoenix.DataStruct.Stack.Stack;

public class Graph {

	private final int V;
	private int E;
	private Bag<Integer>[] adj;

	public Graph(int V) {
		if (V < 0) {
			throw new IllegalArgumentException(
					"Number of vertices must be nonnegative");
		}
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();
		}
	}

	public Graph(Graph G) {
		this(G.V());
		this.E = G.E();
		for (int v = 0; v < G.V(); v++) {
			Stack<Integer> reverse = new Stack<Integer>();
			for (int w : G.adj[v]) {
				reverse.push(w);
			}
			for (int w : reverse) {
				adj[v].add(w);
			}
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void setE(int e) {
		this.E = e;
	}

	private void validateVertex(int v) {
		if (v < 0 || v >= V) {
			throw new IndexOutOfBoundsException("vertex " + v
					+ " is not between 0 and " + (V - 1));
		}
	}

	public void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		E++;
		adj[v].add(w);
		adj[w].add(v);
	}

	public Iterable<Integer> adj(int v) {
		validateVertex(v);
		return adj[v];
	}

	public int degree(int v) {
		validateVertex(v);
		return adj[v].Size();
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		String NEWLINE = System.getProperty("line.separator");
		s.append(V + " vertices, " + E + " edges " + NEWLINE);
		for (int v = 0; v < V; v++) {
			s.append(v + " : ");
			for (int w : adj[v]) {
				s.append(w + " ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}
}
