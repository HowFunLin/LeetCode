package main.medium;

@SuppressWarnings("unused")
public class GasStation {
    /**
     * 134. 加油站
     *
     * @param gas  在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升
     * @param cost 从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升
     * @return 如果可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0, n = gas.length;

        while (i < n) {
            int sumGas = 0, sumCost = 0;
            int count = 0;

            while (count < n) {
                int index = (i + count) % n;

                sumGas += gas[index];
                sumCost += cost[index];

                if (sumCost > sumGas)
                    break;

                count++;
            }

            if (count == n)
                return i;
            else
                i += count + 1; // 由于从 i 开始到不了最后，从哪里结束则从下一个位置开始，从中间开始也只能最多到达结束的位置
        }

        return -1;
    }
}
