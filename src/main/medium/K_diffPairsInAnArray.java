package main.medium;

import java.util.Arrays;

@SuppressWarnings("unused")
public class K_diffPairsInAnArray {
    /**
     * 532. 数组中的 k-diff 数对
     *
     * @return 不同的 k-diff 数对 的数目。k-diff 数对定义为一个整数对 (nums[i], nums[j]) ，满足条件：nums[i] - nums[j] == k
     */
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1, right = nums.length - 1; // 二分查找不包括当前数

            while (left <= right) {
                int mid = (left + right) >> 1;

                if (nums[mid] - nums[i] > k)
                    right = mid - 1;
                else if (nums[mid] - nums[i] < k)
                    left = mid + 1;
                else {
                    res++;
                    break;
                }
            }
        }

        return res;
    }
}
