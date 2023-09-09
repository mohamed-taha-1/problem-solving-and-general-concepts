package general_all_concepts.collections.graph;

import static java.util.Arrays.fill;

import java.util.ArrayList;
import static java.util.Collections.reverse;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathBFS {

	private static int V; // Number of vertices
	private static LinkedList<Integer>[] adjList; // Adjacency list to represent the graph

	public ShortestPathBFS(int v) {
		V = v;
		adjList = new LinkedList[v];
		for (int i = 0; i < v; ++i) {
			adjList[i] = new LinkedList<>();
		}
	}

	// Add an edge to the graph
	public void addEdge(int v, int w) {
		adjList[v].add(w);
		adjList[w].add(v); // For an undirected graph
	}

	// Find the shortest path from source to destination using BFS
	public static List<Integer> shortestPath(int source, int destination) {
		boolean[] visited = new boolean[V];
		int[] parent = new int[V];
		
		fill(parent, -1);
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		
		visited[source] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			if (current == destination)
				break;

			for (int neighbor : adjList[current]) {
				if (!visited[neighbor]) {
					queue.add(neighbor);
					visited[neighbor] = true;
					parent[neighbor] = current;
				}
			}
		}

		// Reconstruct the shortest path
		List<Integer> shortest = new ArrayList<>();
		int current = destination;
		while (current != -1) {
			shortest.add(current);
			current = parent[current];
		}

		reverse(shortest);

		return shortest;
	}

	public static void main(String[] args) {
		ShortestPathBFS graph = new ShortestPathBFS(7);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);

		int source = 0;
		int destination = 6;

		System.out.println(
				"Shortest path from " + source + " to " + destination + ": " + shortestPath(source, destination));
	}

}
