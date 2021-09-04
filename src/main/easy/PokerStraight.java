package main.easy;

import java.util.Arrays;

public class PokerStraight
{
	public boolean isStraight(int[] nums) {
		Arrays.sort(nums);
		int zero = 0;
		
		for(int i = 0; i < nums.length - 1; i++)
		{
			if(nums[i] == 0)
			{
				zero++;
				continue;
			}
			
			if(nums[i + 1] - nums[i] == 0)
				return false;

			if(nums[i + 1] - nums[i] > 1)
			{
				zero -= nums[i + 1] - nums[i] - 1;
				
				if(zero < 0)
					return false;
			}
		}
		
		return true;
    }
}
