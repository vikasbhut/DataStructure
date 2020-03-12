package greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Kruskal {

	static class Edge {

		int src, dest, weight;

		public Edge(int source, int destination, int weight) {
            this.src = source;
            this.dest = destination;
            this.weight = weight;
        }
	
	}
	static int V;
	static ArrayList<Edge> allEdges=new ArrayList<>();
	public Kruskal(int V) {
		Kruskal.V=V;
	}
	
	static void addEdge(int src,int dest,int weight)
	{
		allEdges.add(new Edge(src,dest,weight));
	}
	
	static void kruskalMST()
	{
		
		PriorityQueue<Edge> queue=new PriorityQueue<>(new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight-o2.weight;
			}
		});
		
		for(int i=0;i<allEdges.size();i++)
		{
			queue.add(allEdges.get(i));
		}
		int[] parent=new int[V];
		int[] rank=new int[V];
		
		makeSet(parent);
		
		int edgeCount=0;
		ArrayList<Edge> res=new ArrayList<>();
		while(edgeCount<V-1)
		{
			Edge edge=queue.poll();
		    int x=find(parent, edge.src);
		    int y=find(parent,edge.dest);
		    if(x!=y)
		    {
		    	edgeCount++;
		    	res.add(edge);
		    	union(parent, rank, x, y);
		    }
		}
		
		 for (int i = 0; i <res.size() ; i++) {
             Edge edge = res.get(i);
             System.out.println("Edge-" + i + " source: " + edge.src +
                     " destination: " + edge.dest+
                     " weight: " + edge.weight);
         }
	}
	static void makeSet(int[] parent)
	{
		for(int i=0;i<V;i++)
		{
			parent[i]=i;
		}
	}
	static int find(int[] parent,int i)
	{
		if(parent[i]==i)
		{
			return i;
		}
		else
		{
			int res=find(parent,parent[i]);
			parent[i]=res;
			return res;
		}
	}
	static void union(int[] parent,int[] rank,int x,int y)
	{
		int xRoot=find(parent, x),yRoot=find(parent, y);
		if(xRoot==yRoot)
			return;
		else if(rank[xRoot]<rank[yRoot])
			parent[xRoot]=yRoot;
		else if(rank[yRoot]<rank[xRoot])
			parent[yRoot]=xRoot;
		else
		{
			parent[yRoot]=xRoot;
			rank[xRoot]++;
		}
	}
	  public static void main(String[] args) {
          int vertices = 6;
          Kruskal graph = new Kruskal(vertices);
          graph.addEdge(0, 1, 4);
          graph.addEdge(0, 2, 3);
          graph.addEdge(1, 2, 1);
          graph.addEdge(1, 3, 2);
          graph.addEdge(2, 3, 4);
          graph.addEdge(3, 4, 2);
          graph.addEdge(4, 5, 6);
          graph.kruskalMST();
  }
	
}
