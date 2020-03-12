package dynamicprogramming;

public class SubsetSumDynamic {

	static boolean isSubsetSum(int[] set,int n,int sum)
	{
		boolean[][] subset=new boolean[n+1][sum+1];
		for(int i=0;i<=n;i++)
		{
			subset[i][0]=true;
		}
		for(int i=1;i<=sum;i++)
		{
			subset[0][i]=false;
		}
		for(int i=1;i<=n;i++)
		{
			for(int s=1;s<=sum;s++)
			{
				if(set[i-1]>s)
				{
					subset[i][s]=subset[i-1][s];
				}
				else
				{
					subset[i][s]=subset[i-1][s-set[i-1]]||subset[i-1][s];
				}
			}
		}
		return subset[n][sum];
	}
	
    public static void main (String args[]) 
    { 
        int set[] = {3, 34, 4, 12, 5, 2}; 
        int sum = 9; 
        int n = set.length; 
        if (isSubsetSum(set, n, sum) == true) 
            System.out.println("Found a subset"
                          + " with given sum"); 
        else
            System.out.println("No subset with"
                               + " given sum"); 
    } 
}
