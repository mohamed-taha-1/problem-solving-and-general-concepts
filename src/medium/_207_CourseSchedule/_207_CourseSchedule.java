package medium._207_CourseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _207_CourseSchedule {

	/*
	 * For example, the pair [0, 1], indicates that to take course 0 you have to
	 * first take course 1. Return true if you can finish all courses. Otherwise,
	 * return false.
	 */

//	      Input: numCourses = 2, prerequisites = [[1,0]]
//			Output: true

//	       Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//			Output: false

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses]; // To track the number of prerequisites for each course

		// Count the number of prerequisites for each course
		for (int[] prerequisite : prerequisites) {
			indegree[prerequisite[0]]++;
		}

		// Find courses that have no prerequisites
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}

		int coursesTaken = queue.size();

		// Process courses with no prerequisites and update the indegree of their
		// dependencies
		while (!queue.isEmpty()) {
			int course = queue.poll();
			for (int[] prerequisite : prerequisites) {
				if (prerequisite[1] == course) {
					indegree[prerequisite[0]]--;
					if (indegree[prerequisite[0]] == 0) {
						queue.add(prerequisite[0]);
						coursesTaken++;
					}
				}
			}
		}

		return coursesTaken == numCourses;
	}

	public static boolean canFinish2(int numCourses, int[][] prerequisites) {
		// use adjecency matrix for grpah representaion

		 int[][] graph = new int[numCourses][numCourses];
	        for (int[] prerequisite : prerequisites) {
	            int course = prerequisite[0];
	            int prerequisiteCourse = prerequisite[1];
	            graph[course][prerequisiteCourse] = 1;
	        }
	        
	        boolean[] visited = new boolean[numCourses];
	        boolean[] recursionStack = new boolean[numCourses];
	        
	        for (int course = 0; course < numCourses; course++) {
	            if (!visited[course]) {
	                if (hasCycle(graph, course, visited, recursionStack)) {
	                    return false;
	                }
	            }
	        }
	        
	        return true;
	    }
	private static boolean hasCycle(int[][] graph, int course, boolean[] visited, boolean[] recursionStack) {
		visited[course] = true;
		recursionStack[course] = true;

		for (int i = 0; i < graph.length; i++) {
			if (graph[course][i] == 1) {
				if (!visited[i]) {
					if (hasCycle(graph, i, visited, recursionStack)) {
						return true;
					}
				} else if (recursionStack[i]) {
					return true;
				}
			}
		}

		recursionStack[course] = false;
		return false;

	}

	public static void main(String[] args) {
		int numCourses = 3;
		int[][] prerequisites = { { 1, 0 }, { 2, 1 }, { 3, 2 } };
		System.out.println(canFinish2(numCourses, prerequisites));

	}

}
