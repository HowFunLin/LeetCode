package main.medium;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class FindAndReplacePattern {
    /**
     * 890. 查找和替换模式
     *
     * @param pattern 模式。如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的
     * @return words 中与给定模式匹配的单词列表
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new LinkedList<>();
        int n = pattern.length();

        tra:
        for (String word : words) {
            int[] map = new int[27]; // 记录映射关系
            boolean[] isMapped = new boolean[27]; // 防止不同字母映射同一个字母

            for (int i = 0; i < n; i++) {
                int y = word.charAt(i) - 'a' + 1, x = pattern.charAt(i) - 'a' + 1; // 初始值为 0，a 从 1 开始

                if (map[x] == 0) {
                    if (!isMapped[y]) {
                        map[x] = y;
                        isMapped[y] = true;
                    } else
                        continue tra;
                } else {
                    if (map[x] != y)
                        continue tra;
                }
            }

            res.add(word);
        }

        return res;
    }
}
