package main.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

@SuppressWarnings("unused")
public class TopKFrequentElements {
    /**
     * 347. 前 K 个高频元素
     *
     * @param nums 整数数组 nums
     * @param k    整数 k
     * @return 整数数组中出现频率前 k 高的元素
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> appearances = new HashMap<>();

        for (int num : nums)
            appearances.put(num, appearances.getOrDefault(num, 0) + 1);

        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> y[1] - x[1]);

        for (Map.Entry<Integer, Integer> entry : appearances.entrySet())
            heap.offer(new int[]{entry.getKey(), entry.getValue()});

        int[] ans = new int[k];

        for (int i = 0; i < k; i++)
            ans[i] = heap.poll()[0];

        return ans;
    }
}
