package main.medium;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("unused")
public class Non_OverlappingIntervals {
    /**
     * 435. 无重叠区间
     *
     * @param intervals 区间的集合。区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠
     * @return 使剩余区间互不重叠需要移除区间的最小数量
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        // 排序后的第一个区间为跨度最小的区间，优先取跨度最小的区间
        int count = 1, end = intervals[0][1];

        // 若存在 起始 比 当前区间 的 结束 更大的区间，则更新区间为所需保留区间，且该区间跨度最小
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }

        return n - count;
    }
}
