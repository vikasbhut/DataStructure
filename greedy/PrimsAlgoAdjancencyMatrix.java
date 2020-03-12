package greedy;

public class PrimsAlgoAdjancencyMatrix {

	static class Graph {
		static int[][] matrix;
		static int vertices;

		Graph(int vertices) {
			this.vertices = vertices;
			matrix = new int[vertices][vertices];
		}

		static void addEdge(int src, int dest, int weight) {
			matrix[src][dest] = weight;
			matrix[dest][src] = weight;
		}

		static int getMinVertex(boolean[] mst, int[] key) {
			int minvertex=-1;
			int min=Integer.MAX_VALUE;
			for(int i=0;i<vertices;i++)
			{
				if(mst[i]==false&&key[i]<min)
				{
					min=key[i];
					minvertex=i;
				}
			}
			return minvertex;
		}

		class ResultSet {
			int parent;
			int weight;
		}

		void primsMST() {
			boolean[] mst=new boolean[vertices];
			int[] key=new int[vertices];
			ResultSet[] resultSet=new ResultSet[vertices];
			for(int i=0;i<vertices;i++)
			{
				key[i]=Integer.MAX_VALUE;
				resultSet[i]=new ResultSet();
			}
			key[0]=0;
			resultSet[0].parent=-1;
			for(int i=0;i<vertices;i++)
			{
				int vertex=getMinVertex(mst, key);
				mst[vertex]=true;
				for(int j=0;j<vertices;j++)
				{
					if(mst[j]==false&&matrix[vertex][j]>0&&matrix[vertex][j]<key[j])
					{
						key[j]=matrix[vertex][j];
						resultSet[j].parent=vertex;
						resultSet[j].weight=key[j];
					}
				}
			}
			printMST(resultSet);
		}
		  public void printMST(ResultSet[] resultSet){
	            int total_min_weight = 0;
	            System.out.println("Minimum Spanning Tree: ");
	            for (int i = 1; i <vertices ; i++) {
	                System.out.println("Edge: " + i + " - " + resultSet[i].parent +
	                        " key: " + resultSet[i].weight);
	                total_min_weight += resultSet[i].weight;
	            }
	            System.out.println("Total minimum key: " + total_min_weight);
	        }
	}

	public static void main(String[] args) {
		Graph graph = new Graph(6);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 3, 2);
		graph.addEdge(2, 3, 4);
		graph.addEdge(3, 4, 2);
		graph.addEdge(4, 5, 6);
		graph.primsMST();
	}

}
