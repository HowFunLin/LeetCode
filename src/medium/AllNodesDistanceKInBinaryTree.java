package medium;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllNodesDistanceKInBinaryTree {
    private Map<Integer, TreeNode> childToParent = new HashMap<>();
    private List<Integer> res = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root);

        findResult(target, null, 0, k);

        return res;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            dfs(root.left);
            childToParent.put(root.left.val, root);
        }

        if (root.right != null) {
            dfs(root.right);
            childToParent.put(root.right.val, root);
        }
    }

    private void findResult(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null)
            return;

        if (depth == k) {
            res.add(node.val);
            return;
        }

        // 分别与from比较，防止由下向上或由上向下访问结点时，又递归访问了刚访问的结点
        // 例如下面两种情况，在由子节点向父节点访问时，只能满足一种情况，避免继续访问已访问的左或右结点
        if (node.left != from)
            findResult(node.left, node, depth + 1, k);

        if (node.right != from)
            findResult(node.right, node, depth + 1, k);

        // 下面的情况适用于父节点访问子节点时，不会再继续访问父节点
        if (childToParent.get(node.val) != from)
            findResult(childToParent.get(node.val), node, depth + 1, k);
    }
}
