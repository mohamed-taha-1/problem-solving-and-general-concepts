package easy._1971_FindifPathExistsinGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _1971_FindifPathExistsinGraph {

	// You want to determine if there is a valid path that exists from vertex source
	// to vertex destination.

	/*
	 * bi-directional edge between vertex ui and vertex vi:: Given edges and the
	 * integers n, source, and destination, || return true if there is a valid path
	 * from source to destination, or false otherwise
	 */

	// Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
	// Output: true

	@SuppressWarnings("unchecked")
	public static boolean validPath(int n, int[][] edges, int source, int destination) {
		List<Integer>[] adjacentList = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			adjacentList[i] = new ArrayList<>();
		}

		for (int[] arr : edges) {
			int src = arr[0] ;
			int dist = arr[1] ;
			adjacentList[src].add(dist);
			adjacentList[dist].add(src); // for bi-direction
		}

		// Use Depth-First Search (DFS) to check if there is a path from source to
		// destination
		boolean[] visited = new boolean[n];
		if (dfs(adjacentList, source, destination, visited)) {
			return true;
		}

		return false;
	}

	// search with dfs
	private static boolean dfs(List<Integer>[] adjList, int current, int destination, boolean[] visited) {

		if (current == destination) {
			return true;
		}

		visited[current] = true;

		for (int neighbor : adjList[current]) {
			if (!visited[neighbor] && dfs(adjList, neighbor, destination, visited)) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {

		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 } };

		System.out.println(validPath(3, edges, 0, 2));
	}

}
