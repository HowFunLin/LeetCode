package main.easy;

public class MissingNumber
{
	public int missingNumber(int[] nums) {
		for(int i = 0; i < nums.length; i++)
			if(nums[i] != i)
				return i;
		return nums.length;
    }
}
