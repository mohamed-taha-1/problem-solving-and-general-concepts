package medium._547_NumberofProvinces;

import java.util.ArrayList;
import java.util.List;

public class _547_NumberofProvinces {
	/*
	 * There are n cities. Some of them are connected, while some are not. If city a
	 * is connected directly with city b, and city b is connected directly with city
	 * c, then city a is connected indirectly with city c
	 */

	/*
	 * - is connected or not A province is a group of directly or indirectly
	 * connected cities and no other cities outside of the group.
	 */

	/*
	 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
	 * ith city and the jth city are directly connected, and isConnected[i][j] = 0
	 * otherwise.
	 */

//	Return the total number of provinces. || number of groupes

//	 isConnected = [[1,1,0],[1,1,0],[0,0,1]]  :: 2

	public static int findCircleNum(int[][] isConnected) {
		int rows = isConnected.length;
		int cols = isConnected[0].length;

		int numberOfProvinces = 0;
		List<List<Integer>> adjacencyList = new ArrayList<>();

		for (int i = 0; i < rows; i++) {
			adjacencyList.add(new ArrayList<>());
			for (int j = 0; j < cols; j++) {
				if (isConnected[i][j] == 1) {
					adjacencyList.get(i).add(j);
				}
			}

		}

		boolean[] visited = new boolean[rows];

		for (int i = 0; i < rows; i++) {
			if (!visited[i]) {
				dfs(adjacencyList, visited, i);
				numberOfProvinces++;
			}
		}

		return numberOfProvinces;
	}

	private static void dfs(List<List<Integer>> adjacencyList, boolean[] visited, int start) {

		visited[start] = true;

		for (int j : adjacencyList.get(start)) {
			if (!visited[j])
				dfs(adjacencyList, visited, j);
		}

	}

	public static void main(String[] args) {
		int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

		System.out.println(findCircleNum(isConnected));

	}

}
