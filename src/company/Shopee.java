package company;

@SuppressWarnings("unused")
public class Shopee {
    private long res = -1;

    /**
     * 根据连续逾期天数返回扣除的信誉积分
     *
     * @param dpdInfo 用户每天的逾期情况，N 表示不逾期，Y 表示逾期
     * @return 扣除的信誉积分
     */
    public int calDPDScore(String dpdInfo) {
        int dpd = 0, res = 0;

        for (int i = 0; i < dpdInfo.length(); i++) {
            if (dpdInfo.charAt(i) == 'Y') {
                dpd++;
                res = Math.max(dpd, res);
            } else
                dpd = 0;
        }

        if (res > 0 && res <= 3)
            return -10;
        else if (res > 3 && res <= 7)
            return -15;
        else if (res > 7)
            return -25;

        return 0;
    }

    /**
     * LeetCode 152
     */
    public long GetSubArrayMaxProduct(long[] nums) {
        long min = nums[0], max = min, res = min;

        for (int i = 1; i < nums.length; i++) {
            long mn = min, mx = max;

            max = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            min = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));

            res = Math.max(res, max);
        }

        return res;
    }

    /**
     * sourceX 和 sourceY 每次只能同时 + 1 或 * 2，求得到 targetX 和 targetY 的最小计算次数，无法得到则返回 -1
     * <p>
     * DFS 过 90%， 可用贪心思路进行求解，奇数 - 1，偶数 / 2
     */
    public long GetMinCalculateCount(long sourceX, long sourceY, long targetX, long targetY) {
        if (targetX == 0 || targetY == 0)
            return -1;

        getCount(sourceX, sourceY, targetX, targetY, 0L);

        return res;
    }

    private void getCount(long sourceX, long sourceY, long targetX, long targetY, Long needCount) {
        if (sourceX > targetX || sourceY > targetY)
            return;

        if (sourceX == targetX && sourceY == targetY) {
            if (res == -1)
                res = needCount;
            else
                res = Math.min(res, needCount);
        }

        getCount(sourceX * 2, sourceY * 2, targetX, targetY, needCount + 1);
        getCount(sourceX + 1, sourceY + 1, targetX, targetY, needCount + 1);
    }
}
