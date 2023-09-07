package general_all_concepts.collections.graph.directed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TopologicalSortGraph {
	private int V; // Number of vertices
	private Map<Integer, List<Integer>> adjacencyList;

	public TopologicalSortGraph(int vertices) {
		V = vertices;
		adjacencyList = new HashMap<>();
		for (int i = 0; i < V; i++) {
			adjacencyList.put(i, new ArrayList<>());
		}
	}

	public void addEdge(int from, int to) {
		adjacencyList.get(from).add(to);
	}

	public void topologicalSort() {
		Stack<Integer> stack = new Stack<>();
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < V; i++) {

			if (!set.contains(i))
				dfs(set, stack, i);
		}

		// Print the topological order
		System.out.println("Topological Order:");
		while (!stack.isEmpty())
			System.out.println(stack.pop());

	}

	private void dfs(Set<Integer> set, Stack<Integer> stack, int node) {
		set.add(node);

		for (int neighbor : adjacencyList.get(node)) {

			if (!set.contains(neighbor))
				dfs(set, stack, neighbor);

		}

		stack.push(node);

	}

	public static void main(String[] args) {
		int V = 6;
		TopologicalSortGraph graph = new TopologicalSortGraph(V);
		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);

		graph.topologicalSort();

	}

}
