package main.medium;

@SuppressWarnings("unused")
public class ConstructQuadTree {
    /**
     * 427. 建立四叉树
     *
     * @param grid n * n 矩阵 grid ，矩阵由若干 0 和 1 组成
     * @return 能表示矩阵的 四叉树 的根结点
     */
    public Node construct(int[][] grid) {
        int n = grid.length;

        return construct(grid, 0, 0, n - 1, n - 1);
    }

    private Node construct(int[][] grid, int left, int top, int right, int bottom) {
        if (left == right)
            return new Node(grid[top][left] == 1, true);
        else {
            Node topLeft = construct(grid, left, top, (left + right - 1) / 2, (top + bottom - 1) / 2);
            Node topRight = construct(grid, (left + right + 1) / 2, top, right, (top + bottom - 1) / 2);
            Node bottomLeft = construct(grid, left, (top + bottom + 1) / 2, (left + right - 1) / 2, bottom);
            Node bottomRight = construct(grid, (left + right + 1) / 2, (top + bottom + 1) / 2, right, bottom);

            if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val)
                return new Node(topLeft.val, true);
            else
                return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}

class Node {
    /**
     * 储存叶子结点所代表的区域的值，1 对应 True，0 对应 False
     */
    public boolean val;
    /**
     * 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False
     */
    public boolean isLeaf;

    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}