package medium;

import java.util.Arrays;

@SuppressWarnings("unused")
public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 1)
            return 1;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) // 遍历原数组
        {
            for (int j = 0; j < i; j++) // 找出当前数字之前是否有更小的数字，如果加上它之后比原有长度更长，则加上
            {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int max = 0;

        for (int i = 0; i < nums.length; i++)
            max = Math.max(max, dp[i]);

        return max;

        // 使用二分查找的做法
//        int n = nums.length;
//        int[] top = new int[n];
//        int heaps = 0;
//
//        for (int i = 0; i < n; i++)
//        {
//            int now = nums[i];
//
//            int left = 0, right = heaps;
//            while (left < right)
//            {
//                int mid = left + (right - left) / 2;
//
//                if (top[mid] > now)
//                    right = mid;
//                else if (top[mid] < now)
//                    left = mid + 1;
//                else
//                    right = mid;
//            }
//
//            if (left == heaps)
//                heaps++;
//            top[left] = now;
//        }
//
//        return heaps;
    }
}
