package pattern;

public class Pattern13 
{
	public static void main(String[] args) {
   
	
		int k=0;
		
		for(int i=1;i<=9;i++)
			{
			int cnt=1;
			if(i<=5)
				{
					k++;
				}
				else
				{
					k--;
				}
					
				
				for(int j=1;j<=5;j++)
				{
					if(j>=6-k)
					{
						System.out.print(cnt); 
						cnt++;
					}
					else
					{
						System.out.print(" "); 
					}
				}
				System.out.println(""); 
			}
  }
}
