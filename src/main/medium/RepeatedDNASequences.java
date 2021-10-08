package main.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@SuppressWarnings("unused")
public class RepeatedDNASequences {
//    private static final int L = 10;
//    private static final Map<Character, Integer> map = new HashMap<>(); // 字符哈希表
//
//    static {
//        map.put('A', 0);
//        map.put('C', 1);
//        map.put('G', 2);
//        map.put('T', 3);
//    }

    /**
     * 187. 重复的DNA序列
     *
     * @param s 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助
     * @return 所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次
     */
    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10, n = s.length();
        HashSet<String> seen = new HashSet<>(), output = new HashSet<>();

        // 遍历字符串并记录出现情况，Set去重
        for (int start = 0; start < n - L + 1; ++start) {
            String tmp = s.substring(start, start + L);

            if (seen.contains(tmp))
                output.add(tmp);

            seen.add(tmp);
        }

        return new ArrayList<>(output);

//        // 字符哈希表解法
//        if (s.length() <= 10)
//            return new ArrayList<>();
//
//        List<String> res = new ArrayList<>();
//        Map<Integer, Integer> appearance = new HashMap<>();
//        int x = 0; // 20位整数作为 key
//
//
//        // 初始化
//        for (int i = 0; i < L; i++)
//        {
//            x <<= 2;
//            x |= map.get(s.charAt(i));
//        }
//
//        appearance.put(x, 1);
//
//        // 指针移动
//        for (int i = L; i < s.length(); i++)
//        {
//            x = ((x << 2) | map.get(s.charAt(i))) & ((1 << (2 * L)) - 1);
//
//            int count = appearance.getOrDefault(x, 0);
//
//            if (count == 1)
//                res.add(s.substring(i - 9, i + 1));
//
//            appearance.put(x, count + 1);
//        }
//
//        return res;
    }
}
