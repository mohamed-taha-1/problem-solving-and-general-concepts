package medium._1466_ReorderRoutestoMakeAllPathsLeadtotheCityZero;

import java.util.ArrayList;
import java.util.List;

public class _1466_ReorderRoutestoMakeAllPathsLeadtotheCityZero {

	/*
	 * There are n cities numbered from 0 to n - 1 and n - 1 roads
	 * 
	 * <T> such that there is only one way to travel between two different cities.
	 * Last year, The ministry of transport decided to orient the roads in one
	 * direction because they are too narrow.
	 * 
	 * <P> Roads are represented by : connections[i] = [ai, bi]
	 * 
	 * <T> This year, there will be a big event in the capital (city 0), and many
	 * people want to travel to this city.
	 * 
	 * 
	 * <T> Your task consists of reorienting some roads such that each city can
	 * visit the city 0. Return the minimum number of edges changed.
	 * 
	 * It's guaranteed that each city can reach city 0 after reorder.... OKAY
	 * 
	 * n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]] : 3
	 */

	public static int minReorder(int n, int[][] connections) {
		n = n + 1;
		List<List<Integer>> adjacentList = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			adjacentList.add(new ArrayList<>());
		}

		for (int[] arr : connections) {
			int u = arr[0];
			int v = arr[1];
			adjacentList.get(u).add(v);
			adjacentList.get(v).add(-u); // Reverse edge
		}

		boolean[] visited = new boolean[n];
		return dfs(adjacentList, visited, 0);
	}

	private static int dfs(List<List<Integer>> adjacentList, boolean[] visited, int node) {
		visited[node] = true;
		int count = 0;

		for (int neighbor : adjacentList.get(node)) {
			if (!visited[Math.abs(neighbor)]) {
				// If the neighbor is positive, it's a forward edge, so increment the count.
				// If it's negative, it's a reversed edge, so don't increment the count.
				count += neighbor > 0 ? 1 : 0;
				count += dfs(adjacentList, visited, Math.abs(neighbor));
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[][] connections = { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } };
		int n = 6;

		System.out.println(minReorder(n, connections));

	}

}
