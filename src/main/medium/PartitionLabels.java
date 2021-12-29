package main.medium;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class PartitionLabels {
    /**
     * 763. 划分字母区间
     *
     * @param s 字符串 s 由小写字母组成
     * @return 表示每个字符串片段的长度的列表。把字符串划分为尽可能多的片段，同一字母最多出现在一个片段中
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] last = new int[26];
        int n = s.length();

        for (int i = 0; i < n; i++) // 记录每个字符的最后出现的位置
            last[s.charAt(i) - 'a'] = i;

        int start = 0, end = 0;

        for (int i = 0; i < n; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);

            if (i == end) { // 如果所有遍历过的字符均在此结束则可进行分片
                res.add(end - start + 1);
                start = i + 1;
            }
        }

        return res;
    }
}
