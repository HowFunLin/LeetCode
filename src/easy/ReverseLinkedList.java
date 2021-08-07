package easy;

import struct.ListNode;

@SuppressWarnings("unused")
public class ReverseLinkedList {
    // 递归解法
    public ListNode reverseList(ListNode head) {
        return head == null ? head : recur(head);
    }

    private ListNode recur(ListNode node)
    {
        ListNode result = null;

        if (node.next != null)
            result = recur(node.next);

        if (node.next == null)
            return node;

        node.next.next = node;
        node.next = null;

        return result;
    }
}
