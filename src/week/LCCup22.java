package week;

/**
 * 「力扣杯」春季编程大赛
 */
@SuppressWarnings("unused")
public class LCCup22 {
    private int[] temp = new int[5];
    private int max = -1, full, delicious;

    /**
     * LCP 50. 宝石补给
     *
     * @param gem        每位勇者初始都拥有一些能量宝石， gem[i] 表示第 i 位勇者的宝石数量
     * @param operations operations[j] = [x, y] 表示在第 j 次的赠送中 第 x 位勇者将自己一半的宝石（需向下取整）赠送给第 y 位勇者
     * @return 拥有最多宝石的勇者和拥有最少宝石的勇者二者的宝石数量之差
     */
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
            int x = operation[0], y = operation[1];
            int send = gem[x] / 2;

            gem[x] -= send;
            gem[y] += send;
        }

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int g : gem) {
            max = Math.max(max, g);
            min = Math.min(min, g);
        }

        return max - min;
    }

    /**
     * LCP 51. 烹饪料理
     *
     * @param materials materials[j] 表示第 j 种食材的数量，共有编号为 0 ~ 4 的五种食材
     * @param cookbooks 通过这些食材可以制作若干料理，cookbooks[i][j] 表示制作第 i 种料理需要第 j 种食材的数量
     * @param attribute attribute[i] = [x,y] 表示第 i 道料理的美味度 x 和饱腹感 y
     * @param limit     饱腹感要求的最低限制
     * @return 饱腹感不小于 limit 的情况下，勇者可获得的最大美味度。如果无法满足饱腹感要求，则返回 -1
     */
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        for (int i = 0; i < cookbooks.length; i++) {
            dfs(materials, cookbooks, attribute, limit, i);
        }

        return max;
    }

    /**
     * @param index 当前遍历的 cookbooks 索引
     */
    private void dfs(int[] materials, int[][] cookbooks, int[][] attribute, int limit, int index) {
        for (int i = 0; i < 5; i++) {
            if (temp[i] + cookbooks[index][i] > materials[i])
                return;
        }

        for (int i = 0; i < 5; i++)
            temp[i] += cookbooks[index][i];

        delicious += attribute[index][0];
        full += attribute[index][1];

        if (full >= limit)
            max = Math.max(delicious, max);

        for (int i = index + 1; i < cookbooks.length; i++) {
            dfs(materials, cookbooks, attribute, limit, i);
        }

        delicious -= attribute[index][0];
        full -= attribute[index][1];

        for (int i = 0; i < 5; i++)
            temp[i] -= cookbooks[index][i];
    }
}
