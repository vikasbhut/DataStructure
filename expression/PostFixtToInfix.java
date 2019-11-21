package expression;
import java.util.Stack;

public class PostFixtToInfix {
	
	static String getInfix(String exp)
	{
		Stack<String> stack=new Stack<>();
		
		for (int i = 0; i < exp.length(); i++) {
      
			char ch=exp.charAt(i);
			if(Character.isLetterOrDigit(ch))
			{
				stack.push(ch+"");
			}
			else
			{
				String str2=stack.pop();
				String str1=stack.pop();
				stack.push(str1+ch+str2);
			}
      
    }
		
		
		
		return stack.pop();
	}
	
	
	public static void main(String args[]) 
	{ 
	    String exp = "ab*c+"; 
	    System.out.println( getInfix(exp)); 
	} 
}
