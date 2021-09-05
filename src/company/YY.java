package company;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class YY {
    /**
     * 找到数组中的一个点，满足前面的节点均比它小，后面的节点均比它大，首尾不输出
     *
     * @param data 数组
     * @return 所有符合条件的节点
     */
    public static ArrayList<Double> findPoints(double[] data) {
        int length = data.length;

        double[] maxArr = new double[length];
        double[] minArr = new double[length];

        // Double.MIN_VALUE 会出现错误
        double min = Double.MAX_VALUE, max = Integer.MIN_VALUE;

        // 构建最大和最小数组
        for (int i = 0; i < length; i++) {
            if (data[i] > max)
                max = data[i];

            maxArr[i] = max;
        }

        for (int i = length - 1; i >= 0; i--) {
            if (data[i] < min)
                min = data[i];

            minArr[i] = min;
        }

        ArrayList<Double> res = new ArrayList<>();

        // 只要当前节点符合最大和最小值均为自己，则为所需结果
        for (int i = 1; i < length - 1; i++) {
            if (maxArr[i] == minArr[i])
                res.add(data[i]);
        }

        return res;
    }
}
