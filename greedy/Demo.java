package greedy;

public class Demo {

	static int determinate(int[][] a,int k)
	{
		int c,i,j,m,n,s=1,det;
		int[][] b=new int[k][k];
		if(k==1)
		{
			return a[0][0];
		}
		else
		{
			det=0;
			for (c = 0;  c< k; c++) {
				m=n=0;
				for(i=0;i<k;i++)
				{
					for(j=0;j<k;j++)
					{
						b[i][j]=0;
						if(i!=0&&j!=c)
						{
							b[m][n++]=a[i][j];
							if(n==k-1)
							{
								m++;
								n=0;
							}
						}
					}
				}
				det+=s*(a[0][c])*determinate(b, k-1);
				s=-1*s;
			}
			return det;
		}
		
	}
	public static void main(String[] args) 
	{ 
	    int A[][] = { {5, -2, 2, 7}, 
	                    {1, 0, 0, 3}, 
	                    {-3, 1, 5, 0}, 
	                    {3, -1, -9, 4}}; 
	  
	 System.out.println("Determinate :-"+determinate(A, 4));
	  
	} 
}
