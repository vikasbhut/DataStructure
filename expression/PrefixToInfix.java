package expression;

import java.util.Stack;

public class PrefixToInfix {
	static String getInfix(String exp)
	{
		Stack<String> stack=new Stack<>();
		
		for (int i = exp.length()-1; i >=0; i--) {
      
			char ch=exp.charAt(i);
			if(Character.isLetterOrDigit(ch))
			{
				stack.push(ch+"");
			}
			else
			{
				String str1=stack.pop();
				String str2=stack.pop();
				stack.push(str1+ch+str2);
			}
      
    }
		
	 return stack.pop();
	}
	
	
	public static void main(String args[]) 
	{ 
	    String exp = "+a*bc"; 
	    System.out.println( getInfix(exp)); 
	} 
}
