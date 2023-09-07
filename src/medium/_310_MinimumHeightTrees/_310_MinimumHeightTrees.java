package medium._310_MinimumHeightTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _310_MinimumHeightTrees {

	/*
	 * A tree is an undirected graph in which any two vertices are connected by
	 * exactly one path. In other words, any connected graph without simple cycles
	 * is a tree.
	 * 
	 * The height of a rooted tree is the number of edges on the longest downward
	 * path between the root and a leaf.
	 */

	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {

		   if (n <= 0) {
	            return Collections.emptyList();
	        }

	        if (n == 1) {
	            // If there's only one node, it's already a minimum height tree.
	            return Collections.singletonList(0);
	        }

	        List<List<Integer>> adjList = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            adjList.add(new ArrayList<>());
	        }

	        int[] degree = new int[n];

	        for (int[] edge : edges) {
	            int u = edge[0];
	            int v = edge[1];
	            adjList.get(u).add(v);
	            adjList.get(v).add(u);
	            degree[u]++;
	            degree[v]++;
	        }

	        Queue<Integer> leaves = new LinkedList<>();

	        for (int i = 0; i < n; i++) {
	            if (degree[i] == 1) {
	                leaves.offer(i);
	            }
	        }

		while (n > 2) {
            int numOfLeaves = leaves.size();
            n -= numOfLeaves;

            for (int i = 0; i < numOfLeaves; i++) {
                int leaf = leaves.poll();
                for (int neighbor : adjList.get(leaf)) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        leaves.offer(neighbor);
                    }
                }
            }
        }

		return new ArrayList<>(leaves);

	}

	public static void main(String[] args) {
		int n = 6;
		int[][] edges = { { 0, 3 }, { 1, 3 }, { 2, 3 }, { 4, 3 }, { 5, 4 } };

		System.out.println(findMinHeightTrees(n, edges));

	}

}
