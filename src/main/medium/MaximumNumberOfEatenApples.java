package main.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("unused")
public class MaximumNumberOfEatenApples {
    /**
     * 1705. 吃苹果的最大数目
     *
     * @param apples 一连 n 天，第 i 天树上会长出 apples[i] 个苹果
     * @param days   第 i 天长出的苹果将会在 days[i] 天后腐烂
     * @return 可以吃掉的苹果的最大数目。每天 最多 吃一个苹果，可以在这 n 天之后继续吃苹果
     */
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int n = apples.length, time = 0, res = 0;

        // 维护堆，优先取出最近即将过期的苹果
        for (; time < n || !queue.isEmpty(); time++) {
            // 当前时间不超过最后长新苹果的时间且长出新苹果
            if (time < n && apples[time] > 0)
                queue.add(new int[]{apples[time], time + days[time] - 1});

            // 取出堆顶可能存在的已经腐烂的苹果
            while (!queue.isEmpty() && queue.peek()[1] < time)
                queue.poll();

            // 吃苹果并判断是否可以继续存放
            if (!queue.isEmpty()) {
                int[] cur = queue.poll();

                if (--cur[0] > 0 && cur[1] > time)
                    queue.add(cur);

                res++;
            }
        }

        return res;
    }
}
