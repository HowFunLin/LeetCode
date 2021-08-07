package medium;

public class Pow {
    public double myPow(double x, int n) {
        if (x == 0)
            return 0;

        double res = 1;
        long long_n = n;

        if (n < 0)
        {
            x = 1 / x;
            long_n = -long_n;
        }

        while (long_n > 0)
        {
            if ((long_n & 1) == 1)
                res *= x;

            x *= x;
            long_n >>= 1;
        }

        return res;
    }
}
