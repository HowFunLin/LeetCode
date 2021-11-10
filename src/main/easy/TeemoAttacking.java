package main.easy;

@SuppressWarnings("unused")
public class TeemoAttacking {
    /**
     * 495. 提莫攻击
     *
     * @param timeSeries timeSeries[i] 表示提莫在 timeSeries[i] 秒时对艾希发起攻击
     * @param duration   中毒持续时间
     * @return 艾希处于中毒状态的 总 秒数
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0, start = 0;
        int last = timeSeries.length - 1;

        for (int i = 0; i < last; i++) {
            if (timeSeries[i] + duration < timeSeries[i + 1]) {
                res += timeSeries[i] + duration - timeSeries[start];
                start = i + 1;
            }
        }

        return res + timeSeries[last] + duration - timeSeries[start];
    }
}
