package week;

import struct.TreeNode;

import java.util.*;

/**
 * 第 283 场周赛
 */
@SuppressWarnings("unused")
public class Game_283 {
    /**
     * 6016. Excel 表中某个范围内的单元格
     *
     * @param s 格式为 "col1row1:col2row2" 的字符串 s，其中 col1 表示 c1 列，row1 表示 r1 行，col2 表示 c2 列，row2 表示 r2 行，并满足 r1 <= r2 且 c1 <= c2
     * @return 列表形式用 字符串 表示，并以 非递减 顺序排列（先按列排，再按行排）的所有满足 r1 <= x <= r2 且 c1 <= y <= c2 的单元格
     */
    public List<String> cellsInRange(String s) {
        int start = s.charAt(1) - '0', end = s.charAt(4) - '0';
        char l = s.charAt(0), r = s.charAt(3);
        List<String> res = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            for (int j = start; j <= end; j++) {
                res.add((char) i + "" + j);
            }
        }

        return res;
    }

    /**
     * 6017. 向数组中追加 K 个整数
     *
     * @param nums 整数数组
     * @param k    整数
     * @return 向 nums 中追加 k 个 未 出现在 nums 中的、互不相同 的 正 整数，并使结果数组的元素和 最小 的 k 个整数之和
     */
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);

        long res = 0;
        int start = 1;

        for (int i = 0; i < nums.length && k > 0; i++) {
            if (start < nums[i]) { // 若满足该条件，则说明 nums[i - 1] 与 nums[i] 之间存在至少一个 start
                int count = nums[i] - start > k ? k : nums[i] - start;
                res += (long) (start + start + count - 1) * count / 2;
                k -= count;
            }

            start = nums[i] + 1; // 首项最小只能从当前数的下一个开始
        }

        if (k > 0)
            res += (long) (start + start + k - 1) * k / 2;

        return res;
    }

    /**
     * 6018. 根据描述创建二叉树
     *
     * @param descriptions 二维整数数组 descriptions ，其中 descriptions[i] = [parent, child, isLeft] 表示 parent 是 child 在 二叉树 中的 父节点，二叉树中各节点的值 互不相同。如果 isLeft == 1 ，那么 child 就是 parent 的左子节点；反之，为右子节点
     * @return 根据 descriptions 的描述构造得到的二叉树的根节点
     */
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, Integer> map = new HashMap<>();
        TreeNode[] tree = new TreeNode[100001];

        for (int[] description : descriptions) {
            int parent = description[0], child = description[1], isLeft = description[2];

            if (tree[parent] == null)
                tree[parent] = new TreeNode(parent);

            if (tree[child] == null)
                tree[child] = new TreeNode(child);

            if (isLeft == 1)
                tree[parent].left = tree[child];
            else
                tree[parent].right = tree[child];

            map.put(child, parent);
        }

        int child = descriptions[0][1];

        while (map.containsKey(child))
            child = map.get(child);

        return tree[child];
    }
}
