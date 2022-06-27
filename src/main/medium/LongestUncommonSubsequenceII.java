package main.medium;

import java.util.Arrays;

@SuppressWarnings("unused")
public class LongestUncommonSubsequenceII {
    /**
     * 522. 最长特殊序列 II
     *
     * @return 字符串列表 strs 中 最长的特殊序列。特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
     * 如果字符串具有独有子序列，则其自身即为最长特殊序列的候选。
     */
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (s1, s2) -> s2.length() - s1.length());

        int n = strs.length, len1 = 0; // 0 仅作初始化用
        boolean find = false;

        for (int i = 0; i < n; i++) {
            len1 = strs[i].length();
            boolean special = true;

            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                int len2 = strs[j].length();

                if (len1 > len2) // 排序之后，若 len2 开始小于 len1 ，则后续都小于 len1 ，无需继续比较
                    break;

                if (len1 == len2) {
                    if (strs[i].equals(strs[j])) { // 相等则必为彼此的子序列，str[i] 不可能为特殊序列
                        special = false;
                        break;
                    }

                    continue;
                }

                // 双指针比较子序列
                int pi = 0, pj = 0;

                while (pi < len1 && pj < len2) {
                    if (strs[i].charAt(pi) == strs[j].charAt(pj))
                        pi++;

                    pj++;
                }

                if (pi == len1)
                    special = false;
            }

            if (special) { // 一旦找到子序列，无需继续往后查询，此字符串必为最长字符串
                find = true;
                break;
            }
        }

        return find ? len1 : -1;
    }
}
