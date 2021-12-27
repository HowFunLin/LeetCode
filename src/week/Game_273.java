package week;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 第 273 场周赛
 */
@SuppressWarnings("unused")
public class Game_273 {
    /**
     * 5963. 反转两次的数字
     *
     * @param num 整数 num ，反转 num 得到 reversed1 ，接着反转 reversed1 得到 reversed2
     * @return reversed2 是否等于 num
     */
    public boolean isSameAfterReversals(int num) {
        if (num == 0)
            return true;

        return num % 10 != 0;
    }

    /**
     * 5964. 执行所有后缀指令
     *
     * @param n        n x n 大小的网格
     * @param startPos startPos = [row, col] 表示机器人最开始在坐标为 (row, col) 的单元格上
     * @param s        长度为 m 、下标从 0 开始的字符串 s ，其中 s[i] 是对机器人的第 i 条指令：'L'（向左移动），'R'（向右移动），'U'（向上移动）和 'D'（向下移动）
     * @return 长度为 m 的数组 answer ，其中 answer[i] 是机器人从第 i 条指令 开始 ，可以执行的 指令数目 。机器人可以从 s 中的任一第 i 条指令开始执行。逐条执行指令直到 s 的末尾，但下一条指令将会导致机器人移动到网格外时，机器人将会停止
     */
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int len = s.length(), row = startPos[0], col = startPos[1];
        int[] pos = new int[]{row, col};
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            int opt = 0;

            for (int j = i; j < len; j++, opt++) {
                char cur = s.charAt(j);

                if (cur == 'U')
                    pos[0]--;
                else if (cur == 'D')
                    pos[0]++;
                else if (cur == 'L')
                    pos[1]--;
                else if (cur == 'R')
                    pos[1]++;

                if (pos[0] < 0 || pos[0] >= n || pos[1] < 0 || pos[1] >= n)
                    break;
            }

            pos[0] = row;
            pos[1] = col;

            res[i] = opt;
        }

        return res;
    }

    /**
     * 5965. 相同元素的间隔之和
     *
     * @param arr 下标从 0 开始、由 n 个整数组成的数组 arr。arr 中两个元素的 间隔 定义为它们下标之间的 绝对差 ，arr[i] 和 arr[j] 之间的间隔是 |i - j|。
     * @return 长度为 n 的数组 intervals ，其中 intervals[i] 是 arr[i] 和 arr 中每个相同元素（与 arr[i] 的值相同）的 间隔之和。
     */
    public long[] getDistances(int[] arr) {
        Map<Integer, List<Integer>> numberIndex = new HashMap<>();
        long[] res = new long[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];

            if (!numberIndex.containsKey(cur))
                numberIndex.put(cur, new ArrayList<>());

            for (int index : numberIndex.get(cur)) {
                int abs = Math.abs(i - index);

                res[i] += abs;
                res[index] += abs;
            }

            numberIndex.get(cur).add(i);
        }

        return res;
    }
}
