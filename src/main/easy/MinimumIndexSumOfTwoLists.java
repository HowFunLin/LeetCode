package main.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class MinimumIndexSumOfTwoLists {
    /**
     * 599. 两个列表的最小索引总和
     *
     * @param list1 最喜爱餐厅的列表
     * @param list2 最喜爱餐厅的列表
     * @return 共同喜爱且具有最小索引和的餐厅
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> restaurantToIndex = new HashMap<>();

        for (int i = 0; i < list1.length; i++)
            restaurantToIndex.put(list1[i], i);

        List<String> res = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length; i++) {
            String restaurant = list2[i];

            if (restaurantToIndex.containsKey(restaurant)) {
                int curSum = restaurantToIndex.get(restaurant) + i;

                if (curSum <= minSum) {
                    if (curSum < minSum) {
                        minSum = curSum;

                        res.clear();
                    }

                    res.add(restaurant);
                }
            }
        }

        return res.toArray(new String[0]);
    }
}
