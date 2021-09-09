package lcci.easy;

import struct.ListNode;

@SuppressWarnings("unused")
public class IntersectionOfTwoLinkedLists {
    /**
     * 面试题 02.07. 链表相交
     *
     * @param headA 链表头节点
     * @param headB 链表头节点
     * @return 两个单链表相交的起始节点；如果两个链表没有交点，返回 null
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode a = headA, b = headB;

        while (a != null || b != null) {
            if (a == null)
                a = headB;
            if (b == null)
                b = headA;

            if (a == b)
                return a;

            a = a.next;
            b = b.next;
        }

        return null;
    }
}
