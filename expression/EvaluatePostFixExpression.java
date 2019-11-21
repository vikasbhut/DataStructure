package expression;
import java.util.Stack;

public class EvaluatePostFixExpression {
	
	

	static int evaluatePostfix(String exp)
	{
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<exp.length();i++)
		{
			char ch=exp.charAt(i);
			if(Character.isDigit(ch))
			{
				stack.push(ch-'0');
			}
			else
			{
				int no2=stack.pop();
				int no1=stack.pop();
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
	
	
	 public static void main(String[] args)  
	    { 
	        String exp="231*+9-"; 
	        System.out.println("postfix evaluation: "+evaluatePostfix(exp)); 
	    } 
}
