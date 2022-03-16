package main.easy;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class ContainsDuplicateII {
    /**
     * 219. 存在重复元素 II
     *
     * @param nums 整数数组
     * @param k    整数
     * @return 数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int right = 0;

        for (; right <= k && right < nums.length; right++) // 初始化前 k 个数
            if (!set.add(nums[right]))
                return true;

        for (int left = 0; right < nums.length; left++, right++) { // 保持窗口大小为 right - left == k
            set.remove(nums[left]);

            if (!set.add(nums[right]))
                return true;
        }

        return false;
    }
}
