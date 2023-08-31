package medium._797_AllPathsFromSourcetoTarget;

import java.util.ArrayList;
import java.util.List;

public class _797_AllPathsFromSourcetoTarget {

	// Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find
	// all possible paths from node 0 to node n - 1 and return them in any order.

//	The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).a

//	        Input: graph = [[1,2],[3],[3],[]]
//			Output: [[0,1,3],[0,2,3]]
//			Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

//	        Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
//			Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]

	// hint: backtraking and DFS and BFS and grpah
	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		path.add(0); // Start from the source node (node 0)
		dfs(graph, 0, result, path);
		return result;
	}

	private static void dfs(int[][] graph, int node, List<List<Integer>> result, List<Integer> path) {
		if (node == graph.length - 1) {
			result.add(new ArrayList<>(path)); // Add a copy of the path to the result
			return;
		}

		for (int neighbor : graph[node]) {
			path.add(neighbor); // Add the neighbor to the current path
			dfs(graph, neighbor, result, path); // Explore the neighbor
			path.remove(path.size() - 1); // Backtrack: remove the last node from the path
		}

	}

	public static void main(String[] args) {
		int[][] graph = { { 1, 2 }, { 3 }, { 3 }, {} };
		List<List<Integer>> paths = allPathsSourceTarget(graph);
		for (List<Integer> path : paths) {
			System.out.println(path);
		}

	}

}
