package medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue
{
	private Queue<Integer> queue;
	private Deque<Integer> max;
	
	public MaxQueue()
	{
		queue = new LinkedList<Integer>();
		max = new LinkedList<Integer>();
	}

	public int max_value()
	{
		return max.isEmpty() ? -1 : max.peekFirst();
	}

	public void push_back(int value)
	{
		queue.offer(value);
		
		while(!max.isEmpty() && max.peekLast() < value)
			max.pollLast();
		
		max.offerLast(value);
	}

	public int pop_front()
	{
		if(queue.isEmpty())
			return -1;
		
		if(queue.peek() == max.peekFirst())
			max.pollFirst();
		
		return queue.poll();
	}
}
