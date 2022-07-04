package main.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class MinimumAbsoluteDifference {
    /**
     * 1200. 最小绝对差
     *
     * @param arr 整数数组 arr，其中每个元素都 不相同
     * @return 所有具有最小绝对差的元素对，并且按升序的顺序返回
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            int difference = arr[i] - arr[i - 1];

            if (difference <= min) {
                if (difference < min) {
                    min = difference;
                    res.clear();
                }

                res.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return res;
    }
}
