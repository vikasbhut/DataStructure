package greedy;

public class Matrix {

	
	static void getCofactor(int[][] a,int[][] b,int p,int q,int k)
	{
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
						j=0;
						i++;
					}
				}
			}
		}
	}
	
	static int getDeterminate(int[][] a,int k)
	{
		int det,c,i,j,m,n,s=1;
		int[][] b=new int[k][k];
		
		if(k==1)
			return a[0][0];
		else
		{
			det=0;
			for(c=0;c<k;c++)
			{
				getCofactor(a, b,0, c, k);
				det+=s*(a[0][c]*getDeterminate(b, k-1));
				s=-1*s;
			}
		}
		return det;
	}
	
	
		public static void main(String[] args) 
		{ 
		    int A[][] = { {5, -2, 2, 7}, 
		                    {1, 0, 0, 3}, 
		                    {-3, 1, 5, 0}, 
		                    {3, -1, -9, 4}}; 
		  
		 System.out.println("Determinate:-"+getDeterminate(A, 4));
		  
		} 
	
}
