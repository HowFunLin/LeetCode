package main.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class MinimumSubsequenceInNon_IncreasingOrder {
    /**
     * 1403. 非递增顺序的最小子序列
     *
     * @return 长度最小 的满足元素之和 严格 大于未包含在该子序列中的各元素之和的 元素之和最大 的子序列，应当按 非递增顺序 排列
     */
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);

        int total = 0;

        for (int num : nums)
            total += num;

        List<Integer> res = new LinkedList<>();
        int sum = 0;

        // sum 必须 > total，注意 sum == total 的情况
        for (int i = nums.length - 1; i >= 0 && sum <= total; i--) {
            int cur = nums[i];

            sum += cur;
            total -= cur;

            res.add(cur);
        }

        return res;
    }
}
