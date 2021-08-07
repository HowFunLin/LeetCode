package struct;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args){  
        int[] nums = new int[]{1, 5, 2, 6, 8};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));;
    }

    public static void quickSort(int[] arr, int left, int right)
    {
        if (left < right)
        {
            int temp = partition(arr, left, right);
            quickSort(arr, left, temp - 1);
            quickSort(arr, temp + 1, right);
        }
    }
    
    private static int partition(int[] arr, int left, int right)
    {
        int pivot = arr[left];
        
        while (left < right)
        {
            while (left < right && arr[right] > pivot)
                right--;
            
            arr[left] = arr[right];
            
            while (left < right && arr[left] < pivot)
                left++;
            
            arr[right] = arr[left];
        }
        
        arr[left] = pivot;
        
        return left;
    }
}
