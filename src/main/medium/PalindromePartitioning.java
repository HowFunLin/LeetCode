package main.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class PalindromePartitioning {
    private List<List<String>> res = new ArrayList<>();
    private List<String> temp = new ArrayList<>();
    private boolean[][] dp;
    private int n;

    /**
     * 131. 分割回文串
     *
     * @param s 字符串
     * @return 将 s 分割成一些子串，使每个子串都是 回文串所有可能的分割方案
     */
    public List<List<String>> partition(String s) {
        n = s.length();
        dp = new boolean[n][n];

        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], true);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
            }
        }

        backtrack(s, 0);

        return res;
    }

    /**
     * 回溯
     *
     * @param s     字符串
     * @param index 当前索引
     */
    private void backtrack(String s, int index) {
        if (index == n) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < n; i++) {
            if (dp[index][i]) {
                temp.add(s.substring(index, i + 1));
                backtrack(s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
