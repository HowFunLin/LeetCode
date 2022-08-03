package main.hard;

import java.util.Arrays;

@SuppressWarnings("unused")
public class OrderlyQueue {
    /**
     * 899. 有序队列
     *
     * @return 从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾，应用任意数量的移动后，字典上最小的字符串 
     */
    public String orderlyQueue(String s, int k) {
        char[] cs = s.toCharArray();

        if (k > 1) {
            Arrays.sort(cs);

            return new String(cs);
        } else {
            int i = 0, j = 1, same = 0, n = cs.length;

            // 最小表示法：求给定字符串循环同构的所有方案中字典序最小的方案
            while (i < n && j < n && same < n) {
                char a = cs[(i + same) % n], b = cs[(j + same) % n];

                if (a == b)
                    same++;
                else {
                    if (a > b) // 从 i 到 i + same 之间的下标开始都不可能比当前 j 开始的字符串更优
                        i += same + 1;
                    else
                        j += same + 1;

                    if (i == j)
                        j++;

                    same = 0; // 下标更新，重新计算从下标出发相等的字符数
                }
            }

            int index = Math.min(i, j); // 先遍历结束的下标非优，取最小的下标即为最优下标

            return s.substring(index) + s.substring(0, index);
        }
    }
}
