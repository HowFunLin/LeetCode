package main.medium;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class CanIWin {
    private Map<Integer, Boolean> memory = new HashMap<>(); // 记忆化搜索

    /**
     * 464. 我能赢吗
     *
     * @param maxChoosableInteger 整数池中可选择的最大数
     * @param desiredTotal        累计和
     * @return 先出手的玩家是否能稳赢。先使得累计整数和 达到或超过 100 的玩家，即为胜者
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 等差数列求和判断题目数据是否满足计算条件
        if ((((1 + maxChoosableInteger) * maxChoosableInteger) >> 1) < desiredTotal)
            return false;

        return dfs(maxChoosableInteger, 0, desiredTotal, 0);
    }

    /**
     * @param usedNumbers 二进制位取代数组表示数字是否已经被使用
     */
    private boolean dfs(int maxChoosableInteger, int usedNumbers, int desiredTotal, int currentTotal) {
        if (!memory.containsKey(usedNumbers)) {
            boolean res = false;

            for (int i = 0; i < maxChoosableInteger; i++) {
                // 当前数字尚未被使用
                if (((usedNumbers >> i) & 1) == 0) {
                    // usedNumbers | (1 << i) 记录已经使用过的数字
                    if (i + 1 + currentTotal >= desiredTotal || !dfs(maxChoosableInteger, usedNumbers | (1 << i), desiredTotal, currentTotal + i + 1)) {
                        res = true;
                        break;
                    }
                }
            }

            memory.put(usedNumbers, res);
        }

        // memory 存储除去当前被使用数字后的先手玩家能否获胜
        return memory.get(usedNumbers);
    }
}
