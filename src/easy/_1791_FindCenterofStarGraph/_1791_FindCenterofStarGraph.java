package easy._1791_FindCenterofStarGraph;

public class _1791_FindCenterofStarGraph {
	
	/*
	 * here is an undirected star graph consisting of n nodes labeled from 1 to n. A
	 * star graph is a graph where there is one center node and exactly n - 1 edges
	 * that connect the center node with every other node.
	 */
	
	/*
	 * You are given a 2D integer array edges where each edges[i] = [ui, vi]
	 * indicates that there is an edge between the nodes ui and vi. Return the
	 * center of the given star graph.
	 */
			
	
//	       : edges = [[1,2],[2,3],[4,2]]
//			Output: 2

	/*
	 * Input: edges = [[1,2],[5,1],[1,3],[1,4]] Output: 1
	 */
	
	
    public static int findCenter(int[][] edges) {
    	int n = edges.length + 1; // Number of nodes in the graph
        int[][] graph = new int[n][n];
        
    	
        for (int[] arr : edges) {
            int source = arr[0] - 1; // Nodes are 1-indexed, converting to 0-indexed
            int target = arr[1] - 1;
            graph[source][target] = 1; // set adjacency
            graph[target][source] = 1; // set adjacency in reverse direction
        }
        
        // Rest of the logic to find the center of the star graph
        int center = 0;
        int maxDegree = 0;
        for (int i = 0; i < n; i++) {
            int degree = 0;
            for (int j = 0; j < n; j++) {
                degree += graph[i][j];
            }
            if (degree > maxDegree) {
                maxDegree = degree;
                center = i + 1; // Convert back to 1-indexed
            }
        }
        
        
    	
    	
    	
    	
    	
     
    	return center;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
