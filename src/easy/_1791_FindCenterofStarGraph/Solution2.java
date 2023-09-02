package easy._1791_FindCenterofStarGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {

	public static int findCenter(int[][] edges) {
		int n = edges.length;
		List<Integer>[] list = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>(); // [ {} ,{} ,{ }]
		}

		for (int[] arr : edges) {
			int src = arr[0];
			int dest = arr[1];
			list[src].add(dest);
			list[dest].add(src); // undirected
		}

		int startNode = 1;
		// Find an initial node to start BFS
		for (int i = 0; i < n; i++) {
			if (list[i].size() > 1) {
				startNode = i + 1; // Adjust for 0-based indexing
				break;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visted = new boolean[n];
		bfs(list, visted, queue, startNode);

		// Continue BFS from the last node in the queue
		while (!queue.isEmpty()) {
			int node = queue.poll();
			bfs(list, visted, queue, node);
		}

		// At this point, the last visited node is the center
		return startNode;
	}

	private static void bfs(List<Integer>[] list, boolean[] visted, Queue<Integer> queue, int node) {

		visted[node] = true;
		queue.add(node);
		for (int adjacnet : list[node - 1]) {
			if (!visted[adjacnet]) {
				visted[adjacnet] = true;
				queue.add(adjacnet);
			}
		}

	}

	public static void main(String[] args) {

	}

}
