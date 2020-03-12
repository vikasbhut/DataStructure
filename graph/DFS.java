package graph;

import java.util.LinkedList;

class DFS {
	int V;
	LinkedList<Integer>[] adjList;
	DFS(int V)
	{
		this.V=V;
		adjList=new LinkedList[V];
		for(int i=0;i<V;i++)
		{
			adjList[i]=new LinkedList<>();
		}
	}
	void addEdge(int src,int des)
	{
		adjList[src].add(des);
		adjList[des].add(src);
	}
	void DFSUtil(boolean[] visited,int i)
	{
		visited[i]=true;
		System.out.print(i+" ");
		for(Integer integer:adjList[i])
		{
			if(!visited[integer])
			{
				DFSUtil(visited, integer);
			}
		}
	}
	void DFS()
	{
		boolean[] visited=new boolean[V];
		for(int i=0;i<V;i++)
		{
			if(!visited[i])
			{
				DFSUtil(visited, i);
				System.out.println();
			}
		}
	}




	public static void main(String args[]) {
		DFS g = new DFS(5);

		g.addEdge(1, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.DFS();
	}

}
