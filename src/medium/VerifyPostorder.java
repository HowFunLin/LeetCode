package medium;

@SuppressWarnings("unused")
public class VerifyPostorder {
    /**
     * 剑指 Offer 33. 二叉搜索树的后序遍历序列
     *
     * @param postorder 整数数组
     * @return 数组是否某二叉搜索树的后序遍历结果
     */
    public boolean verifyPostorder(int[] postorder) {
        return division(postorder, 0, postorder.length - 1);
    }

    /**
     * 分治判断二叉搜索树的左右子树
     *
     * @param postorder 整数数组
     * @param start     起始下标
     * @param end       结束下标
     * @return 数组是否某二叉搜索树的后序遍历结果
     */
    private boolean division(int[] postorder, int start, int end) {
        // 子树只有一个节点或者为空，完成匹配
        if (start >= end)
            return true;

        int pointer = start, root = postorder[end];

        while (postorder[pointer] < root)
            pointer++;

        int middle = pointer;

        while (postorder[pointer] > root)
            pointer++;

        // 还需判断end左边，middle右边的值，是否全部大于根节点
        return pointer == end && division(postorder, start, middle - 1) && division(postorder, middle, end - 1);
    }
}
