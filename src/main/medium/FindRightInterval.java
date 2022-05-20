package main.medium;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("unused")
public class FindRightInterval {
    /**
     * 436. 寻找右区间
     *
     * @param intervals intervals[i] = [start, end] ，且每个 start 都 不同
     * @return 一个由每个区间 i 的 右侧区间 在 intervals 中对应下标组成的数组。
     * 如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1。
     * 区间 i 的 右侧区间 可以记作区间 j ，并满足 start j >= end i ，且 start j 最小化
     */
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;

        int[][] starts = new int[n][2]; // start[i][0] 表示数字，start[i][1] 表示地址

        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }

        Arrays.sort(starts, Comparator.comparingInt(o -> o[0]));

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1, target = -1;

            while (left <= right) {
                int mid = (left + right) >> 1;

                if (starts[mid][0] >= intervals[i][1]) {
                    target = starts[mid][1];
                    right = mid - 1;
                } else
                    left = mid + 1;
            }

            res[i] = target;
        }

        return res;
    }
}
