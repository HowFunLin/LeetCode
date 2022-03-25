package main.easy;

import java.util.Arrays;

@SuppressWarnings("unused")
public class ArrayPartitionI {
    /**
     * 561. 数组拆分 I
     *
     * @param nums 长度为 2n 的整数数组
     * @return 将这些数分成 n 对，从 1 到 n 的 min(a, b) 的最大总和
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int res = 0;

        for (int i = 0; i < nums.length; i += 2)
            res += nums[i];

        return res;
    }
}
