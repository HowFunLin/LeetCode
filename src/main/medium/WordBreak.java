package main.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unused")
public class WordBreak {
    /**
     * 139. 单词拆分
     *
     * @param s        字符串 s
     * @param wordDict 字符串列表 wordDict 作为字典
     * @return s 是否可以由空格拆分为一个或多个在字典中出现的单词。拆分时可以重复使用字典中的单词
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        Set<String> set = new HashSet<>(wordDict);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // dp[j] 表示截至第 j 个字符为 true， 检查从 下一个字符（字符串下标 j 开始） 到 最后一个字符（字符串下标 i - 1 结束） 是否存在字典中
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
