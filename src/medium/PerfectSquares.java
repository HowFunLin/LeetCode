package medium;

import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        Arrays.fill(f, 0x3f3f3f3f);
        f[0] = 0;

        for (int t = 1; t * t <= n; t++) {
            int x = t * t;

            for (int j = x; j <= n; j++) {
                f[j] = Math.min(f[j], f[j - x] + 1);
            }
        }

        return f[n];
    }
}
