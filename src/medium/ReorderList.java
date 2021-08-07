package medium;

import struct.ListNode;

import java.util.LinkedList;

public class ReorderList {
    public void reorderList(ListNode head) {
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode dummy = new ListNode(0);
        ListNode last = dummy;

        while (head != null) {
            queue.offer(head);
            head = head.next;
        }

        while (!queue.isEmpty()) {
            ListNode first = queue.pollFirst(), second = null;

            if (queue.peekLast() != null)
                second = queue.pollLast();

            last.next = first;
            first.next = second;

            if (second != null)
                second.next = null;

            last = second;
        }

        head = dummy.next;
    }
}
