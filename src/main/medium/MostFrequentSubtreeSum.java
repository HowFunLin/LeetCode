package main.medium;

import struct.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class MostFrequentSubtreeSum {
    private Map<Integer, Integer> map = new HashMap<>();
    private int max;

    /**
     * 508. 出现次数最多的子树元素和
     *
     * @param root 二叉树的根结点
     * @return 出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);

        List<Integer> temp = new LinkedList<>();

        for (Map.Entry<Integer, Integer> times : map.entrySet()) {
            if (times.getValue() == max)
                temp.add(times.getKey());
        }

        int[] res = new int[temp.size()];
        int i = 0;

        for (Integer value : temp) {
            res[i++] = value;
        }

        return res;
    }

    /**
     * 深度优先遍历
     *
     * @return 当前节点 node 的子树元素和
     */
    private int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int left = dfs(node.left), right = dfs(node.right);

        int cur = left + right + node.val;

        map.put(cur, map.getOrDefault(cur, 0) + 1);
        max = Math.max(max, map.get(cur));

        return cur;
    }
}
