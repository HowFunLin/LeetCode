package main.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class FairCandySwap {
    /**
     * 888. 公平的糖果交换
     *
     * @param aliceSizes aliceSizes[i] 是爱丽丝拥有的第 i 盒糖果中的糖果数量
     * @param bobSizes   bobSizes[j] 是鲍勃拥有的第 j 盒糖果中的糖果数量
     * @return 整数数组 answer，其中 answer[0] 是爱丽丝必须交换的糖果盒中的糖果的数目，answer[1] 是鲍勃必须交换的糖果盒中的糖果的数目。
     * 交换之后，他们拥有相同总数量的糖果
     */
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int alice = Arrays.stream(aliceSizes).sum(), bob = Arrays.stream(bobSizes).sum();
        int delta = (alice - bob) / 2;

        Set<Integer> set = new HashSet<>();

        for (int aliceSize : aliceSizes)
            set.add(aliceSize);

        int[] res = new int[2];

        for (int bobSize : bobSizes) {
            int aliceSize = bobSize + delta;

            if (set.contains(aliceSize)) {
                res[0] = aliceSize;
                res[1] = bobSize;

                break;
            }
        }

        return res;
    }
}
