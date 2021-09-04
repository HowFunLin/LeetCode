package main.hard;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerticalOrderTraversalOfABinaryTree {
    List<Integer>[][] table = new List[1000][2000];


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(root, 0, 0);

        for (int col = 0; col < 2000; col++) {
            List<Integer> list = new ArrayList<>();

            for (int row = 0; row < 1000; row++) {
                if (table[row][col] == null)
                    continue;

                if (table[row][col].size() > 1) {
                    Collections.sort(table[row][col]);

                    for (int num : table[row][col])
                        list.add(num);
                } else
                    list.add(table[row][col].get(0));
            }

            if (list.size() > 0)
                res.add(list);
        }

        return res;
    }

    private void dfs(TreeNode node, int row, int col) {
        if (table[row][col + 1000] == null)
            table[row][col + 1000] = new ArrayList();

        table[row][col + 1000].add(node.val);

        if (node.left != null)
            dfs(node.left, row + 1, col - 1);
        if (node.right != null)
            dfs(node.right, row + 1, col + 1);
    }
}
