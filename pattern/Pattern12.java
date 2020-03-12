package pattern;

public class Pattern12 {
	 public static void main(String[] args) {
		 
		 for(int i=0;i<7;i++)
		 {
			 int k=6-i;
			 for(int j=0;j<7;j++)
			 {
				 if(j<=6-i)
				 {
					 System.out.print(k);
					 k--;
				 }
			 }
			 System.out.println(""); 
		 }
		  
			
	  }
}
