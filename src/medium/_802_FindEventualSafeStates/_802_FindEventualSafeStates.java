package medium._802_FindEventualSafeStates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _802_FindEventualSafeStates {

	// A node is a terminal node if? if there are no outgoing edges.
	// A node is a safe node if ? every possible path starting from that node leads
	// to a terminal node (or another safe node).

	/*
	 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]] Output: [2,4,5,6] Explanation:
	 * The given graph is shown above. Nodes 5 and 6 are terminal nodes as there are
	 * no outgoing edges from either of them. Every path starting at nodes 2, 4, 5,
	 * and 6 all lead to either node 5 or 6.
	 */

	/*
	 * Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]] Output: [4] Explanation: Only
	 * node 4 is a terminal node, and every path starting at node 4 leads to node 4.
	 */

	public static List<Integer> eventualSafeNodes(int[][] graph) {

		List<Integer> result = new ArrayList<>();
		int n = graph.length;
		int[] color = new int[n]; // 0: unvisited, 1: visiting, 2: safe

		for (int i = 0; i < n; i++) {
			if (dfs(i, graph, color)) {
				result.add(i);
			}
		}

		return result;
	}

	private static boolean dfs(int node, int[][] graph, int[] color) {
		if (color[node] != 0)
			return color[node] == 2;

		color[node] = 1; // amrk as visited

		for (int neighbor : graph[node]) {
			if (!dfs(neighbor, graph, color)) // If any neighbor is not safe, this node is not safe
				return false;
		}

		color[node] = 2; // Mark as safe

		return true;
	}

	public static void main(String[] args) {
		int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };

		System.out.println(eventualSafeNodes(graph));

	}

}
