package easy;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class IncreasingOrderSearchTree {
    private List<Integer> list = new ArrayList<Integer>();

    public TreeNode increasingBST(TreeNode root) {
        mid(root);

        TreeNode head = new TreeNode();
        TreeNode next = head;

        for (Integer aList : list) {
            next.right = new TreeNode(aList);
            next = next.right;
        }

        return head.right;
    }

    private void mid(TreeNode root) {
        if (root.left != null)
            mid(root.left);
        list.add(root.val);
        if (root.right != null)
            mid(root.right);
    }
}
