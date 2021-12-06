package main.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class PermutationsII {
    private List<List<Integer>> list = new LinkedList<>();
    private List<Integer> track = new LinkedList<>();
    private boolean[] visited;

    /**
     * 47. 全排列 II
     *
     * @param nums 包含重复数字的序列
     * @return 所有不重复的全排列
     */
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];

        Arrays.sort(nums);
        recur(nums, 0);

        return list;
    }

    /**
     * 回溯
     *
     * @param nums  包含重复数字的序列
     * @param index 当前遍历数字个数
     */
    private void recur(int[] nums, int index) {
        if (index == nums.length) {
            list.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 若当前索引已被访问或未按顺序访问则直接寻找下一个索引
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]))
                continue;

            track.add(nums[i]);
            visited[i] = true;
            recur(nums, index + 1);
            visited[i] = false;
            track.remove(index);
        }
    }
}
