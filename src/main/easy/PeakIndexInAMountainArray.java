package main.easy;

@SuppressWarnings("unused")
public class PeakIndexInAMountainArray {
    /**
     * 852. 山脉数组的峰顶索引
     *
     * @param arr 山脉数组，符合下列属性：
     *            <div>1. arr.length >= 3；</div>
     *            2. 存在 i（0 < i < arr.length - 1）使得：
     *            <div>① arr[0] < arr[1] < ... arr[i-1] < arr[i]</div>
     *            ② arr[i] > arr[i+1] > ... > arr[arr.length - 1]
     * @return 任何满足的下标 i
     */
    public int peakIndexInMountainArray(int[] arr) {
//        // O(n)
//        int peak = -1, index = -1;
//
//        for (int i = 0; i < arr.length; i++)
//        {
//            if (arr[i] > peak)
//            {
//                peak = arr[i];
//                index = i;
//            }
//        }
//
//        return index;

        int n = arr.length;
        int left = 0, right = n - 2, res = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] > arr[mid + 1]) {
                res = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }

        return res;
    }
}
