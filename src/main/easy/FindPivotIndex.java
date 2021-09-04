package main.easy;

public class FindPivotIndex
{
	public int pivotIndex(int[] nums)
	{
		int suf = 0;
		int pre = 0;
		
		for(int i : nums)
			suf += i;
		
		for(int i = 0; i < nums.length; i++)
		{
			suf -= nums[i];
			
			if(pre == suf)
				return i;
			
			pre += nums[i];
		}
		
		return -1;
	}
}
