package company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unused")
public class FiveEight {
    private int sum;
    private List<Integer> temp = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    /**
     * 最长无重复连续整数子序列
     *
     * @param arr 整数数组
     * @return 最长无重复连续整数子序列的长度
     */
    public int maxSubArrLength(int[] arr) {
        Set<Integer> set = new HashSet<>();

        int left = 0, right = 0;
        int length = 0;

        while (right < arr.length) {
            int c = arr[right];

            if (!set.contains(c)) {
                right++;
                set.add(c);

                length = Math.max(length, right - left);
                continue;
            }


            while (set.contains(c)) {
                int d = arr[left];
                left++;
                set.remove(d);
            }
        }

        return length;
    }

    /**
     * 根据所有可能的分数集合，返回符合题中条件的所有考试得分的组合。若无任何符合题中要求的得分组合，则返空集合。
     *
     * @param allScoreArray 可能的得分的集合
     * @param examCount     考试总次数
     * @param lastScore     最后一次考试分数
     * @return 符合题中要求的得分组合
     */
    public ArrayList<ArrayList<Integer>> process(int[] allScoreArray, int examCount, int lastScore) {
        backtrack(allScoreArray, 1, examCount, lastScore);

        return res;
    }

    /**
     * 回溯
     *
     * @param allScoreArray 可能的得分的集合
     * @param nowCount      当前考试的次数
     * @param examCount     考试总次数
     * @param lastScore     最后一次考试分数
     */
    private void backtrack(int[] allScoreArray, int nowCount, int examCount, int lastScore) {
        // 初始时 nowCount 设为 1 防止求余出错
        if (nowCount - 1 == examCount && temp.get(temp.size() - 1) == lastScore) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int score : allScoreArray) {
            if (temp.contains(score)) // 数据量小，直接遍历去重
                continue;

            if ((sum + score) % nowCount != 0) // 剪枝
                continue;

            temp.add(score);
            sum += score;

            backtrack(allScoreArray, nowCount + 1, examCount, lastScore);

            temp.remove(temp.size() - 1);
            sum -= score;
        }
    }

    /**
     * 刚开始时在序号为 1 格子上，要跳到序号为 m 的格子，计算跳法的种数
     *
     * @param m 格子的最大序号
     * @return 跳法的种数
     */
    public int getCount(int m) {
        if (m == 2)
            return 1;
        else if (m == 3)
            return 2;

        int[] dp = new int[m + 1];

        dp[2] = 1;
        dp[3] = 2;

        for (int i = 4; i <= m; i++) {
            dp[i] += dp[i - 1];

            if ((i - 2) % 2 == 1)
                dp[i] += dp[i - 2];

            if ((i - 3) % 2 == 0)
                dp[i] += dp[i - 3];
        }

        return dp[m];
    }
}
