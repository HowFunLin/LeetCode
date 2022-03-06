package week;

import java.util.*;

/**
 * 第 73 场双周赛
 */
@SuppressWarnings("unused")
public class Double_Game_73 {
    /**
     * 6024. 数组中紧跟 key 之后出现最频繁的数字
     *
     * @param nums 整数数组
     * @param key  整数
     * @return 出现 最多 次数的 target。不同整数 target 的出现次数为满足以下条件的 i 的数目：0 <= i <= n - 2，nums[i] == key 且 nums[i + 1] == target 
     */
    public int mostFrequent(int[] nums, int key) {
        int[] times = new int[1001];

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key)
                times[nums[i + 1]]++;
        }

        int max = Integer.MIN_VALUE, res = -1;

        for (int i = 0; i < 1001; i++) {
            if (times[i] > max) {
                max = times[i];
                res = i;
            }
        }

        return res;
    }

    /**
     * 5217. 将杂乱无章的数字排序
     *
     * @param mapping 整数数组 mapping ，表示一个十进制数的映射规则，mapping[i] = j 表示这个规则下将数位 i 映射为数位 j。一个整数 映射后的值 为将原数字每一个数位 i （0 <= i <= 9）映射为 mapping[i]
     * @param nums    整数数组
     * @return 将数组 nums 中每个数按照它们映射后对应数字非递减顺序排序后的结果。如果两个数字映射后对应的数字大小相同，则将它们按照输入中的 相对顺序 排序；nums 中的元素只有在排序的时候需要按照映射后的值进行比较，返回的值应该是输入的元素本身
     */
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++)
            arr[i] = nums[i];

        for (int num : nums) {
            int res = 0, temp = num, times = 1;

            if (temp == 0)
                res = mapping[0];

            while (temp != 0) {
                res += mapping[temp % 10] * times;
                temp /= 10;
                times *= 10;
            }

            map.put(num, res);
        }

        Arrays.sort(arr, Comparator.comparingInt(map::get));

        for (int i = 0; i < n; i++)
            nums[i] = arr[i];

        return nums;
    }

    /**
     * 5300. 有向无环图中一个节点的所有祖先
     *
     * @param n     正整数 n ，表示一个 有向无环图 中节点的数目，节点编号为 0 到 n - 1
     * @param edges 二维整数数组 edges ，其中 edges[i] = [from, to] 表示图中一条从 from 到 to 的单向边
     * @return 数组 answer，其中 answer[i]是第 i 个节点的所有 祖先 ，这些祖先节点 升序 排序。如果 u 通过一系列边，能够到达 v ，那么我们称节点 u 是节点 v 的 祖先 节点
     */
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        List<Set<Integer>> demo = new ArrayList<>(); // TreeSet 去重并排序

        int[] in = new int[n]; // 入度数组，-1 表示从图中移除
        boolean[][] grid = new boolean[n][n]; // 邻接矩阵

        for (int[] edge : edges) {
            in[edge[1]]++;
            grid[edge[0]][edge[1]] = true;
        }

        Queue<Integer> queue = new LinkedList<>();

        // 初始化数组
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                queue.offer(i);
                in[i]--;
            }

            res.add(new ArrayList<>());
            demo.add(new TreeSet<>());
        }

        // 拓扑排序
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                int index = queue.poll();

                for (int i = 0; i < n; i++) {
                    if (grid[index][i]) {
                        in[i]--;
                        demo.get(i).add(index);
                        demo.get(i).addAll(demo.get(index));
                    }

                    if (in[i] == 0) {
                        queue.offer(i);
                        in[i]--;
                    }
                }

                size--;
            }
        }

        for (int i = 0; i < n; i++)
            res.get(i).addAll(demo.get(i));

        return res;
    }
}
