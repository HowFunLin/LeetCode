package main.easy;

public class SqrtX {
    public int mySqrt(int x) {
        int left = 0, right = x, sqrt = 0;

        while (left <= right)
        {
            int middle = left + (right - left) / 2;

            if (middle * middle <= x)
            {
                sqrt = middle;
                left = middle + 1;
            }
            else
                right = middle - 1;
        }

        return sqrt;
    }
}
