package main.medium;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Combinations {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();

    /**
     * 77. 组合
     *
     * @param n 整数
     * @param k 整数
     * @return 范围 [1, n] 中所有可能的 k 个数的组合
     */
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);

        return res;
    }

    /**
     * 回溯
     *
     * @param index 起始下标
     * @param n     整数
     * @param k     整数
     */
    private void backtrack(int index, int n, int k) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i <= n; i++) {
            temp.add(i);
            backtrack(i + 1, n, k);
            temp.remove(temp.size() - 1);
        }
    }
}
