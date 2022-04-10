package main.medium;

import java.util.Arrays;

@SuppressWarnings("unused")
public class SortCharactersByFrequency {
    /**
     * 451. 根据字符出现频率排序
     *
     * @param s 字符串
     * @return 字符串里的字符按照出现的频率降序排列后的结果
     */
    public String frequencySort(String s) {
        int[][] counts = new int[128][2];

        for (int i = 0; i < 128; i++)
            counts[i][0] = i; // 记录当前位置对应的字符，防止排序后顺序混乱

        for (int i = 0; i < s.length(); i++)
            counts[s.charAt(i)][1]++;

        Arrays.sort(counts, (a, b) -> {
            if (a[1] != b[1])
                return b[1] - a[1];

            return a[0] - b[0]; // 相同出现次数，顺序先后无影响
        });

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 128; i++) {
            char c = (char) counts[i][0];
            int k = counts[i][1];

            while (k-- > 0)
                builder.append(c);
        }

        return builder.toString();
    }
}
