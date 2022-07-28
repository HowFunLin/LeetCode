package main.easy;

import java.util.Arrays;
import java.util.HashMap;

@SuppressWarnings("unused")
public class RankTransformOfAnArray {
    /**
     * 1331. 数组序号转换
     *
     * @return 将数组 arr 中的每个元素替换为它们排序后的序号后的结果
     */
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];

        System.arraycopy(arr, 0, temp, 0, n); // 比 clone() 效率稍快
        Arrays.sort(temp);

        HashMap<Integer, Integer> number2Rank = new HashMap<>();
        int index = 0;

        for (int number : temp)
            // 使用下标会导致重复元素的序号不一致，因此使用自增 index 结合 Map 判断
            if (!number2Rank.containsKey(number))
                number2Rank.put(number, ++index);

        for (int i = 0; i < n; i++)
            arr[i] = number2Rank.get(arr[i]);

        return arr;
    }
}
