package medium;

import java.util.Stack;

public class VerifyPreorderSerializationOfABinaryTree {
	public static void main(String[] args) {
		String preorder = 
				"9,3,4,#,#,1,#,#,2,#,6,#,#";
		System.out.println(isValidSerialization(preorder));
	}
	
	public static boolean isValidSerialization(String preorder) 
	{
		Stack<Integer> stack = new Stack<>();
		
		String[] split = preorder.split(",");
		
		for(int i = 0; i < split.length; i++)
		{
			if(stack.empty() && i != 0 && i < split.length)
				return false;
			
			if(!split[i].equals("#"))
			{
				if(!stack.empty()) {
					Integer peek = stack.peek();
					stack.pop();
					
					if(peek != 1)	
						stack.push(++peek);
				}
				
				stack.push(0);
			}
			else
			{
				if(split.length == 1)
					return true;
				
				if(stack.empty() && split.length > 1)
					return false;
				
				if(!stack.empty()) {
					Integer peek = stack.peek();
					stack.pop();
					
					if(peek != 1)	
						stack.push(++peek);
				}
			}
		}
		
		if(stack.empty())
			return true;
		else
			return false;
    }
}
