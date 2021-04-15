package medium;

import java.util.Stack;

public class EvaluateReversePolishNotation
{
	public int evalRPN(String[] tokens)
	{
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < tokens.length; i++)
		{
			if(tokens[i].equals("+"))
				stack.push(stack.pop() + stack.pop());
			else if(tokens[i].equals("-"))
			{
				int b = stack.pop();
				int a = stack.pop();
				
				stack.push(a - b);
			}
			else if(tokens[i].equals("*"))
				stack.push(stack.pop() * stack.pop());
			else if(tokens[i].equals("/"))
			{
				int b = stack.pop();
				int a = stack.pop();
				
				stack.push(a / b);
			}
			else
				stack.push(Integer.valueOf(tokens[i]));
		}
		
		return stack.peek();
	}
}