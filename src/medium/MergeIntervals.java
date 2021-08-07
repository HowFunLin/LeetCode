package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];

            return a[0] - b[0];
        });

        int left = intervals[0][0];
        int right = intervals[0][1];

        List<Integer> list = new ArrayList<>();
        list.add(left);
        list.add(right);
        result.add(list);

        for (int i = 1, index = 0; i < intervals.length; i++) {
            int[] inter = intervals[i];

            if (inter[0] >= left && inter[1] <= right)
                continue;

            if (right >= inter[0] && right <= inter[1])
            {
                right = inter[1];
                result.get(index).set(1, right);
            }

            if (right < inter[0]) {
                left = inter[0];
                right = inter[1];

                List<Integer> sub = new ArrayList<>();
                sub.add(left);
                sub.add(right);
                result.add(sub);

                index++;
            }
        }

        int[][] resultArray = new int[result.size()][2];

        int index = 0;
        for (List<Integer> l : result)
        {
            resultArray[index][0] = l.get(0);
            resultArray[index][1] = l.get(1);
            index++;
        }

        return resultArray;
    }
}
