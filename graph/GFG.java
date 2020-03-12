package graph;

import java.util.LinkedList;

public class GFG {

	
  static class Graph
  {
	  int V;
	  LinkedList<Integer>[] adjListArray;
	  Graph(int V)
	  {
		  this.V=V;
		  adjListArray=new LinkedList[V];
		  for(int i=0;i<V;i++)
		  {
			  adjListArray[i]=new LinkedList<>();
		  }
	  }
  }
	  
	  
	  static void addEdge(Graph graph,int src,int dest)
	  {
		 graph.adjListArray[src].add(dest);
		 graph.adjListArray[dest].add(src);
	  }
	  
	  static void printGraph(Graph graph)
	  {
		 for(int i=0;i<graph.V;i++)
		 {
		   System.out.println("Adjencency List of Vertax :-"+i);
		   System.out.print("Head");
		   for (Integer integer:graph.adjListArray[i]) {
			   
			   System.out.print("-->"+integer);
		  }
		   System.out.println("\n");
		 }
	  }

	  public static void main(String args[]) 
	    { 
	        // create the graph given in above figure 
	        int V = 5; 
	        Graph graph = new Graph(V); 
	        addEdge(graph, 0, 1); 
	        addEdge(graph, 0, 4); 
	        addEdge(graph, 1, 2); 
	        addEdge(graph, 1, 3); 
	        addEdge(graph, 1, 4); 
	        addEdge(graph, 2, 3); 
	        addEdge(graph, 3, 4); 
	       
	        // print the adjacency list representation of  
	        // the above graph 
	        printGraph(graph); 
	    } 


 
}
