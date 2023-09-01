package general_all_concepts.collections.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphhasPathFrom_Source_To_Distnation {
	// first use adjacency list

	public boolean HasGetPath(int[][] edges, int source, int destination) {
		int n=edges.length;
		 List<Integer>[] list = new ArrayList[n + 1];

		    for (int i = 0; i < n; i++) {
		        list[i] = new ArrayList<>();
		    }

		    for (int[] arr : edges) {
		        int src = arr[0];
		        int dist = arr[1];
		        list[src].add(dist);
		        list[dist].add(src);
		    }

		    boolean[] visited = new boolean[n];
		    return dfs(list, source, destination, visited);
		}

		private boolean dfs(List<Integer>[] list, int source, int destination, boolean[] visited) {
		    if (source == destination) {
		        return true;
		    }

		    // explore adjacent nodes
		    visited[source] = true;
		    for (int arr : list[source]) {
		        if (!visited[arr] && dfs(list, arr, destination, visited)) {
		            return true;
		        }
		    }

		    return false;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
