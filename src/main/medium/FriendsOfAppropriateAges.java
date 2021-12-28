package main.medium;

@SuppressWarnings("unused")
public class FriendsOfAppropriateAges {
    /**
     * 825. 适龄的朋友
     *
     * @param ages 整数数组 ages 对应社交媒体网站上 n 个用户，其中 ages[i] 是第 i 个用户的年龄
     * @return 在该社交媒体网站上产生的好友请求总数
     */
    public int numFriendRequests(int[] ages) {
        int[] nums = new int[121];

        for (int age : ages) // 记录每个年龄的人数
            nums[age]++;

        for (int i = 1; i <= 120; i++) // 构建前缀和数组
            nums[i] += nums[i - 1];

        int res = 0;

        for (int x = 1, y = 1, a, b; y <= 120; y++) { // 从 y 的角度判断有多少 x 会发来请求
            a = nums[y] - nums[y - 1];

            if (a == 0) // 没有人年龄为 y 则无需继续计算
                continue;

            if (x < y) // 若初始 x 小于 y 则 x 最小必须等于 y
                x = y;

            while (x <= 120 && check(x, y)) // 判断可能给年龄 y 发送请求的年龄 x 的最大值
                x++;

            b = nums[x - 1] - nums[y - 1] - 1; // y 自己除外

            if (b > 0) // 避免 x == y 时出现负值
                res += a * b;
        }

        return res;
    }

    /**
     * 判断用户 x 是否会向用户 y（x != y）发送好友请求（此处 x，y 代指用户编号）
     *
     * @param x 用户 x 的年龄
     * @param y 用户 y 的年龄
     * @return 用户 x 是否会向用户 y（x != y）发送好友请求
     */
    private boolean check(int x, int y) {
        return !(y <= 0.5 * x + 7 || y > x);
    }
}
