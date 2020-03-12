
package dynamicprogramming;

public class MatrixMultiplicationTopdown {

	
	static int Memoized_Matrix_Chain(int[] p,int n)
	{
		int[][] m=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				m[i][j]=Integer.MAX_VALUE;
		return Lookup_Chain(m, p,1,n-1);
	}
	static int Lookup_Chain(int[][] m,int[] p,int i,int j)
	{
		if(m[i][j]<Integer.MAX_VALUE)
			return m[i][j];
		if(i==j)
			m[i][j]=0;
		else
		{
			for(int k=i;k<=j-1;k++)
			{
				int min=Lookup_Chain(m, p, i, k)+Lookup_Chain(m, p, k+1, j)+p[i-1]*p[k]*p[j];
				if(min<m[i][j])
				{
					m[i][j]=min;
				}
			}
		}
		return m[i][j];
	}
	
	public static void main(String[] args) {
		 int arr[] = new int[] {1, 2, 1,4,1}; 
	        int size = arr.length; 
	  
	        System.out.println("Minimum number of multiplications is "+ 
	                           Memoized_Matrix_Chain(arr, size)); 
	}
}
