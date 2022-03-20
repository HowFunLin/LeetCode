package week;

@SuppressWarnings("unused")
public class Game_285 {
    /**
     * 6027. 统计数组中峰和谷的数量
     *
     * @param nums 整数数组
     * @return nums 中峰和谷的数量。
     * 如果两侧距 i 最近的不相等邻居的值均小于 nums[i] ，则下标 i 是 nums 中，某个峰的一部分；反则，是某个谷的一部分。
     * 对于相邻下标 i 和 j ，如果 nums[i] == nums[j] ， 则认为这两下标属于 同一个 峰或谷
     */
    public int countHillValley(int[] nums) {
        int res = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            int end = i + 1;

            while (end < nums.length && nums[end] == nums[i])
                end++;

            if (end == nums.length)
                return res;

            if ((nums[i] < nums[i - 1] && nums[i] < nums[end]) || nums[i] > nums[i - 1] && nums[i] > nums[end])
                res++;

            i = end - 1;
        }

        return res;
    }

    /**
     * 6028. 统计道路上的碰撞次数
     *
     * @param directions directions[i] 可以是 'L'、'R' 或 'S' 分别表示第 i 辆车是向 左 、向 右 或者 停留 在当前位置。
     *                   当两辆移动方向 相反 的车相撞时，碰撞次数加 2 。当一辆移动的车和一辆静止的车相撞时，碰撞次数加 1。
     *                   每辆车移动时 速度相同 。碰撞发生后，涉及的车辆将无法继续移动并停留在碰撞位置
     * @return 在这条道路上发生的 碰撞总次数
     */
    public int countCollisions(String directions) {
        int r = 0, res = 0;
        boolean hasS = false; // 是否存在停止的车

        for (int i = 0; i < directions.length(); i++) {
            char c = directions.charAt(i);

            // 左边没有向右的车也没有停留的车
            if (r == 0 && !hasS && c == 'L')
                continue;

            if (c == 'L') {
                if (r > 0) {
                    // 与左边第一辆向右的车碰撞且静止时与所有未碰撞的向右的车碰撞
                    res += r + 1;
                    r = 0;
                    hasS = true; // 视为在碰撞的位置停留
                } else if (hasS)
                    res++; // 若左边没有向右的车且存在停留的车，则最终会和停留的车碰撞
            } else if (c == 'S') {
                res += r; // 所有向右的车均会与当前位置碰撞
                r = 0;
                hasS = true;
            } else
                r++; // 向右的车暂无存在碰撞，记录供后续匹配
        }

        return res;
    }
}
