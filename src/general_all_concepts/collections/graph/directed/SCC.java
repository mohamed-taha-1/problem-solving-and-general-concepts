package general_all_concepts.collections.graph.directed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SCC {

	/*
	 * Strongly Connected Components (SCC) in a directed graph represent groups of
	 * nodes where each node in a group can reach every other node in the same
	 * group.
	 * 
	 * 
	 * # https://youtu.be/xVMe4JSEQo0
	 * You can find SCCs in a directed graph using Kosaraju's algorithm
	 */

	private int V;
	private List<Integer>[] adjacencyList;

	public SCC(int vertices) {
		V = vertices;
		adjacencyList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjacencyList[i] = new ArrayList<>();
		}
	}

	public void addEdge(int from, int to) {
		adjacencyList[from].add(to);
	}

	public List<List<Integer>> findStronglyConnectedComponents() {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[V];

		// Step 1: Perform DFS on the original graph and fill the stack
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				dfs(i, visited, stack);
			}
		}

		// Step 2: Transpose the graph (reverse all edges)
		SCC transposedSCC = transpose();

		// Step 3: Perform DFS on the transposed SCC using stack
		Arrays.fill(visited, false);
		List<List<Integer>> sccList = new ArrayList<>();

		while (!stack.isEmpty()) {
			int node = stack.pop();
			if (!visited[node]) {
				List<Integer> scc = new ArrayList<>();
				transposedSCC.dfs(node, visited, scc);
				sccList.add(scc);
			}
		}

		return sccList;
	}

	private void dfs(int node, boolean[] visited, List<Integer> result) {
		visited[node] = true;
		result.add(node);

		for (int neighbor : adjacencyList[node]) {
			if (!visited[neighbor]) {
				dfs(neighbor, visited, result);
			}
		}
	}

	private SCC transpose() {
		SCC transposedSCC = new SCC(V);

		for (int i = 0; i < V; i++) {
			for (int neighbor : adjacencyList[i]) {
				transposedSCC.addEdge(neighbor, i); // Reverse edges
			}
		}

		return transposedSCC;
	}

	public static void main(String[] args) {
		int V = 5;
		SCC graph = new SCC(V);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);

		List<List<Integer>> sccList = graph.findStronglyConnectedComponents();

		System.out.println("Strongly Connected Components:");
		for (List<Integer> scc : sccList) {
			System.out.println(scc);
		}

	}
}
