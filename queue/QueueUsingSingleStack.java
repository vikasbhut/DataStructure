package queue;

public class QueueUsingSingleStack {

public static void main(String[] args) {
	
	for (int i = 1; i <=4; i++) {

			int k=i;
			int t=8+i;
			int y=20;
		for(int j=1;j<=5;j++)
		{
			
			if(i==1||i==3)
			{
				if(i==1)
				{
					System.out.print(k );
					k++;
				}
				else
				{
					System.out.print(t );
					t++;
				}
			}
			else if(i==2||i==4)
			{
				if(i==2)
				{
					System.out.print(t );
					t--;
				}
				else
				{
					System.out.print(y );
					y--;
				}
			}
		}
		System.out.println("");
	}
}
}
