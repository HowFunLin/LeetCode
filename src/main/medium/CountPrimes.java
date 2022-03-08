package main.medium;

import java.util.Arrays;

@SuppressWarnings("unused")
public class CountPrimes {
    /**
     * 204. 计数质数
     *
     * @param n 整数
     * @return 所有小于非负整数 n 的质数的数量
     */
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) // 当前数不为质数则已经在前面被得到过，当前数的倍数在前面也得到计算过，无需重复计算
                continue;

            for (int j = i * i; j < n; j += i)
                isPrime[j] = false;
        }

        int count = 0;

        for (int i = 2; i < n; i++) {
            if (isPrime[i])
                count++;
        }

        return count;
    }
}
