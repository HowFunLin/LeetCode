package main.medium;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Heaters {
    /**
     * 475. 供暖器
     *
     * @param houses  位于一条水平线上的房屋 houses
     * @param heaters 位于一条水平线上的供暖器 heaters。所有供暖器都遵循相同半径标准，加热的半径相同
     * @return 可以覆盖所有房屋的最小加热半径
     */
    public int findRadius(int[] houses, int[] heaters) {
        int radius, res = 0, j = 0;
        int n = heaters.length;

        Arrays.sort(houses);
        Arrays.sort(heaters);

        // 寻找与当前房子前后最近的供暖器的最小距离，取所有最小距离的最大值即可覆盖所有房子
        for (int house : houses) {
            while (j < n && heaters[j] < house)
                j++;

            // 在房子之前无供暖器
            if (j == 0)
                radius = heaters[0] - house;
            else /* 在房子之后无供暖器 */ if (j == n)
                radius = house - heaters[n - 1];
            else
                radius = Math.min(heaters[j] - house, house - heaters[j - 1]);

            res = Math.max(res, radius);
        }

        return res;
    }
}
