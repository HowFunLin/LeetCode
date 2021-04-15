package easy;

public class RepeatNumbersInArray
{
	public int findRepeatNumber(int[] nums) {
		int[] status = new int[nums.length];
		
		for(int i = 0; i < nums.length; i++)
			if(status[nums[i]]++ > 0)
				return nums[i];
		
		return -1;
    }
}
