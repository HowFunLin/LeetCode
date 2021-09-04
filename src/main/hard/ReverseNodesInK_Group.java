package main.hard;

import struct.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("unused")
public class ReverseNodesInK_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode pre = dummy;
//        ListNode tail = dummy;
//
//        while (true) {
//            int count = 0;
//
//            while (tail != null && count != k) {
//                count++;
//                tail = tail.next;
//            }
//
//            if (tail == null)
//                break;
//
//            ListNode head1 = pre.next;
//
//            while (pre.next != tail) {
//                ListNode cur = pre.next;
//                pre.next = cur.next;
//                cur.next = tail.next;
//                tail.next = cur;
//            }
//
//            pre = head1;
//            tail = head1;
//        }
//
//        return dummy.next;

        Deque<ListNode> stack = new ArrayDeque<ListNode>();
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (true) {
            int count = 0;
            ListNode tmp = head;
            while (tmp != null && count < k) {
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }
            if (count != k) {
                p.next = head;
                break;
            }
            while (!stack.isEmpty()) {
                p.next = stack.pollLast();
                p = p.next;
            }
            p.next = tmp;
            head = tmp;
        }
        return dummy.next;
    }
}
