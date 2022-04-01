package main.easy;

public class PrimeNumberOfSetBitsInBinaryRepresentation {
    private static final boolean[] isPrime = new boolean[20];

    static {
        isPrime[2] = true;
        isPrime[3] = true;
        isPrime[5] = true;
        isPrime[7] = true;
        isPrime[11] = true;
        isPrime[13] = true;
        isPrime[17] = true;
        isPrime[19] = true;
    }

    /**
     * 762. 二进制表示中质数个计算置位
     *
     * @return 在闭区间 [left, right] 范围内 计算置位位数为质数 的整数个数
     */
    public int countPrimeSetBits(int left, int right) {
        int count = 0;

        for (int i = left; i <= right; i++) {
            int bits = Integer.bitCount(i);

            if (isPrime[bits])
                count++;
        }

        return count;
    }
}
