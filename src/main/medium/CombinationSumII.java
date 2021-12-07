package main.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class CombinationSumII {
    private List<List<Integer>> list = new LinkedList<>();
    private LinkedList<Integer> track = new LinkedList<>();

    /**
     * 40. 组合总和 II
     *
     * @param candidates 数组
     * @param target     目标数
     * @return candidates 中所有可以使数字和为 target 的组合
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        recur(candidates, target, 0);

        return list;
    }

    /**
     * 回溯
     *
     * @param candidates 数组
     * @param target     目标数
     * @param index      当前索引
     */
    private void recur(int[] candidates, int target, int index) {
        if (target == 0) {
            list.add(new LinkedList<>(track));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // 当前下标对应的值已经大于目标数则无需继续遍历（有序数组）
            if (target - candidates[i] < 0)
                break;

            // 若当前索引为相同元素且未按顺序访问则直接寻找下一个索引
            if (i > index && candidates[i] == candidates[i - 1])
                continue;

            track.add(candidates[i]);
            recur(candidates, target - candidates[i], i + 1);
            track.removeLast();
        }
    }
}
