package expression;
import java.util.Stack;

public class EvaluationOfPrefixExpression {
	
	
	static int evaluatePrefix(String exp)
	{
		Stack<Integer> stack=new Stack<>();
		
		for (int i =exp.length()-1; i >=0; i--) {
      
			char ch=exp.charAt(i);
			if(Character.isDigit(ch))
			{
				stack.push(ch-'0');
			}
			else
			{
				int no1=stack.pop();
			    int no2=stack.pop();
				 
		 	    switch (ch) {
		 	    case '+':
        	  		stack.push(no1+no2);
        	  		break;
		 	   case '-':
       	  		stack.push(no1-no2);
       	  		break;
       	  	
		 	  case '*':
      	  		stack.push(no1*no2);
      	  		break;
      	  	
		 	 case '/':
     	  		stack.push(no1/no2);
     	  		break;
     	  	}
		}
			
		 }
    return stack.pop();
			}
	
	
	public static void main(String[] args) {
		  String exp="+9*26"; 
	      System.out.println("postfix evaluation: "+evaluatePrefix(exp));
  }
}
