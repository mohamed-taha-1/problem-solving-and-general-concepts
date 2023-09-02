package medium._2477_MinimumFuelCosttoReporttotheCapital;

import java.util.ArrayList;
import java.util.List;

public class _2477_MinimumFuelCosttoReporttotheCapital {

	// There is a tree (i.e., a connected, undirected graph with no cycles)
	// structure country network consisting of n cities
	// and exactly n - 1 roads.
	// The capital city is city 0

	// You are given a 2D integer array roads ; where roads[i] = [ai, bi] denotes
	// that there exists a bidirectional road connecting cities ai and bi

	/*
	 * -- anther spooky There is a meeting for the representatives of each city. The
	 * meeting is in the capital city.
	 * 
	 * <T> There is a car in each city. You are given an integer seats that
	 * indicates the number of seats in each car.
	 * 
	 * 
	 * <P> A representative can use the car in their city to travel or change the
	 * car and ride with another representative.
	 * 
	 * <NA> The cost of traveling between two cities is one liter of fuel.
	 * 
	 * 
	 * <T> Return the minimum number of liters of fuel to reach the capital city.
	 * 
	 * roads = [[0,1],[0,2],[0,3]], seats = 5
	 *
	 *
	 * roads = [[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]], seats = 2
	 */

	private static long numOfLiters; // Declare numOfLiters as a long

	public static long minimumFuelCost(int[][] roads, int seats) {
		int n = roads.length + 1;
		List<List<Integer>> adjacencyList = new ArrayList<>(n);

		for (int i = 0; i < n; i++) {
			adjacencyList.add(new ArrayList<>());
		}

		for (int[] road : roads) {
			int u = road[0];
			int v = road[1];
			adjacencyList.get(u).add(v);
			adjacencyList.get(v).add(u);
		}

		numOfLiters = 0L; // Initialize numOfLiters to 0
		DFS(adjacencyList, 0, -1, seats);

		System.out.println(Math.ceil((double) 3 / 4));// for test
		return numOfLiters;
	}

	private static int DFS(List<List<Integer>> adjacencyList, int node, int parent, int seats) {
		int rep = 1;
		for (int neighbor : adjacencyList.get(node)) {
			if (neighbor != parent) {
				rep += DFS(adjacencyList, neighbor, node, seats);
			}
		}

		if (node != 0) {
			numOfLiters += (long) Math.ceil((double) rep / seats); // Use Math.ceil and cast to long
		}

		return rep;
	}

	public static void main(String[] args) {
		int[][] roads = { { 3, 1 }, { 3, 2 }, { 1, 0 }, { 0, 4 }, { 0, 5 }, { 4, 6 } };
		int seats = 2;
		System.out.println(minimumFuelCost(roads, seats));

	}

}
