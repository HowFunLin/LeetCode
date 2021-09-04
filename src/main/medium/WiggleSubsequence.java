package main.medium;

/**
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * 
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 * 
 * @author Riyad
 *
 */
public class WiggleSubsequence
{
	public static void main(String[] args)
	{
		WiggleSubsequence ws = new WiggleSubsequence();

		int[] nums =
		{ 33, 53, 12, 64, 50, 41, 45, 21, 97, 35, 47, 92, 39, 0, 93, 55, 40, 46, 69, 42, 6, 95, 51, 68, 72, 9, 32, 84,
				34, 64, 6, 2, 26, 98, 3, 43, 30, 60, 3, 68, 82, 9, 97, 19, 27, 98, 99, 4, 30, 96, 37, 9, 78, 43, 64, 4,
				65, 30, 84, 90, 87, 64, 18, 50, 60, 1, 40, 32, 48, 50, 76, 100, 57, 29, 63, 53, 46, 57, 93, 98, 42, 80,
				82, 9, 41, 55, 69, 84, 82, 79, 30, 79, 18, 97, 67, 23, 52, 38, 74, 15 };

		System.out.println(ws.wiggleMaxLength(nums));
	}

	/**
	 * 摆动序列
	 * 
	 * @param nums 整数序列
	 * @return 作为摆动序列的最长子序列的长度
	 */
	public int wiggleMaxLength(int[] nums)
	{
		int n = nums.length;
		if (n < 2)
			return n;

		int count = 1;
		for (int i = 1, prev_diff = 0; i < n; i++)
		{
			int diff = nums[i] - nums[i - 1];
			
			if (diff < 0)
			{
				if (prev_diff >= 0)
					count++;

				prev_diff = -1;
			}
			else if (diff > 0)
			{
				if (prev_diff <= 0)
					count++;

				prev_diff = 1;
			}
		}
		
		return count;
	}
}
