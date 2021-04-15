package easy;

public class TwoSumEqualsS
{
	public int[] twoSum(int[] nums, int target)
	{
		int i = 0, j = nums.length - 1;
		
		while(i != j)
		{
			if(nums[i] + nums[j] > target)
				j--;
			else if(nums[i] + nums[j] < target)
				i++;
			else
			{
				int[] result = new int[2];
				
				result[0] = nums[i];
				result[1] = nums[j];
				
				return result;
			}
		}
		
		return new int[0];
	}
}
