package jianzhi.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class ThreeSum {
    /**
     * 剑指 Offer II 007. 数组中和为 0 的三个数
     *
     * @return nums 中所有和为 0 且 不重复 的三元组。 
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1])
                continue;

            int third = n - 1, target = -nums[first];

            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1])
                    continue;

                while (second < third && nums[second] + nums[third] > target)
                    third--;

                if (second == third) // 之后的循环只会超过 target 值，直接跳出循环
                    break;

                if (nums[second] + nums[third] == target)
                    res.add(Arrays.asList(nums[first], nums[second], nums[third]));
            }
        }

        return res;
    }
}
