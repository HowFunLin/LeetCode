package main.easy;

import struct.TreeNode;

public class SecondMinimumNodeInABinaryTree {
    private int root_value;
    private int res;

    public int findSecondMinimumValue(TreeNode root) {
        res = -1;
        root_value = root.val;

        dfs(root);

        return res;
    }

    private void dfs(TreeNode root)
    {
        if (root == null)
            return;

        // res已经被赋值过且当前结点值大于res，无需继续往下遍历
        if (res != -1 && root.val > res)
            return;

        // 当前结点值大于根结点，且由于之前的判断，不大于res
        if (root.val > root_value)
            res = root.val;

        dfs(root.left);
        dfs(root.right);
    }
}
