package main.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class CombinationSum {
    private List<Integer> temp = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    /**
     * 39. 组合总和
     *
     * @param candidates 无重复元素的正整数数组，数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的
     * @param target     目标和
     * @return 所有可以使数字和为目标数 target 的唯一组合
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        recall(candidates, target, 0, 0);

        return res;
    }

    /**
     * 回溯算法
     *
     * @param candidates 无重复元素的正整数数组，数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的
     * @param target     目标和
     * @param sum        当前集合的和
     * @param begin      数组起始访问的下标（数组已排序，存在确保相同数量的某个数字的集合只会出现一次）
     */
    private void recall(int[] candidates, int target, int sum, int begin) {
        if (sum > target)
            return;

        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            temp.add(candidates[i]);
            recall(candidates, target, sum + candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}
