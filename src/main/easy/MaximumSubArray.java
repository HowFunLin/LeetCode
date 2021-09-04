package main.easy;

public class MaximumSubArray
{
	public int maxSubArray(int[] nums) {
		int max = nums[0];
		int prev = max;
		int now;
		
		for(int i = 1; i < nums.length; i++)
		{
			if(nums[i] + prev > nums[i])
				now = nums[i] + prev;
			else
				now = nums[i];
			
			if(now > max)
				max = now;
			
			prev = now;
		}
		
		return max;
    }
}
