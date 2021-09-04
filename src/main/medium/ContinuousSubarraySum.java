package main.medium;

import java.util.HashSet;

@SuppressWarnings("unused")
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n + 1];

        for (int i = 1; i <= n; i++)
            sums[i] = sums[i - 1] + nums[i - 1];

        HashSet<Integer> set = new HashSet<>();

        for (int i = 2; i <= n; i++)
        {
            set.add(sums[i - 2] % k);

            if (set.contains(sums[i] % k))
                return true;
        }

        return false;
    }
}
