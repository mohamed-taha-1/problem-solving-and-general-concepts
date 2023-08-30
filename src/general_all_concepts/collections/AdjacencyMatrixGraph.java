package general_all_concepts.collections;

public class AdjacencyMatrixGraph {
	private int V; // Number of vertices
	private int[][] matrix;

	public AdjacencyMatrixGraph(int v) {
		V = v;
		matrix = new int[V][V];
	}

	public void addEdge(int v, int w) {
		matrix[v][w] = 1;
		matrix[w][v] = 1; // If the graph is undirected
	}

	public void printGraph() {
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		AdjacencyMatrixGraph g = new AdjacencyMatrixGraph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);

		System.out.println("Adjacency Matrix Representation of the Graph:");
		g.printGraph();

	}

}
