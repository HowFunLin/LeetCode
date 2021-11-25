package struct;

public class Swap {
    /**
     * 交换数组元素位置
     *
     * @param nums 整数数组
     * @param i    元素下标
     * @param j    元素下标
     */
    public static void swapInt(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
