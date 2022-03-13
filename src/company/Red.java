package company;

import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Red {
    /**
     * 通过率：90%
     */
    public void flipNumbersToGetMostOne()
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // n 个数，均为 0 或 1

        if (n == 0) {
            System.out.println(-1);
            System.exit(0);
        }

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int ones = 0;

        for (int num : nums) {
            if (num == 1)
                ones++;
        }

        int[] table = new int[n]; // DP 压缩，当前状态只来自上一个状态

        table[n - 1] = nums[n - 1] == 0 ? 1 : -1;

        int max = table[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                int cur;

                if (nums[i] == 0)
                    cur = table[j] + 1;
                else
                    cur = table[j] - 1;

                table[j] = cur;

                if (cur > max)
                    max = cur;
            }
        }

        System.out.println(ones + Math.max(max, 0));
    }

    /**
     * 通过率：83%
     */
    public void waysToGetTreasure() {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt(), n = scanner.nextInt(), k = scanner.nextInt();

        int[][] sea = new int[m][n];

        Arrays.fill(sea[0], 1);

        for (int i = 1; i < m; i++) {
            sea[i][0] = 1;
        }

        for (int i = 0; i < k; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt();

            sea[x - 1][y - 1] = -1; // 设置礁石所在位置为 -1
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (sea[i][j] == -1) // 位置为礁石不可达
                    continue;

                long up, left;

                if (sea[i - 1][j] == -1)
                    up = 0;
                else
                    up = sea[i - 1][j];

                if (sea[i][j - 1] == -1)
                    left = 0;
                else
                    left = sea[i][j - 1];

                sea[i][j] = (int) ((up + left) % 1000000007); // 当前位置路径种数由上边及左边得到
            }
        }

        System.out.println(sea[m - 1][n - 1]); // 宝藏所在位置即为结果
    }

    /**
     * 通过率：45%
     */
    public void getDifferenceBetweenMaxAndMin() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), k = scanner.nextInt();

        int[] values = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            values[i] = scanner.nextInt();
        }

        int[][] max = new int[n + 1][n + 1], min = new int[n + 1][n + 1]; // 构建区间内最大值和最小值数组

        for (int i = 1; i <= n; i++) {
            Arrays.fill(min[i], 1000001);
        }

        int last = values[n];

        max[n][n] = last;
        min[n][n] = last;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n; j >= i; j--) {
                int value = values[i];

                if (value > max[i + 1][j])
                    max[i][j] = value;
                else
                    max[i][j] = max[i + 1][j];

                if (value < min[i + 1][j])
                    min[i][j] = value;
                else
                    min[i][j] = min[i + 1][j];
            }
        }

        for (int i = 1; i <= k; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();

            System.out.println(max[a][b] - min[a][b]); // 输出区间最值的差
        }
    }
}
