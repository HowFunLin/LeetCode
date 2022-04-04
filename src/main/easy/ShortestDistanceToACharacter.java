package main.easy;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class ShortestDistanceToACharacter {
    /**
     * 821. 字符的最短距离
     *
     * @param c c 是 s 中出现过的字符
     * @return 整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离
     */
    public int[] shortestToChar(String s, char c) {
        List<Integer> list = new LinkedList<>();
        int n = s.length();

        // 记录所有出现过的下标
        for (int i = 0; i < n; i++)
            if (s.charAt(i) == c)
                list.add(i);

        Integer[] arr = list.toArray(new Integer[0]);
        int[] res = new int[n];
        int before = -1, after = arr[0], index = 1;

        for (int i = 0; i < n; i++) {
            int distance = Integer.MAX_VALUE;

            if (i == after) {
                before = after;

                if (index == arr.length)
                    after = n; // 记录为 n 表示之后已经没有下标
                else
                    after = arr[index++];
            }

            if (before != -1)
                distance = Math.min(i - before, distance);

            if (after != n)
                distance = Math.min(after - i, distance);

            res[i] = distance;
        }

        return res;
    }
}
