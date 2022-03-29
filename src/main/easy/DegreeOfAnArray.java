package main.easy;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class DegreeOfAnArray {
    /**
     * 697. 数组的度
     *
     * @return nums 中与 nums 拥有相同大小的度的最短连续子数组的长度。数组的 度 的定义是指数组里任一元素出现频数的最大值
     */
    public int findShortestSubArray(int[] nums) {
        // num -> {times, firstIndex, lastIndex}
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (map.containsKey(num)) {
                int[] data = map.get(num);

                data[0]++;
                data[2] = i;
            } else
                map.put(num, new int[]{1, i, i});
        }

        int max = Integer.MIN_VALUE, length = 0;

        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] data = entry.getValue();
            int curLength = data[2] - data[1] + 1;

            if (data[0] > max) {
                max = data[0];
                length = curLength;
            } else if (data[0] == max) {
                if (curLength < length) {
                    max = data[0];
                    length = curLength;
                }
            }
        }

        return length;
    }
}
