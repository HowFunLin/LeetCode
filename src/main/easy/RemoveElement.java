package main.easy;

@SuppressWarnings("unused")
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] != val)
                nums[index++] = nums[i];
        }

        return nums.length == 0 ? 0 : index;
    }
}
