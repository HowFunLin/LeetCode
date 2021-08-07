package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int max = 1;
        int index = 0;

        for (int i = 1; i < nums.length; i++) // 遍历原数组
            for (int j = 0; j < i; j++) {
                // 前驱索引只有在出现更大的值之后才需要修改，因此将比较放在判断条件，而不能像第300题一样使用max赋值
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j; // 该数字对应的上一个能整除的元素的位置
                }
                if (dp[i] > max) {
                    max = dp[i]; // 子数组的最大长度
                    index = i; // 最大子集最后一个元素的位置
                }
            }

        List<Integer> list = new ArrayList<Integer>();

        while (index != -1) {
            list.add(nums[index]);
            index = prev[index]; // 回溯，直至没有前驱索引
        }

        return list;
    }
}
