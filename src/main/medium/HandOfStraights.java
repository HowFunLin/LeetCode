package main.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

@SuppressWarnings("unused")
public class HandOfStraights {
    /**
     * 846. 一手顺子
     *
     * @param hand      整数数组 hand 其中 hand[i] 是第 i 张牌的数字
     * @param groupSize 重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成
     * @return 可能重新排列这些牌，返回 true ；否则，返回 false
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : hand) {
            set.add(i);
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        while (!set.isEmpty()) {
            int first = set.first();

            for (int i = first; i < first + groupSize; i++) {
                Integer num = map.get(i);

                if (num == null || num - 1 < 0)
                    return false;

                if (num - 1 == 0)
                    set.remove(i);

                map.put(i, num - 1);
            }
        }

        return true;
    }
}
