package medium;

@SuppressWarnings("unused")
public class SmallestK_LCCI {
    /**
     * 面试题 17.14. 最小K个数
     *
     * @param arr 数组
     * @param k   整数
     * @return 任意顺序返回数组中最小的k个数
     */
    public int[] smallestK(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);

        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);

        return res;
    }

    /**
     * 改进快速排序
     *
     * @param arr   数组
     * @param left  起始
     * @param right 结束
     * @param k     整数
     */
    private void quickSort(int[] arr, int left, int right, int k) {
        if (left < right) {
            int temp = partition(arr, left, right);

            if (temp > k)
                quickSort(arr, left, temp - 1, k);
            if (temp < k)
                quickSort(arr, temp + 1, right, k);
        }
    }

    /**
     * 分治
     *
     * @param arr        数组
     * @param startIndex 起始
     * @param endIndex   结束
     * @return 已确定位置的下标
     */
    private int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[endIndex];
        int i = startIndex;

        // 每有一个小于支点，i++定位支点应该处在的坐标
        for (int j = startIndex; j <= endIndex - 1; j++) {
            if (arr[j] < pivot) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }

        // i 所在的位置的数 >= 支点
        int temp = arr[endIndex];
        arr[endIndex] = arr[i];
        arr[i] = temp;

        return i;
    }
}
