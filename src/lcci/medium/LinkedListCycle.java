package lcci.medium;

import struct.ListNode;

@SuppressWarnings("unused")
public class LinkedListCycle {
    /**
     * 面试题 02.08. 环路检测
     *
     * @param head 链表头节点
     * @return 如果是有环链表，返回环路的开头节点；若环不存在，返回 null
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                break;
            }
        }

        while (slow != null && fast != null) {
            if (slow == fast)
                return slow;

            slow = slow.next;
            fast = fast.next;
        }

        return null;
    }
}
