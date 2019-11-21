package tree;

//2nCn/(n+1) unlabelled
//(2nCn/(n+1))*n! labelled
public class NoofBinaryTree {

	
	
	
	static int fact(int n)
	{
		int res=1;
		for(int i=1;i<=n;i++)
		{
			res*=i;
		}
		return res;
	}
	static int nCr(int n, int r) 
	{ 
	    return fact(n) / (fact(r) * fact(n - r)); 
	} 
	
	static int countBT(int n) 
	{ 
		return (nCr(2*n, n)/(n+1));
	} 
	 

	static int countBST(int n) 
	{ 
		return (nCr(2*n, n)/(n+1))*fact(n);
	} 
	
	public static void main(String[] args) {
		
		int n=3;
		int count1=countBST(n);
		int count2=countBT(n);
		
		
		  System.out.println("Count of BST with "+  
                  n +" nodes is "+  
                          count1); 
		
		System.out.println("Count of binary " +  
                  "trees with "+  
              n + " nodes is " +  
                        count2); 
		
	}
}
