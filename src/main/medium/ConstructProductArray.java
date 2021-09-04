package main.medium;

@SuppressWarnings("unused")
public class ConstructProductArray {
    /**
     * 剑指 Offer 66. 构建乘积数组
     *
     * @param a 数组 A[0,1,…,n-1]
     * @return 数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]
     */
    public int[] constructArr(int[] a) {
        int length = a.length;
        int[] prefix = new int[length], suffix = new int[length], res = new int[length];

        if (length == 0)
            return res;

        prefix[0] = a[0];
        suffix[length - 1] = a[length - 1];

        for (int i = 1; i < length; i++)
            prefix[i] = a[i] * prefix[i - 1];
        for (int i = length - 2; i >= 0; i--)
            suffix[i] = a[i] * suffix[i + 1];

        res[0] = suffix[1];
        res[length - 1] = prefix[length - 2];

        for (int i = 1; i < length - 1; i++)
            res[i] = prefix[i - 1] * suffix[i + 1];

        return res;
    }
}
