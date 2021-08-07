package medium;

import java.util.Arrays;

public class RemovedCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];

            return a[0] - b[0];
        });

        int left = intervals[0][0];
        int right = intervals[0][1];

        int delete = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] inter = intervals[i];

            if (inter[0] >= left && inter[1] <= right)
                delete++;

            if (right >= inter[0] && right <= inter[1])
                right = inter[1];

            if (right < inter[0]) {
                left = inter[0];
                right = inter[1];
            }
        }

        return intervals.length - delete;
    }
}
