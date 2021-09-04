package main.medium;

public class NthDigit {
    public int findNthDigit(int n) {
        int bits = 1;
        long largest = 0, sum = 9, num = 0;

        for (; ; bits++, sum *= 10) {
            largest += sum;
            num += bits * sum;

            if (n < num)
                break;
        }

        long start = num - bits * sum;
        long bit = n - start;

        if (bit % bits == 0)
            return (int) (bit / bits + start) % 10;
        else
            return String.valueOf((bit / bits + largest - sum + 1)).charAt((int) (bit % bits - 1)) - '0';
    }
}
