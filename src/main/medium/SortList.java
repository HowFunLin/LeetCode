package main.medium;

import struct.ListNode;

@SuppressWarnings("unused")
public class SortList {
    /**
     * 148. 排序链表
     *
     * @param head 链表的头结点
     * @return 升序排序后的链表
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head, fast = head.next;

        // fast 节点仅用于 slow 节点切分链表，可为 null
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow.next;
        slow.next = null;

        // 归并排序
        ListNode left = sortList(head);
        ListNode right = sortList(temp);

        ListNode h = new ListNode();
        ListNode dummy = h; // 带头节点

        // 对排序后的链表进行合并
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }

            h = h.next;
        }

        h.next = left != null ? left : right;

        return dummy.next;
    }
}
