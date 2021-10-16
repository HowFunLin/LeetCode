package lcci.easy;

import struct.ListNode;

@SuppressWarnings("unused")
public class DeleteMiddleNode {
    /**
     * 面试题 02.03. 删除中间节点
     *
     * @param node 已知链表的某一个中间节点，将该节点从链表中删除
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
