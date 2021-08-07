package medium;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> pancakeSort(int[] arr) {
        sort(arr, arr.length);
        return result;
    }

    private void sort(int[] arr, int n)
    {
        if (n == 1)
            return;

        int max = 0, index = -1;

        for (int i = 0; i < n; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
                index = i;
            }
        }

        reverse(arr, 0, index);
        result.add(index);
        reverse(arr, 0, n);
        result.add(n);

        sort(arr, n - 1);
    }

    private void reverse(int[] arr, int low, int high)
    {
        while (low < high)
        {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            low++;
            high--;
        }
    }
}
