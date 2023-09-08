package medium._210_CourseScheduleII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _210_CourseScheduleII {
	/*
	 * There are a total of numCourses courses you have to take, labeled from 0 to
	 * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
	 * [ai, bi] indicates that you must take course bi first if you want to take
	 * course ai.
	 * 
	 * 
	 * For example, the pair [0, 1], indicates that to take course 0 you have to
	 * first take course 1.
	 * 
	 * Return the ordering of courses you should take to finish all courses. If
	 * there are many valid answers, return any of them. If it is impossible to
	 * finish all courses, return an empty array.
	 * 
	 * numCourses = 2, prerequisites = [[1,0]]
	 * 
	 * Output: [0,1] Explanation: There are a total of 2 courses to take. To take
	 * course 1 you should have finished course 0. So the correct course order is
	 * [0,1].
	 * 
	 * 
	 * 
	 * numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
	 * 
	 */

	public static int[] findOrder(int numCourses, int[][] prerequisites) {

		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int[] x : prerequisites) {
			adjList.get(x[1]).add(x[0]);
		}

		Stack<Integer> stack = new Stack<>();
		int[] visited = new int[numCourses];

		for (int i = 0; i < numCourses; i++) {
			if (visited[i] == 0 && !dfs(i, adjList, visited, stack)) {
				return new int[] {};

			}
		}

		int[] result = new int[numCourses];
		int index = 0;
		while (!stack.isEmpty()) {
			result[index++] = stack.pop();
		}

		return result;
	}

	private static boolean dfs(int node, List<List<Integer>> adjList, int[] visited, Stack<Integer> stack) {
		visited[node] = 1;

		for (int neighbor : adjList.get(node)) {
			if (visited[neighbor] == 1) {
				return false; // Cycle detected
			}
			if (visited[neighbor] == 0 && !dfs(neighbor, adjList, visited, stack)) {
				return false;
			}
		}

		visited[node] = 2;
		stack.push(node);
		return true;

	}

	public static void main(String[] args) {
		int numCourses = 4;
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));

	}

}
