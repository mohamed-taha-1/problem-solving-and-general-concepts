package medium._1557_MinimumNumberofVerticestoReachAllNodes;

import java.util.ArrayList;
import java.util.List;

public class _1557_MinimumNumberofVerticestoReachAllNodes {

	// Input: n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
	// Output: [0,3]

	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		boolean[] isTarget = new boolean[n];

		// Mark target nodes (nodes with incoming edges)
		for (List<Integer> edge : edges) {
			isTarget[edge.get(1)] = true;
		}

		List<Integer> result = new ArrayList<>();

		// Add nodes that are not targets to the result
		for (int i = 0; i < n; i++) {
			if (!isTarget[i]) {
				result.add(i);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
