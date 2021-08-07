package medium;

@SuppressWarnings("unused")
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int high = (int)Math.sqrt(c), low = 0;
        while (high != low)
        {
            if (high * high + low * low > c)
                high--;
            else if (high * high + low * low <c)
                low++;
            else
                return true;
        }

        if (high * high + low * low == c)
            return true;
        else
            return false;
    }
}
