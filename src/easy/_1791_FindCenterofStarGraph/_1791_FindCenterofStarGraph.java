package easy._1791_FindCenterofStarGraph;

import java.util.ArrayList;
import java.util.List;

public class _1791_FindCenterofStarGraph {

	/*
	 * here is an undirected star graph consisting of n nodes labeled from 1 to n. A
	 * star graph is a graph where there is one center node and exactly n - 1 edges
	 * that connect the center node with every other node.
	 */

	/*
	 * You are given a 2D integer array edges where each edges[i] = [ui, vi]
	 * indicates that there is an edge between the nodes ui and vi. Return the
	 * center of the given star graph.
	 */

//	       : edges = [[1,2],[2,3],[4,2]]
//			Output: 2

	/*
	 * Input: edges = [[1,2],[5,1],[1,3],[1,4]] Output: 1
	 */

	@SuppressWarnings("unchecked")
	public static int findCenter(int[][] edges) {
		int n = edges.length + 1; // Number of vertices in the star graph
		List<Integer>[] adjList = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int[] edge : edges) {

			int source = edge[0] - 1;
			int target = edge[1] - 1;
			adjList[source].add(target);

			adjList[target].add(source); // un-directes

		}

		int[] degrees = new int[n];

		for (int i = 0; i < n; i++) {
			degrees[i] = adjList[i].size();
		}

		for (int i = 0; i < n; i++) {
			if (degrees[i] == n - 1) { // In a star graph, the center vertex has the highest degree
				return i + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[][] edges = { { 1, 2 }, { 1, 3 }, { 1, 4 } }; // Example input representing a star graph

		System.out.println(findCenter(edges));

	}

}
