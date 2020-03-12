package graph;

import java.util.LinkedList;

class Graph {

	int V;
	LinkedList<Integer>[] adjList;
	Graph(int V)
	{
		this.V=V;
		adjList=new LinkedList[V];
		for(int i=0;i<V;i++)
		{
			adjList[i]=new LinkedList<>();
		}
	}
	
	void addEdge(int src,int dest)
	{
		adjList[src].add(dest);
	}
	
	void BFS(int s)
	{
		boolean[] visited=new boolean[V];
		visited[s]=true;
		LinkedList<Integer> q=new LinkedList<>();
		q.add(s);
		while (!q.isEmpty()) {
			 s=q.poll();
			System.out.print(s+" ");
			for (Integer integer : adjList[s]) {
				if(!visited[integer])
				{
					visited[integer]=true;
					q.add(integer);
				}
			}
			
		}
	}


	
	

}

public class BFS {

	public static void main(String args[]) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.BFS(2);
	}

}
