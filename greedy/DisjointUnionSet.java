package greedy;

public class DisjointUnionSet {

	int[] parent,rank;
	int n;
	
	public DisjointUnionSet(int n)
	{
		this.n=n;
		parent=new int[n];
		rank=new int[n];
		makeSet();
	}
	public void makeSet()
	{
		for(int i=0;i<n;i++)
		{
			parent[i]=i;
		}
	}
	public int find(int i)
	{
		if(parent[i]==i)
			return i;
		else
		{
			int res=find(parent[i]);
			parent[i]=res;
			return res;
		}
	}
	public void union(int x,int y)
	{
		int xRoot=find(x),yRoot=find(y);
		if(xRoot==yRoot)
			return;
		else if(rank[xRoot]<rank[yRoot])
		{
			parent[xRoot]=yRoot;
		}
		else if(rank[yRoot]<rank[xRoot])
		{
			parent[yRoot]=xRoot;
		}
		else
		{
			parent[yRoot]=xRoot;
			rank[xRoot]++;
		}
	}
	public static void main(String[] args) {
		// Let there be 5 persons with ids as 
        // 0, 1, 2, 3 and 4 
        int n = 5; 
        DisjointUnionSet dus =  
                new DisjointUnionSet(n); 
  
        // 0 is a friend of 2 
        dus.union(0, 2); 
  
        // 4 is a friend of 2 
        dus.union(4, 2); 
  
        // 3 is a friend of 1 
        dus.union(3, 1); 
  
        // Check if 4 is a friend of 0 
        if (dus.find(4) == dus.find(0)) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
  
        // Check if 1 is a friend of 0 
        if (dus.find(1) == dus.find(0)) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
    } 
	

}
