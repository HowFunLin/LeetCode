package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unused")
public class BeautifulArrangement {
    private List<Integer> arrangement;
    private Set<Integer> visited;
    private int n;
    private int sum = 0;

    /**
     * <h3>526. 优美的排列</h3>
     * 第 i 位的数字能被 i 整除 或者 i 能被第 i 位上的数字整除
     *
     * @param n 从 1 到 N 的 N 个整数，从这 N 个数字中构造出一个数组
     * @return 可以构造优美的排列的个数
     */
    public int countArrangement(int n) {
        arrangement = new ArrayList<>(n);
        visited = new HashSet<>(n);
        this.n = n;

        for (int i = 1; i <= n; i++)
            recur(i);

        return sum;
    }

    /**
     * 回溯算法
     *
     * @param num 当前要加入排列的整数
     */
    private void recur(int num) {
        arrangement.add(num);
        visited.add(num);

        if (num % arrangement.size() == 0 || arrangement.size() % num == 0) {
            if (arrangement.size() == n)
                sum++;
            else {
                for (int i = 1; i <= n; i++) {
                    if (visited.contains(i))
                        continue;

                    recur(i);
                }
            }
        }

        arrangement.remove(arrangement.size() - 1);
        visited.remove(num);
    }
}
