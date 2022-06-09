package main.medium;

import java.util.Random;

@SuppressWarnings("unused")
public class RandomPointInNon_overlappingRectangles {
    /**
     * 497. 非重叠矩形中的随机点
     */
    class Solution {
        private Random random = new Random();
        private int[][] rects;
        private int[] prefix;
        private int n;

        public Solution(int[][] rects) {
            this.rects = rects;
            n = rects.length;
            prefix = new int[n + 1];
            int i = 1;

            for (int[] rect : rects) {
                prefix[i] = prefix[i - 1] + (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1); // 计算矩形内的整数点数
                i++;
            }
        }

        /**
         * @return 在给定的矩形所覆盖的空间内一个随机的整数点 [u, v]
         */
        public int[] pick() {
            int val = random.nextInt(prefix[n]) + 1, l = 0, r = n;

            // 二分查找寻找右边界
            while (l < r) {
                int mid = l + r >> 1;

                if (prefix[mid] >= val)
                    r = mid;
                else
                    l = mid + 1;
            }

            int[] picked = rects[r - 1];

            return new int[]{random.nextInt(picked[2] - picked[0] + 1) + picked[0], random.nextInt(picked[3] - picked[1] + 1) + picked[1]};
        }
    }
}
