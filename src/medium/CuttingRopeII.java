package medium;

public class CuttingRopeII {
    public int cuttingRope(int n) {
        if (n < 4)
            return n - 1;

        long res = 1L;
        while (n > 4) {
            res = res * 3 % 1000000007;
            n -= 3;
        }

        return (int) (res * n % 1000000007);
    }
}
