package medium._210_CourseScheduleII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution2 {

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adjacencyList = new ArrayList<>();

		for (int i = 0; i < numCourses; i++) {
			adjacencyList.add(new ArrayList<>());
		}

		for (int[] prerequisite : prerequisites) {
			adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
		}

		Stack<Integer> stack = new Stack<>();
		Set<Integer> visited = new HashSet<>();
		Set<Integer> currentlyVisiting = new HashSet<>();

		for (int i = 0; i < numCourses; i++) {
			if (!visited.contains(i) && !dfs(adjacencyList, i, visited, currentlyVisiting, stack)) {
				return new int[0]; // Cycle detected, return an empty array
			}
		}

		int[] result = new int[numCourses];
		int index = 0;
		while (!stack.isEmpty())
			result[index++] = stack.pop();

		return result;
	}

	private static boolean dfs(List<List<Integer>> adjacencyList, int node, Set<Integer> visited,
			Set<Integer> currentlyVisiting, Stack<Integer> stack) {
		visited.add(node);
		currentlyVisiting.add(node);

		for (int neighbor : adjacencyList.get(node)) {
			if (currentlyVisiting.contains(neighbor)) {
				return false; // Cycle detected
			}

			if (!visited.contains(neighbor) && !dfs(adjacencyList, neighbor, visited, currentlyVisiting, stack)) {
				return false;
			}
		}

		currentlyVisiting.remove(node);
		stack.push(node);

		return true;
	}

	public static void main(String[] args) {
		int numCourses = 4;
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };

		for (int course : findOrder(numCourses, prerequisites)) {
			System.out.print(course + " ");
		}

	}

}
