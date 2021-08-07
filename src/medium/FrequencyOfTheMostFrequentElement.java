package medium;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 1;
        int left = 0;
        long total = 0;

        for (int right = 1; right < nums.length; right++)
        {
            total += (long) (nums[right] - nums[right - 1]) * (right - left);

            while (total > k)
            {
                total -= nums[right] - nums[left];
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
