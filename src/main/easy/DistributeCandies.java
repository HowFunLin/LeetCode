package main.easy;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class DistributeCandies {
    /**
     * 575. 分糖果
     *
     * @param candyType Alice 有 n 枚糖，第 i 枚糖的类型为 candyType[i]
     * @return Alice 在仅吃掉 n / 2 枚糖的情况下，可以吃到糖的最多种类数
     */
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        int nums = candyType.length / 2;

        for (int type : candyType)
            set.add(type);

        return set.size() >= nums ? nums : set.size();
    }
}
