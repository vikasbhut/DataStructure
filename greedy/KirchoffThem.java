package greedy;

public class KirchoffThem {

		static class Graph
		{
			static int V;
			static int[][] adjMatrix;
			Graph(int V)
			{
				this.V=V;
				adjMatrix=new int[V][V];
			}
			
			static void addEdge(int src,int des)
			{
			  adjMatrix[src][des]=1;	
			}
			
			static void printGraph()
			{
				for(int i=0;i<V;i++)
				{
					System.out.println("Adjencency List of Vertax :-"+i);
					for(int j=0;j<V;j++)
					{
						if(adjMatrix[i][j]!=0)
						{
			             System.out.print("-->"+j);
						}
					}
					System.out.println();
				}
			}
			static void Kirchoff()
			{
				int[] outdegree=new int[V];
				for (int i = 0; i < V; i++) {
					for(int j=0;j<V;j++)
					{
						if(adjMatrix[i][j]>0)
						{
							outdegree[i]++;
						}
					}
				}
				for (int i = 0; i < V; i++) {
					for(int j=0;j<V;j++)
					{
						if(i==j)
						{
							adjMatrix[i][j]=outdegree[i];
						}
						if(adjMatrix[i][j]==1)
						{
							adjMatrix[i][j]=-1;
						}
					}
				}
				
				
			}
	     }
		static int getDeterminate(int[][] a,int k)
		{
			int det,s=1;
			int b[][]=new int[k][k];
			if(k==1)
			{
				return a[0][0];
			}
			else
			{
				det=0;
				for(int c=0;c<k;c++)
				{
					getCofactor(a,b,0,c,k);
					det+=s*(a[0][c])*getDeterminate(b, k-1);
					s=s*-1;
				}
			}
			return det;
		}
		static void getCofactor(int[][] a, int[][] b, int p, int q, int k) {
			
			int i=0,j=0;
			for(int row=0;row<k;row++)
			{
				for(int col=0;col<k;col++)
				{
					if(row!=p&&col!=q)
					{
						b[i][j++]=a[row][col];
						
						if(j==k-1)
						{
							j=0;i++;
						}
					}
				}
			}
		}
		@SuppressWarnings("static-access")
		public static void main(String[] args) {
			
			Graph graph=new Graph(4);
			graph.addEdge(0,2);
			graph.addEdge(0,3);
			graph.addEdge(2,0);
			graph.addEdge(2,1);
			graph.addEdge(2,3);
			graph.addEdge(1,2);
			graph.addEdge(1,3);
			graph.addEdge(3,0);
			graph.addEdge(3,1);
			graph.addEdge(3,2);
			graph.Kirchoff();
			int[][] b=new int[4][4];
			getCofactor(graph.adjMatrix, b,0, 0, 4);
			System.out.println(getDeterminate(b,3));
		}
}

