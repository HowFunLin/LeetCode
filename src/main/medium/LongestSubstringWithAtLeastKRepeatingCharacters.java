package main.medium;

import java.util.Arrays;

@SuppressWarnings("unused")
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    /**
     * 395. 至少有 K 个重复字符的最长子串
     *
     * @param s 字符串
     * @param k 整数
     * @return s 中的最长子串的长度。s 中的最长子串要求该子串中的每一字符出现次数都不少于 k
     */
    public int longestSubstring(String s, int k) {
        int res = 0, n = s.length();
        int[] count = new int[26];

        // 答案可能包含 1 ~ 26 种字符
        for (int kind = 1; kind <= 26; kind++) {
            Arrays.fill(count, 0); // 每次循环刷新数组

            for (int left = 0, right = 0, total = 0, sum = 0; right < n; right++) {
                int index = s.charAt(right) - 'a';

                count[index]++;

                // 当前字符种类
                if (count[index] == 1)
                    total++;

                // 当前符合条件的字符种类
                if (count[index] == k)
                    sum++;

                while (total > kind) {
                    index = s.charAt(left++) - 'a';
                    count[index]--;

                    if (count[index] == 0)
                        total--;
                    if (count[index] == k - 1) // 不能为 < k，否则每次都会使 sum--
                        sum--;
                }

                // 所有字符符合条件且符合当前定义的种类
                if (total == sum && total == kind)
                    res = Math.max(res, right - left + 1);
            }
        }

        return res;
    }
}
