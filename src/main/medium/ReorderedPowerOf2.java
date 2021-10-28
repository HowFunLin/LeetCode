package main.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class ReorderedPowerOf2 {
    private static Set<Integer> powerOf2 = new HashSet<>();

    // 打表记录1e9范围内2的幂
    static {
        for (int i = 1; i <= 1e9; i *= 2)
            powerOf2.add(i);
    }

    /**
     * 869. 重新排序得到 2 的幂
     *
     * @param n 正整数 N，可按任何顺序（包括原始顺序）将数字重新排序
     * @return 是否可以通过上述方式得到 2 的幂
     */
    public boolean reorderedPowerOf2(int n) {
        // 词频统计
        int[] countsN = new int[10];

        while (n > 0) {
            int i = n % 10;
            countsN[i]++;
            n /= 10;
        }

        // 词频统计
        int[] countsPower = new int[10];

        power:
        for (int power : powerOf2) {
            Arrays.fill(countsPower, 0);

            while (power > 0) {
                int i = power % 10;
                countsPower[i]++;
                power /= 10;
            }

            for (int i = 0; i < 10; i++) {
                if (countsN[i] != countsPower[i])
                    continue power;
            }

            return true;
        }

        return false;
    }
}
