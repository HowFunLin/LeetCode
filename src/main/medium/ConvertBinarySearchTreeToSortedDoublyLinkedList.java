package main.medium;

import struct.Node;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    Node tail, head;

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;

        dfs(root);

        head.left = tail;
        tail.right = head;

        return head;
    }

    private void dfs(Node root) {
        if (root.left != null)
            dfs(root.left);

        if (tail != null)
            tail.right = root;
        else
            head = root;

        root.left = tail;
        tail = root;

        if (root.right != null)
            dfs(root.right);
    }
}
