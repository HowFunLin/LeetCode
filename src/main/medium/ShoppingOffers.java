package main.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class ShoppingOffers {
    private Map<List<Integer>, Integer> memory = new HashMap<>(); // 记忆化搜索，记录所有可能

    /**
     * 638. 大礼包
     *
     * @param price   物品价格，其中 price[i] 是第 i 件物品的价格
     * @param special 大礼包，special[i] 的长度为 n + 1 ，其中 special[i][j] 表示第 i 个大礼包中内含第 j 件物品的数量，
     *                且 special[i][n] （也就是数组中的最后一个整数）为第 i 个大礼包的价格
     * @param needs   购物清单，其中 needs[i] 是需要购买第 i 件物品的数量
     * @return 确切 满足购物清单所需花费的最低价格，不能购买超出购物清单指定数量的物品，任意大礼包可无限次购买
     */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();

        List<List<Integer>> worthySpecial = new ArrayList<>();

        // 仅保留可节省开销的大礼包
        for (List<Integer> cur : special) {
            int sum = 0, count = 0;

            for (int i = 0; i < n; i++) {
                count += cur.get(i); // 防止空包
                sum += cur.get(i) * price.get(i);
            }

            if (count > 0 && sum > cur.get(n))
                worthySpecial.add(cur);
        }

        return dfs(price, worthySpecial, needs, n);
    }

    /**
     * 深度优先遍历 + 记忆化搜索
     *
     * @param price   物品价格，其中 price[i] 是第 i 件物品的价格
     * @param special 筛选过的大礼包，去除空包以及不划算包
     * @param needs   购买某个大礼包之后剩余的购物清单，其中 needs[i] 是需要购买第 i 件物品的数量
     * @param n       在售物品件数
     * @return 确切 满足购物清单所需花费的最低价格，不能购买超出购物清单指定数量的物品，任意大礼包可无限次购买
     */
    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int n) {
        if (!memory.containsKey(needs)) // ArrayList重写了equals方法会对元素进行比较，剪枝防止重复进入
        {
            int min = 0;

            for (int i = 0; i < n; i++)
                min += needs.get(i) * price.get(i); // 若最终无大礼包可购买，仅能单买

            for (List<Integer> cur : special) {
                ArrayList<Integer> nextNeeds = new ArrayList<>();
                int specialPrice = cur.get(n);

                for (int i = 0; i < n; i++) {
                    if (cur.get(i) > needs.get(i))
                        break;

                    nextNeeds.add(needs.get(i) - cur.get(i));
                }

                if (nextNeeds.size() == n)
                    min = Math.min(min, dfs(price, special, nextNeeds, n) + specialPrice); // 存在可购买礼包，继续递归寻找
            }

            memory.put(needs, min);
        }

        return memory.get(needs);
    }
}
