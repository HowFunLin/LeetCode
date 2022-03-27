package main.easy;

@SuppressWarnings("unused")
public class CanPlaceFlowers {
    /**
     * 605. 种花问题
     *
     * @param flowerbed 整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花
     * @param n         要种入的花的数量
     * @return 能否在不打破种植规则的情况下种入 n 朵花
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int last = -1, count = 0, m = flowerbed.length;

        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (last < 0)
                    count += i / 2;
                else
                    count += (i - last - 2) / 2;

                if (count >= n) // 符合条件立即返回
                    return true;

                last = i;
            }
        }

        if (last < 0) // 自始至终没有出现 1
            count += (m + 1) / 2;
        else
            count += (m - last - 1) / 2;

        return count >= n;
    }
}
