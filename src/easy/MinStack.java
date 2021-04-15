package easy;

import java.util.Stack;

public class MinStack
{
	private Stack<Integer> stack;
	private Stack<Integer> minStack;
	
	public MinStack() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
		minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
    	stack.push(val);
    	minStack.push(Math.min(val, minStack.peek()));
    }
    
    public void pop() {
    	stack.pop();
    	minStack.pop();
    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int getMin() {
    	return minStack.peek();
    }
}
