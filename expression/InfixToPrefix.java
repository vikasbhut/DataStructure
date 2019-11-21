package expression;
import java.util.Stack;

public class InfixToPrefix {

  static int Prec(char ch) {
    switch (ch) {
      case '+':
      case '-':
        return 1;

      case '*':
      case '/':
        return 2;
      case '^':
        return 3;
    }
    return -1;
  }

  static String infixToPrefix(String e) {

	  StringBuilder result=new StringBuilder();
	  Stack<Character> stack=new Stack<>();
	  StringBuilder exp=new StringBuilder(e);
	  exp=exp.reverse();
	  for(int i=0;i<exp.length();i++)
		{
			char ch=exp.charAt(i);
			if(Character.isLetterOrDigit(ch))
			{
				result.append(ch);
			}
			else if(ch==')')
			{
				stack.push(ch);
			}
			else if(ch=='(')
			{
				while(!stack.isEmpty()&&stack.peek()!=')')
					result.append(stack.pop());
				
				if(!stack.isEmpty()&&stack.peek()!=')')
					return "Invalid Expression";
				else
					stack.pop();
			}
			else
			{
				while(!stack.isEmpty()&&Prec(ch)<=Prec(stack.peek()))
				{
					if(stack.peek()==')')
						return "Invalid Expression";
					result.append(stack.pop());
				}
				stack.push(ch);
			}
			}
	  while (!stack.isEmpty()) {
	  result.append(stack.pop());
  }
	return result.reverse().toString();
  }

  public static void main(String[] args) {

    String exp = "a+b*c-d/e^f";
    System.out.println(infixToPrefix(exp));
  }
}
