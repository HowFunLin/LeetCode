package week;

import struct.ListNode;
import struct.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 第 270 场周赛
 */
@SuppressWarnings("unused")
public class Game_270 {
    private StringBuilder builder = new StringBuilder();
    private Set<Integer> result = new HashSet<>();
    private Set<Integer> indexes = new HashSet<>();
    private String path;

    /**
     * 5942. 找出 3 位偶数
     *
     * @param digits 整数数组，其中每个元素是一个数字（0 - 9）。数组中可能存在重复元素
     * @return 所有满足条件的互不相同的整数按 递增顺序 排列形成的数组。整数由 digits 中的三个元素按 任意 顺序 依次连接 组成；不含 前导零；是一个 偶数
     */
    public int[] findEvenNumbers(int[] digits) {
        backtrack(digits);

        int size = result.size();

        int[] res = new int[size];

        int i = 0;
        for (int r : result)
            res[i++] = r;

        Arrays.sort(res);

        return res;
    }

    /**
     * 回溯
     *
     * @param digits 整数数组，其中每个元素是一个数字（0 - 9）。数组中可能存在重复元素
     */
    private void backtrack(int[] digits) {
        if (builder.length() == 3) {
            int res = Integer.valueOf(builder.toString());

            if (res % 2 == 0)
                result.add(res);

            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (builder.length() == 0 && digits[i] != 0)
                continue;

            if ((digits[i] % 2) != 0 && builder.length() == 2)
                continue;

            if (!indexes.contains(i)) {
                indexes.add(i);
                builder.append(digits[i]);
                backtrack(digits);
                builder.deleteCharAt(builder.length() - 1);
                indexes.remove(i);
            }
        }
    }

    /**
     * 5943. 删除链表的中间节点
     *
     * @param head 链表的头节点
     * @return 删除 链表的 中间节点 后的链表的头节点 head 。长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始）
     */
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null)
            return null;
        if (head.next.next == null) {
            head.next = null;
            return head;
        }

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.val = slow.next.val;
        slow.next = slow.next.next;

        return head;
    }

    /**
     * 5944. 从二叉树一个节点到另一个节点每一步的方向
     *
     * @param root       二叉树 的根节点。二叉树节点值互补相同
     * @param startValue 起点节点 s 的值
     * @param destValue  终点节点 t 的值
     * @return 从节点 s 到节点 t 的 最短路径 每一步的方向。'L' 表示从一个节点前往它的 左孩子 节点；'R' 表示从一个节点前往它的 右孩子 节点；'U' 表示从一个节点前往它的 父 节点
     */
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode ancestor = lowestCommonAncestor(root, startValue, destValue);

        dfs(ancestor, "", startValue, destValue, 0, false, false);

        builder.append(path);

        return builder.toString();
    }

    /**
     * 深度优先遍历
     *
     * @param node        当前遍历节点
     * @param path        当前遍历路径
     * @param startValue  起点节点 s 的值
     * @param destValue   终点节点 t 的值
     * @param i           起始节点距离遍历开始的节点的深度
     * @param isFindStart 是否已找到起始节点
     * @param isFindDest  是否已找到终点节点
     */
    private void dfs(TreeNode node, String path, int startValue, int destValue, int i, boolean isFindStart, boolean isFindDest) {
        if (node == null)
            return;

        if (isFindStart && isFindDest)
            return;

        if (node.val == startValue) {
            for (int j = 0; j < i; j++)
                builder.append('U');

            isFindStart = true;
        }

        if (node.val == destValue) {
            this.path = path;

            isFindDest = true;
        }

        dfs(node.left, path + "L", startValue, destValue, i + 1, isFindStart, isFindDest);
        dfs(node.right, path + "R", startValue, destValue, i + 1, isFindStart, isFindDest);
    }

    /**
     * 节点的最近公共祖先
     *
     * @param root 二叉树根节点
     * @param p    节点值
     * @param q    节点值
     * @return 节点值对应的节点的最近公共祖先节点
     */
    private TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null)
            return null;

        if (root.val == p || root.val == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;

        if (left == null && right == null)
            return null;

        return left == null ? right : left;
    }
}
