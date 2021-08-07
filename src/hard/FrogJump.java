package hard;

@SuppressWarnings("unused")
public class FrogJump {
    public boolean canCross(int[] stones) {
//        int reach = 1;
//        int lastReach = 0;
//
//        for (int i = 2; i < stones.length; i++)
//        {
//            int distance = stones[i] - stones[reach];
//            int lastDistance = stones[reach] - stones[lastReach];
//
//            if (distance == lastDistance + 1 || distance == lastDistance || distance == lastDistance - 1)
//            {
//                lastReach = reach;
//                reach = i;
//            }
//        }
//
//        if (reach != stones.length - 1)
//            return false;
//        else
//            return true;


        // 三个状态，并且同一个位置可能由前面多个位置得到，在得到当前位置状态时需要对前面所有位置进行比较

        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;

        for (int i = 1; i < n; ++i)
            if (stones[i] - stones[i - 1] > i) // 初始值是0，跳第一格必为1，以此类推，不能大于i
                return false;


        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                int k = stones[i] - stones[j];

                if (k > j + 1) // 在第 j 个石子上至多只能跳出 j+1 的距离
                    break;

                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1]; // 三个状态获得当前状态

                if (i == n - 1 && dp[i][k])
                    return true;
            }
        }

        return false;
    }
}
