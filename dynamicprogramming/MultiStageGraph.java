
package dynamicprogramming;

public class MultiStageGraph {

	
	static int INF=Integer.MAX_VALUE;
	static int N=8;
	
	static int shortestDist(int[][] graph)
	{
		int[] T=new int[N];
		T[N-1]=0;
		for(int i=N-2;i>=0;i--)
		{
			T[i]=INF;
			for(int j=i+1;j<N;j++)
			{
				if(graph[i][j]==INF)
					continue;
				T[i]=Math.min(T[i],graph[i][j]+T[j]);
			}
		}
		return T[0];
	}
	
	  public static void main(String[] args)  
	    { 
	        // Graph stored in the form of an  
	        // adjacency Matrix  
	        int[][] graph = new int[][]{{INF, 1, 2, 5, INF, INF, INF, INF}, 
	        {INF, INF, INF, INF, 4, 11, INF, INF}, 
	        {INF, INF, INF, INF, 9, 5, 16, INF}, 
	        {INF, INF, INF, INF, INF, INF, 2, INF}, 
	        {INF, INF, INF, INF, INF, INF, INF, 18}, 
	        {INF, INF, INF, INF, INF, INF, INF, 13}, 
	        {INF, INF, INF, INF, INF, INF, INF, 2}}; 
	  
	        System.out.println(shortestDist(graph)); 
	    } 
}
