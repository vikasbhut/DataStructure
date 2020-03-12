package graph;

import java.util.LinkedList;


public class ToplologicalSort {

		int V;
		LinkedList<Integer>[] adj;
	     public ToplologicalSort(int V)
		{
			this.V=V;
			adj=new LinkedList[V];
			for(int i=0;i<V;i++)
			{
				adj[i]=new LinkedList<>();
			}
		}
		
		void addEdge(int src,int dest)
		{
			adj[src].add(dest);
		}
		
		void topoLogicalSort()
		{
			int[] inDegree=new int[V];
			LinkedList<Integer> q=new LinkedList<>();
			for(int i=0;i<V;i++)
			{
				for (Integer integer : adj[i]) {
					inDegree[integer]++;
				}
			}
			
			for(int i=0;i<V;i++)
			{
				if(inDegree[i]==0)
				{
					q.add(i);
				}
			}
			
			while(!q.isEmpty())
			{
				int s=q.poll();
				System.out.print(s+" ");
				for (Integer integer : adj[s]) {
					inDegree[integer]--;
					if(inDegree[integer]==0)
					{
						q.add(integer);
						inDegree[integer]--;
					}
				}
				
			}
		}
	public static void main(String[] args) {
		
		        // Create a graph given in the above diagram 
		       ToplologicalSort g=new ToplologicalSort(6);
		        g.addEdge(5, 2); 
		        g.addEdge(5, 0); 
		        g.addEdge(4, 0); 
		        g.addEdge(4, 1); 
		        g.addEdge(2, 3); 
		        g.addEdge(3, 1); 
		        System.out.println("Following is a Topological Sort"); 
		        g.topoLogicalSort(); 
		  
		 
	}
}
