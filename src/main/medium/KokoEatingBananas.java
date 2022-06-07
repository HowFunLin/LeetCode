package main.medium;

@SuppressWarnings("unused")
public class KokoEatingBananas {
    /**
     * 875. 爱吃香蕉的珂珂
     *
     * @param piles 第 i 堆中有 piles[i] 根香蕉。每个小时选择一堆香蕉，从中吃掉 k 根。
     *              如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉
     * @return 在 h 小时内吃掉所有香蕉的最小速度 k
     */
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;

        for (int pile : piles)
            high = Math.max(pile, high);

        int k = high; // 如果二分查找没有合适结果，则只能取最大值

        while (low < high) {
            int speed = (high - low) / 2 + low;
            int time = 0;

            for (int pile : piles)
                time += (pile + speed - 1) / speed; // 向上取整

            if (time <= h) {
                k = speed;
                high = speed;
            } else
                low = speed + 1; // time > h 一定不符合条件
        }

        return k;
    }
}
