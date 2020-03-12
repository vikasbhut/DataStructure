 package pattern;

public class Pattern17 {
	
	public static void main(String[] args) {
    
		for(int i=1;i<=4;i++)
		{
			char ch='A';
			for(int j=1;j<=9;j++)
			{
				if(j>=5-i&&j<=3+i)
				{
					System.out.print(ch);
					if(j>=4)
					{ch--;}
					else
					{ch++;}
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
