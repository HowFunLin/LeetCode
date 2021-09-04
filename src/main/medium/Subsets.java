package main.medium;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Subsets {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
