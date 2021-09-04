package main.easy;

public class GuessNumberHigherOrLower {
    private int pick = 6;

    public int guessNumber(int n) {
        int left = 1, right = n;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            if (guess(mid) > 0)
                left = mid + 1;
            else if (guess(mid) < 0)
                right = mid - 1;
            else
                return mid;
        }

        return -1;
    }

    private int guess(int num)
    {
        return num - pick;
    }
}
