package main.medium;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class FourSumII {
    /**
     * 454. 四数相加 II
     *
     * @param nums1 长度为 n 的整数数组（nums2, nums3, nums4）
     * @return 有多少个元组 (i, j, k, l) 能满足：0 <= i, j, k, l < n；nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 两两相加并记录和，再两两相加比对和是否为 0，时间复杂度为 O(n^2)
        Map<Integer, Integer> map = new HashMap<>(); // <两数之和，出现次数>

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum12 = num1 + num2;

                map.put(sum12, map.getOrDefault(sum12, 0) + 1);
            }
        }

        int res = 0;

        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int sum34 = -(num3 + num4);

                if (map.containsKey(sum34))
                    res += map.get(sum34);
            }
        }

        return res;
    }
}
