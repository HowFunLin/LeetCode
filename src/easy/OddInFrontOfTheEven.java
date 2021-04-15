package easy;

public class OddInFrontOfTheEven
{
	public int[] exchange(int[] nums) {
		int end = nums.length - 1;
		int temp;
		
		all: for(int i = 0; i < nums.length; i++)
		{
			
			if(nums[i] % 2 == 0)
			{
				while(nums[end] % 2 != 1)
				{
					end--;
					
					if(i >= end)
						break all;
				}
				temp = nums[i];
				nums[i] = nums[end];
				nums[end] = temp;
			}
		}
		
		return nums;
    }
}
