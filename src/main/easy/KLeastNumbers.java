package main.easy;

import java.util.Arrays;

public class KLeastNumbers
{
	public int[] getLeastNumbers(int[] arr, int k) {
		int[] result = new int[k];
		Arrays.sort(arr);
		
		for(int i = 0; i < k; i++)
			result[i] = arr[i];
		
		return result;
    }
}
