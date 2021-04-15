package easy;

import java.util.LinkedList;

public class SlidingWindowMaximum
{
	public int[] maxSlidingWindow(int[] nums, int k)
	{
		int[] result = new int[nums.length + 1 - k];

		for (int i = 0; i <= nums.length - k; i++)
		{
			int max = Integer.MIN_VALUE;
			int index = i;

			while (k > 0)
			{
				if (nums[index] > max)
					max = nums[index];

				index++;
				k--;
			}

			System.out.println(i);
			result[i] = max;
		}

		return result;
	}
}

class SlidingWindowMaximumLeetCode extends SlidingWindowMaximum
{
	@Override
	public int[] maxSlidingWindow(int[] nums, int k)
	{
		if (nums.length == 0 || k == 0)
			return new int[0];
		LinkedList<Integer> deque = new LinkedList<>();
		int[] res = new int[nums.length - k + 1];
		// 未形成窗口
		for (int i = 0; i < k; i++)
		{
			while (!deque.isEmpty() && deque.peekLast() < nums[i])
				deque.removeLast();
			deque.addLast(nums[i]);
		}
		res[0] = deque.peekFirst();
		// 形成窗口后
		for (int i = k; i < nums.length; i++)
		{
			if (deque.peekFirst() == nums[i - k])
				deque.removeFirst();
			while (!deque.isEmpty() && deque.peekLast() < nums[i])
				deque.removeLast();
			deque.addLast(nums[i]);
			res[i - k + 1] = deque.peekFirst();
		}
		return res;
	}
}
