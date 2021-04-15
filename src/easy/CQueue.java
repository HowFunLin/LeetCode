package easy;

import java.util.Stack;

public class CQueue
{
	private Stack<Integer> head;
	private Stack<Integer> tail;

	public CQueue()
	{
		head = new Stack<Integer>();
		tail = new Stack<Integer>();
	}

	public void appendTail(int value)
	{
		tail.push(value);
	}

	public int deleteHead()
	{
		if (head.isEmpty())
			while (!tail.isEmpty())
				head.push(tail.pop());

		return head.isEmpty() ? -1 : head.pop();
	}
}
