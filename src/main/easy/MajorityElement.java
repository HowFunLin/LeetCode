package main.easy;

public class MajorityElement
{
	public int majorityElement(int[] nums) {
		int vote = 0, x = 0;
		
		for(int i = 0; i < nums.length; i++)
		{
			if(vote == 0)
				x = nums[i];
			
			vote += nums[i] == x ? 1 : -1;
		}
		
		return x;
    }
}
