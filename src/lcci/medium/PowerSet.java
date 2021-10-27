package lcci.medium;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class PowerSet {
    private List<Integer> temp = new ArrayList<>(); // 临时集合
    private List<List<Integer>> res = new ArrayList<>(); // 结果集合

    /**
     * 面试题 08.04. 幂集
     *
     * @param nums 集合，集合不包含重复的元素
     * @return 集合的所有子集
     */
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    /**
     * 回溯
     *
     * @param nums  集合
     * @param start 遍历起始索引
     */
    private void backtrack(int[] nums, int start) {
        res.add(new ArrayList<>(temp));

        // 由于不存在重复元素，无需遍历之前元素
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);

            backtrack(nums, i + 1);

            temp.remove(temp.size() - 1);
        }
    }
}
