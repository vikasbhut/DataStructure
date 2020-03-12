package greedy;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PrimsHeap {
	
	static class Node1
	{
		int dest,weight;
		public Node1(int dest,int weight)
		{
			this.dest=dest;
			this.weight=weight;
		}
	}
	static class Graph
	{
		static int V;
		static LinkedList<Node1>[] adjList;
		Graph(int V)
		{
			this.V=V;
			adjList=new LinkedList[V];
			for(int i=0;i<V;i++)
			{
				adjList[i]=new LinkedList<>();
			}
		}
		static void addEdge(int src,int dest,int weight)
		{
			adjList[src].add(new Node1(dest, weight));
			adjList[dest].add(new Node1(src, weight));
		}
		static class Node
		{
			int vertex;
			int parent;
			int weight;
		}
		static void primsMST()
		{
			boolean[] mst=new boolean[V];
			Node[] node=new Node[V];
			for(int i=0;i<V;i++)
			{
				node[i]=new Node();
				node[i].parent=-1;
				node[i].vertex=i;
				node[i].weight=Integer.MAX_VALUE;
			}
			PriorityQueue<Node> queue=new PriorityQueue<>(new Comparator<Node>() {

				@Override
				public int compare(Node arg0, Node arg1) {
					return arg0.weight-arg1.weight;
				}
			});
			for(int i=0;i<V;i++)
			{
				queue.add(node[i]);
			}
			node[0].weight=0;
			while(!queue.isEmpty())
			{
				Node u=queue.poll();
				mst[u.vertex]=true;
				for(Node1 node1:adjList[u.vertex])
				{
					if(mst[node1.dest]==false&&node1.weight<node[node1.dest].weight)
					{
						queue.remove(node[node1.dest]);
						node[node1.dest].weight=node1.weight;
						queue.add(node[node1.dest]);
						node[node1.dest].parent=u.vertex;
					}
				}
			}
			  int total_min_weight = 0;
	            System.out.println("Minimum Spanning Tree: ");
	            for (int i = 1; i <V ; i++) {
	                System.out.println("Edge: " + node[i].vertex + " - " + node[i].parent +
	                        " key: " +node[i].weight);
	                total_min_weight += node[i].weight;
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
