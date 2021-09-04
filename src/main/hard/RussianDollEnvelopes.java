package main.hard;

//import main.medium.LongestIncreasingSubsequence;

import java.util.Arrays;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int[] h = new int[n];
        for (int i = 0; i < n; i++)
            h[i] = envelopes[i][1];

//        return LongestIncreasingSubsequence.lengthOfLIS(h);
        return lengthOfLIS(h);
    }

    private int lengthOfLIS(int[] nums)
    {
        int n = nums.length;
        int[] top = new int[n];
        int heaps = 0;

        for (int i = 0; i < n; i++)
        {
            int now = nums[i];

            int left = 0, right = heaps;
            while (left < right)
            {
                int mid = left + (right - left) / 2;

                if (top[mid] > now)
                    right = mid;
                else if (top[mid] < now)
                    left = mid + 1;
                else
                    right = mid;
            }

            if (left == heaps)
                heaps++;
            top[left] = now;
        }

        return heaps;
    }
}
