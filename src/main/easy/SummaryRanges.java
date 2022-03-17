package main.easy;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class SummaryRanges {
    /**
     * 228. 汇总区间
     *
     * @param nums 无重复元素 的 有序 整数数组
     * @return 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。
     * 列表中的每个区间范围 [a,b] 应该按如下格式输出："a->b" ，如果 a != b；"a" ，如果 a == b
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        if (nums.length == 0)
            return res;

        StringBuilder builder = new StringBuilder();
        int n = nums.length;

        builder.append(nums[0]);

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] != nums[i] - 1) {
                if (Integer.valueOf(builder.toString()) != nums[i - 1])
                    builder.append("->").append(nums[i - 1]);

                res.add(builder.toString());
                builder.delete(0, builder.length());
                builder.append(nums[i]);
            }
        }

        // 边界处理
        if (Integer.valueOf(builder.toString()) != nums[n - 1])
            builder.append("->").append(nums[n - 1]);

        res.add(builder.toString());

        return res;
    }
}
