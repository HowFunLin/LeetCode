package main.easy;

import java.util.PriorityQueue;

@SuppressWarnings("unused")
public class ThirdMaximumNumber {
    /**
     * 414. 第三大的数
     *
     * @param nums 非空数组
     * @return 数组中 第三大的数 。如果不存在，则返回数组中最大的数
     */
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(4);

        for (int num : nums) {
            if (!heap.contains(num))
                heap.offer(num);

            if (heap.size() > 3)
                heap.poll();
        }

        if (heap.size() < 3) {
            int max = 0;

            while (heap.size() != 0)
                max = heap.poll();

            return max;
        } else
            return heap.peek();
    }
}
