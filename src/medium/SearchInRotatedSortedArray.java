package medium;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start = -1;
        int[] sorted = new int[nums.length];

        for (int i = 1; i < nums.length; i++)
            if (nums[i] < nums[i - 1])
                start = i;


        for (int i = start, j = 0; i < nums.length + start; i++, j++)
            sorted[j] = nums[i % nums.length];

        int left = 0, right = sorted.length - 1;

        while (left < right)
        {
            int middle = left + (right - left) / 2;

            if (sorted[middle] == target)
                return (start + middle) % nums.length;
            else if (sorted[middle] < target)
                left = middle + 1;
            else if (sorted[middle] > target)
                right = middle;
        }

        return -1;
    }
}
