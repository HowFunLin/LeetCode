package main.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class SubsetsII {
    private List<List<Integer>> list = new LinkedList<>();
    private LinkedList<Integer> track = new LinkedList<>();
    private boolean[] visited;

    /**
     * 90. 子集 II
     *
     * @param nums 包含重复元素的数组
     * @return 数组所有可能的子集（幂集）。解集 不能 包含重复的子集
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        visited = new boolean[nums.length];

        Arrays.sort(nums);
        recur(nums, 0);

        return list;
    }

    /**
     * 回溯
     *
     * @param nums  包含重复数字的序列
     * @param index 当前遍历索引
     */
    private void recur(int[] nums, int index) {
        list.add(new LinkedList<>(track));

        if (index >= nums.length)
            return;

        for (int i = index; i < nums.length; i++) {
            // 若当前索引未按顺序访问则直接寻找下一个索引
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;

            track.add(nums[i]);
            visited[i] = true;
            recur(nums, i + 1);
            visited[i] = false;
            track.removeLast();
        }
    }
}
