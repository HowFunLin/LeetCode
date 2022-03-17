package main.easy;

import java.util.Arrays;

@SuppressWarnings("unused")
public class LongestWordInDictionary {
    private static int ROW = 30001; // 根据数据量计算 max(words.length) * max(words[i].length())
    private static int[][] trie = new int[ROW][26];
    private static boolean[] isEnd = new boolean[ROW];
    private static int index = 0; // 标识新前缀使用到的新行

    /**
     * 将字符串加入字典树
     *
     * @param s 字符串
     */
    private void add(String s) {
        int p = 0, n = s.length(); // 每个字符均从第 0 行开始（类似 带头节点），数组值意思是当前前缀指向下一个字符对应的行

        for (int i = 0; i < n; i++) {
            int u = s.charAt(i) - 'a';

            if (trie[p][u] == 0)
                trie[p][u] = ++index; // 当前前缀后的字符所在的行

            p = trie[p][u];
        }

        isEnd[p] = true; // 当前位置存在字符串在此结束，即使只有单个字符也会在非 0 行结束
    }

    /**
     * 在字典树中查询字符串
     *
     * @param s 字符串
     * @return 是否查询到
     */
    private boolean query(String s) {
        int p = 0, n = s.length();

        for (int i = 0; i < n; i++) {
            int u = s.charAt(i) - 'a';

            p = trie[p][u];

            if (!isEnd[p]) // 只有每个前缀均存在字符串在此结束才满足条件
                return false;
        }

        return true;
    }

    /**
     * 720. 词典中最长的单词
     *
     * @param words 字符串数组
     * @return words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。
     * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串
     */
    public String longestWord(String[] words) {
        // 更新已有的数据结构
        Arrays.fill(isEnd, false);

        for (int i = 0; i <= index; i++)
            Arrays.fill(trie[i], 0);

        index = 0;

        String res = "";

        for (String word : words)
            add(word);

        for (String word : words) {
            int n = word.length(), m = res.length();

            // compareTo 方法用于比较字典序，若 res 字典序已小于 word 则继续遍历
            if (n < m || (n == m && res.compareTo(word) <= 0))
                continue;

            if (query(word))
                res = word;
        }

        return res;
    }
}
