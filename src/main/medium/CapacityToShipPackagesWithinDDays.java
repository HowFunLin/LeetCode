package main.medium;

@SuppressWarnings("unused")
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int D) {
        int max = 0;
        int min = 0;

        // 最大载重区间
        for (int weight : weights) {
            max += weight;
            min = weight > min ? weight : min;
        }

        // 二分查找寻找最合适载重
        while (min < max) {
            int mid = (max + min) / 2;
            int day = 0;

            for (int i = 0; i < weights.length; day++) {
                int sum = 0;

                while (i < weights.length && sum + weights[i] <= mid) {
                    sum += weights[i];
                    i++;
                }
            }

            if (day <= D)
                max = mid;
            else if (day > D)
                min = mid + 1;
        }

        return max;
    }
}
