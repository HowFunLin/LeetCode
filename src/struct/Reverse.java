package struct;

public class Reverse {
    /**
     * 反转整数数组
     *
     * @param nums  数组
     * @param left  起始下标
     * @param right 结束下标
     */
    public static void reverseInt(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

    /**
     * 反转字符数组
     *
     * @param s     字符数组
     * @param left  左指针
     * @param right 右指针
     */
    public static void reverseChar(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
