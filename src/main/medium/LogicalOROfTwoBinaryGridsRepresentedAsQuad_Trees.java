package main.medium;

@SuppressWarnings("all")
public class LogicalOROfTwoBinaryGridsRepresentedAsQuad_Trees {
    /**
     * 558. 四叉树交集
     *
     * @return 表示 n * n 二进制矩阵的四叉树，它是 quadTree1 和 quadTree2 所表示的两个二进制矩阵进行 按位逻辑或运算 的结果
     */
    public Node intersect(Node quadTree1, Node quadTree2) {
        // 以 quadTree1 为基准进行 OR 运算

        // 两个节点均为叶子节点
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            quadTree1.val |= quadTree2.val;

            return quadTree1;
        }

        // 其中一个为叶子节点
        if (quadTree1.isLeaf != quadTree2.isLeaf) {
            if (quadTree1.isLeaf)
                return quadTree1.val ? quadTree1 : quadTree2;
            else
                return quadTree2.val ? quadTree2 : quadTree1;
        }

        // 构建四个子节点
        quadTree1.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        quadTree1.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        quadTree1.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        quadTree1.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

        if (quadTree1.topLeft.isLeaf && quadTree1.topRight.isLeaf
                && quadTree1.bottomLeft.isLeaf && quadTree1.bottomRight.isLeaf // 所有子节点均为叶子节点才可进行 val 比较
                && quadTree1.topLeft.val == quadTree1.topRight.val && quadTree1.topRight.val == quadTree1.bottomLeft.val
                && quadTree1.bottomLeft.val == quadTree1.bottomRight.val // 所有子节点的 val 相同，需对当前节点进行重新设置
        ) {
            quadTree1.isLeaf = true;
            quadTree1.val = quadTree1.topLeft.val;

            quadTree1.topLeft = null;
            quadTree1.topRight = null;
            quadTree1.bottomLeft = null;
            quadTree1.bottomRight = null;
        }

        return quadTree1;
    }
}
