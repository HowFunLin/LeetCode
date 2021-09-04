package main.easy;

public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
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

        while (left <= right)
        {
            int mid = (left + right) / 2;

            if (arr[mid] > arr[mid + 1])
            {
                res = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }

        return res;
    }
}
