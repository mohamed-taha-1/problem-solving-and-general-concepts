package general_all_concepts.collections;

import java.util.LinkedList;

public class Graph {

	private int vertices;
	private LinkedList<Integer>[] adjecancyList;
	
	
	@SuppressWarnings("unchecked")
	public Graph(int vertices) {
		this.vertices=vertices;
		this.adjecancyList=new LinkedList[vertices];
		
		for (int i = 0; i < vertices; i++) {
			 adjecancyList[i] = new LinkedList<>();
	        }
	}
	
	
	 public void addEdge(int source, int destination) {
	       adjecancyList[source].add(destination);
	       adjecancyList[destination].add(source); // For undirected graph
	    }
	
	 
	 public void printGraph() {
	        for (int i = 0; i < vertices; i++) {
	            System.out.print("Vertex " + i + " is connected to: ");
	            for (int neighbor : adjecancyList[i]) {
	                System.out.print(neighbor + " ");
	            }
	            System.out.println();
	        }
	    }
	 

	
	
	public static void main(String[] args) {
    		  int numVertices = 4;
	        Graph graph = new Graph(numVertices);
	        graph.addEdge(0, 1);
	        graph.addEdge(0, 2);
	        graph.addEdge(1, 2);
	        graph.addEdge(1, 3);
	        graph.printGraph();


	}

}
