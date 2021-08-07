package medium;

@SuppressWarnings("unused")
public class RepeatNumberBinarySearch {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;

            if (nums[middle] == target) {
                while (middle > 0 && nums[middle - 1] == target)
                    middle--;

                return middle;
            }

            if (nums[middle] <= target)
                low = middle + 1;
            else
                high = middle - 1;
        }

        return -1;
    }
}
