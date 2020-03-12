package dynamicprogramming;

public class KnapscakRecursive {

	static int knapSack(int W,int[] wt,int[] val,int n)
	{
		if(W==0||n==0)
			return 0;
		else if(wt[n-1]<=W)
			return Math.max(val[n-1]+knapSack(W-wt[n-1], wt, val, n-1),knapSack(W, wt, val, n-1));
		else 
			return knapSack(W, wt, val, n-1);
	}
	
	
	public static void main(String args[]) 
	   { 
	        int val[] = new int[]{60, 100, 120}; 
	        int wt[] = new int[]{10, 20, 30}; 
	    int  W = 50; 
	    int n = val.length; 
	    System.out.println(knapSack(W, wt, val, n)); 
	    } 
}
