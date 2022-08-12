package main.medium;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    /**
     * 1282. 用户分组
     *
     * @param groupSizes groupSizes[i] 是第 i 个人所在的组的大小
     * @return 一个组列表，使每个人 i 都在一个大小为 groupSizes[i] 的组中。每个人应该 恰好只 出现在 一个组 中，并且每个人必须在一个组中
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>[] lists = new List[n + 1]; // lists[i] 缓存长度为 i 的 List 对象

        for (int i = 0; i < n; i++) {
            int size = groupSizes[i];

            if (lists[size] == null)
                lists[size] = new ArrayList<>(size);

            lists[size].add(i);

            if (lists[size].size() == size) { // 当前 List 大小已满，加入结果集并移出数组
                res.add(lists[size]);
                lists[size] = null;
            }
        }

        return res;
    }
}
