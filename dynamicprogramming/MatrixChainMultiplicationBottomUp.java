package dynamicprogramming;

public class MatrixChainMultiplicationBottomUp {

	static int MatrixChainOrder(int[] p,int n)
	{
		int i,j,k,l,q;
		int[][] m=new int[n][n];
		for(i=1;i<n;i++)
			m[i][i]=0;
		for(l=2;l<n;l++)
		{
			for(i=1;i<n-l+1;i++)
			{
				j=i+l-1;
				m[i][j]=Integer.MAX_VALUE;
				for(k=i;k<=j-1;k++)
				{
					q=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
					if(q<m[i][j])
					{
						m[i][j]=q;
					}
				}
			}
		}
		return m[1][n-1];
	}
	
	public static void main(String[] args) {
		  int arr[] = new int[] {1, 2, 1,4,1}; 
	        int size = arr.length; 
	  
	        System.out.println("Minimum number of multiplications is "+ 
	                           MatrixChainOrder(arr, size)); 
	}
}
