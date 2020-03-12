package pattern;

public class Pattern21 {
	
	public static void main(String[] args) {
    
		for(int i=1;i<=5;i++)
		{
			
			for(int j=1;j<=5;j++)
			{
				if(j<=i)
				{
					if(j%2==0)
					{
						System.out.print(0); 
					}
					else
					{
						System.out.print(1); 
					}
					
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
