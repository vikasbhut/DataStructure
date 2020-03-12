package greedy;

public class DijKastra {

	static class Graph {
		
		static int V=9;
		
		static int minDistVertex(boolean[] sptSet,int[] dist)
		{
			int min=Integer.MAX_VALUE,minDistVertex=-1;
			for(int i=0;i<V;i++)
			{
				if(sptSet[i]==false&&dist[i]<min)
				{
					min=dist[i];
					minDistVertex=i;
				}
			}
			return minDistVertex;
		}
		
		
		static void dijKastra(int[][] matrix,int src)
		{
			boolean[] sptSet=new boolean[V];
			int[] dist=new int[V];
			for(int i=0;i<V;i++)
			{
				dist[i]=Integer.MAX_VALUE;
			}
			dist[src]=0;
			for(int i=0;i<V;i++)
			{
				int u=minDistVertex(sptSet, dist);
				sptSet[u]=true;
				for(int v=0;v<V;v++)
				{
					if(sptSet[v]==false&&matrix[u][v]>0&&matrix[u][v]+dist[u]<dist[v])
					{
						dist[v]=matrix[u][v]+dist[u];
					}
				}
			}
			System.out.println("Dijkstra Algorithm:-");
			for(int i=0;i<V;i++)
			{
				System.out.println("Source Vertex "+src+" to "+i+" Distance: "+dist[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph();
		 int g[][] = new int[][] {{ 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
             { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
             { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
             { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
             { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
             { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
             { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
             { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
             { 0, 0, 2, 0, 0, 0, 6, 7, 0 }};
             graph.dijKastra(g,1);
            

	}
}
